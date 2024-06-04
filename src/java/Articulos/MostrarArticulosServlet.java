package Articulos;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import DAO.ArticuloDAO;
import DAO.UsuarioDAO;
import Tablas.Articulos;
import javax.servlet.annotation.WebServlet;
import java.math.BigDecimal;

@WebServlet(name = "MostrarArticuloServlet", urlPatterns = {"/MostrarArticulo"})
public class MostrarArticulosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Creamos una instancia de ArticuloDAO
        ArticuloDAO articuloDAO = new ArticuloDAO();

        // Obtenemos la categoría desde el request
        String categoria = request.getParameter("categoria");

        // Declaramos la lista de artículos
        List<Articulos> listaDeArticulos;

        // Si se ha proporcionado una categoría, obtenemos los artículos por categoría
        if (categoria != null && !categoria.isEmpty()) {
            listaDeArticulos = articuloDAO.obtenerArticulosPorCategoria(categoria);
        } else {
            // Si no se proporciona una categoría, obtenemos todos los artículos
            listaDeArticulos = articuloDAO.obtenerTodosLosArticulos();
        }

        // Cerramos la conexión con la base de datos
        articuloDAO.close();

        // Obtenemos el usuario de la sesión
        HttpSession session = request.getSession();
        String nombreUsuario = (String) session.getAttribute("usuario");

        // Si el usuario está en la sesión, obtenemos el saldo de la hucha
        System.out.println(nombreUsuario+ "puto");
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            BigDecimal saldoHucha = usuarioDAO.obtenerSaldoHucha(nombreUsuario);
            usuarioDAO.close();

            // Establecemos el saldo de la hucha como atributo en el request
            request.setAttribute("saldoHucha", saldoHucha);
        
        System.out.println("el dinero es " + saldoHucha);
        // Establecemos las listas de artículos como atributos en el request
        request.setAttribute("listaDeArticulos", listaDeArticulos);

        // Redirigimos la solicitud a Tienda.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("Tienda.jsp");
        dispatcher.forward(request, response);
    }
}
