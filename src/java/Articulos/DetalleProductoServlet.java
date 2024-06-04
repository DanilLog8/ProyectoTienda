package Articulos;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ArticuloDAO;
import Tablas.ArticuloTalla;
import Tablas.Articulos;

@WebServlet("/DetalleProductoServlet")
public class DetalleProductoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenemos el ID del producto de la solicitud
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        
        // Llamamos al método del DAO para obtener los detalles del producto
        ArticuloDAO articulosDAO = new ArticuloDAO();
        Articulos articulo = articulosDAO.obtenerArticuloPorID(idProducto);
        
        // Obtener las tallas disponibles y las cantidades disponibles para este artículo
        List<String> tallasDisponibles = articulosDAO.obtenerTallasDisponiblesPorID(idProducto);
        List<Integer> cantidadesDisponibles = articulosDAO.obtenerCantidadesDisponiblesPorID(idProducto);
        
        // Seteamos el objeto Articulo, las tallas y las cantidades disponibles en el request y lo enviamos al JSP
        request.setAttribute("articulo", articulo);
        request.setAttribute("tallasDisponibles", tallasDisponibles);
        request.setAttribute("cantidadesDisponibles", cantidadesDisponibles);
        request.getRequestDispatcher("DetalleProducto.jsp").forward(request, response);
    }
}
