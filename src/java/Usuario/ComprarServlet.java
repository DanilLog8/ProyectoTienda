
import DAO.ArticuloDAO;
import DAO.ArticuloTallaDAO;
import DAO.ArticuloTallapieDAO;
import DAO.TarjetasDAO;
import DAO.UsuarioDAO;
import Tablas.Articulos;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/comprar")
public class ComprarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ArticuloDAO articuloDAO = new ArticuloDAO();
            ArticuloTallaDAO articuloTallaDAO = new ArticuloTallaDAO();
            ArticuloTallapieDAO articuloTallapieDAO = new ArticuloTallapieDAO();
            TarjetasDAO tarjetasDAO = new TarjetasDAO();

            String idArticuloStr = request.getParameter("idProducto");
            String idTallaStr = request.getParameter("talla");
            BigDecimal precioArticulo = articuloDAO.obtenerPrecioArticulo(Integer.parseInt(idArticuloStr));

            Integer idTalla = null;
            if ("S".equals(idTallaStr)) {
                idTalla = 1;
            } else if ("M".equals(idTallaStr)) {
                idTalla = 2;
            } else if ("L".equals(idTallaStr)) {
                idTalla = 3;
            } else if ("XL".equals(idTallaStr)) {
                idTalla = 4;
            } else if ("XS".equals(idTallaStr)) {
                idTalla = 5;
            } else if ("XXL".equals(idTallaStr)) {
                idTalla = 6;
            }

            Integer idArticulo = Integer.parseInt(idArticuloStr);

            Articulos articulo = articuloDAO.obtenerArticuloPorID(idArticulo);
            if (articulo == null) {
                throw new IllegalArgumentException("Artículo no encontrado");
            }

            HttpSession session = request.getSession();
            String nombreUsuario = (String) session.getAttribute("usuario");
            String numeroTarjeta = request.getParameter("numeroTarjeta");
            String cvcTarjeta = request.getParameter("cvcTarjeta");
            BigDecimal saldoHucha = BigDecimal.ZERO;
            saldoHucha = usuarioDAO.obtenerSaldoHucha(nombreUsuario);

            if (!tarjetasDAO.validarTarjeta(numeroTarjeta, cvcTarjeta)) {
                // Tarjeta no válida
                request.setAttribute("error", "La tarjeta no es válida");
                request.getRequestDispatcher("response.jsp").forward(request, response);
                return;
            }

            BigDecimal saldoTarjeta = tarjetasDAO.obtenerSaldoTarjeta(numeroTarjeta);
            BigDecimal cantidadTotalPagar = precioArticulo.subtract(saldoHucha);

            if (cantidadTotalPagar.compareTo(BigDecimal.ZERO) < 0) {
                // No hay saldo suficiente para pagar con la tarjeta
                request.setAttribute("error", "No hay saldo suficiente para pagar con la tarjeta");
                request.getRequestDispatcher("response.jsp").forward(request, response);
                return;
            }

            if (cantidadTotalPagar.compareTo(saldoTarjeta) > 0) {
                // El saldo en la tarjeta no es suficiente
                request.setAttribute("error", "El saldo en la tarjeta no es suficiente");
                request.getRequestDispatcher("response.jsp").forward(request, response);
                return;
            }

            if (!tarjetasDAO.descontarDinero(numeroTarjeta, cantidadTotalPagar)) {
                // Error al descontar el dinero de la tarjeta
                request.setAttribute("error", "Error al descontar el dinero de la tarjeta");
                request.getRequestDispatcher("response.jsp").forward(request, response);
                return;
            }

            // Descuenta el dinero de la hucha si se ha utilizado
            if (saldoHucha.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal diferencia = precioArticulo.subtract(saldoHucha);
                BigDecimal nuevoSaldoHucha = saldoHucha.subtract(diferencia);
                usuarioDAO.actualizarSaldoHucha(nombreUsuario, nuevoSaldoHucha);
            }

            String catalogo = articulo.getNombreCatalogo();
            if ("2".equals(catalogo) || "1".equals(catalogo)) {
                articuloTallaDAO.actualizarArticuloTalla(idArticulo, idTalla);
            } else if ("3".equals(catalogo)) {
                articuloTallapieDAO.actualizarArticuloTallaPie(idArticulo, idTalla);
            }
            articuloDAO.ComprarArticulo(articulo);

            // Redireccionar a una página de confirmación o mostrar un mensaje de éxito
            request.setAttribute("success", "La compra se realizó exitosamente");
            request.getRequestDispatcher("response.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Los parámetros proporcionados son inválidos");
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }
}
