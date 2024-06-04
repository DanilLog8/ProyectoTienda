package Articulos;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import Tablas.Articulos;
import DAO.ArticuloDAO;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ComprarArticuloServlet", urlPatterns = {"/ComprarArticulo"})
public class ComprarArticuloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del artículo de la solicitud
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));

        // Crear una instancia de ArticuloDAO
        ArticuloDAO articuloDAO = new ArticuloDAO();

        // Obtener el artículo por su ID
        Articulos articulo = articuloDAO.obtenerArticuloPorID(idProducto);

        // Cerrar la conexión con la base de datos
        articuloDAO.close();

        // Establecer el artículo como atributo en el request
        request.setAttribute("articulo", articulo);

        // Redirigir la solicitud a DetallesArticulo.jsp para mostrar los detalles del artículo
        RequestDispatcher dispatcher = request.getRequestDispatcher("ComprarArticulo.jsp");
        dispatcher.forward(request, response);
    }
}
