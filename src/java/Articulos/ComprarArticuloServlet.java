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
        // Obtener el ID del art�culo de la solicitud
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));

        // Crear una instancia de ArticuloDAO
        ArticuloDAO articuloDAO = new ArticuloDAO();

        // Obtener el art�culo por su ID
        Articulos articulo = articuloDAO.obtenerArticuloPorID(idProducto);

        // Cerrar la conexi�n con la base de datos
        articuloDAO.close();

        // Establecer el art�culo como atributo en el request
        request.setAttribute("articulo", articulo);

        // Redirigir la solicitud a DetallesArticulo.jsp para mostrar los detalles del art�culo
        RequestDispatcher dispatcher = request.getRequestDispatcher("ComprarArticulo.jsp");
        dispatcher.forward(request, response);
    }
}
