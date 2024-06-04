package Articulos;

import DAO.ArticuloDAO;
import DAO.ArticuloTallaDAO;
import DAO.ArticuloTallapieDAO;
import DAO.TallasDAO;
import Tablas.Articulos;
import Tablas.ArticuloTalla;
import Tablas.ArticuloTallapie;
import Tablas.Tallas;
import Tablas.Tallaspie;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AgregarArticuloServlet", urlPatterns = {"/AgregarArticulo"})
public class AgregarArticuloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            // Obtener los valores de los campos del formulario
            String nombre = request.getParameter("nombre");
            String precioParam = request.getParameter("precio");
            BigDecimal precio = null;
            if (precioParam != null && !precioParam.isEmpty()) {
                precio = new BigDecimal(precioParam);
            }
            String descripcion = request.getParameter("descripcion");
            String catalogo = request.getParameter("catalogo");
            String imagenURL = request.getParameter("imagen");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

            // Obtener las tallas seleccionadas en el formulario
            String[] tallasSeleccionadas = request.getParameterValues("tallas");

            // Crear el objeto Articulo
            Articulos articulo = new Articulos();
            articulo.setNombre(nombre);
            articulo.setPrecio(precio);
            articulo.setDescripcion(descripcion);
            articulo.setImagen(imagenURL);
            articulo.setNombreCatalogo(catalogo);
            if (tallasSeleccionadas == null) {
                articulo.setCantidadDisponible(cantidad);
            } else {
                articulo.setCantidadDisponible(cantidad * tallasSeleccionadas.length); // Calcular la cantidad disponible
            }

            // Guardar el artículo en la base de datos
            ArticuloDAO articuloDAO = new ArticuloDAO();
            boolean exito = articuloDAO.insertarArticulo(articulo);

            if (exito) {
                // Obtener el ID del artículo recién guardado
                int articuloId = articulo.getId();

                if (catalogo.equals("3")) {
                    ArticuloTallapieDAO articuloTallapieDAO = new ArticuloTallapieDAO();
                    for (String tallaIdString : tallasSeleccionadas) {
                        int tallaId = Integer.parseInt(tallaIdString);
                        ArticuloTallapie articuloTallapie = new ArticuloTallapie();
                        articuloTallapie.setIdArticulo(new Articulos(articuloId));
                        articuloTallapie.setIdtallaPie(new Tallaspie(tallaId));
                        articuloTallapie.setCantidadDisponible(cantidad);
                        articuloTallapieDAO.insertarArticuloTallapie(articuloTallapie);
                    }
                } else if (catalogo.equals("1") || catalogo.equals("2")) {
                    ArticuloTallaDAO articuloTallaDAO = new ArticuloTallaDAO();
                    for (String tallaIdString : tallasSeleccionadas) {
                        int tallaId = Integer.parseInt(tallaIdString);
                        ArticuloTalla articuloTalla = new ArticuloTalla();
                        articuloTalla.setIdArticulo(new Articulos(articuloId));
                        articuloTalla.setIdTalla(new Tallas(tallaId));
                        articuloTalla.setCantidadDisponible(cantidad);
                        articuloTallaDAO.insertarArticuloTalla(articuloTalla);
                    }
                }

                response.sendRedirect("Home2Trabajador.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            // Manejar cualquier excepción
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
