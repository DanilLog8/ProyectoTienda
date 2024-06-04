package Catalogos;

import DAO.CatalogosDAO;
import DAO.TallasDAO;
import DAO.TallasPieDAO; 
import Tablas.Catalogos;
import Tablas.Tallas;
import Tablas.Tallaspie; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name= "MostrarCatalogos", urlPatterns = {"/MostrarCatalogos"})
public class MostrarCatalogos extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CatalogosDAO catalogosDAO = new CatalogosDAO();
        TallasDAO tallasDAO = new TallasDAO();
        TallasPieDAO tallasPieDAO = new TallasPieDAO(); // Crea una instancia del DAO de TallasPie

        List<Catalogos> catalogos = catalogosDAO.obtenerTodos();
        List<Tallas> listaDeTallas = tallasDAO.obtenerTodasLasTallas();
        List<Tallaspie> listaDeTallasPie = tallasPieDAO.obtenerTodasLasTallasPie(); // Obtiene todas las tallas de pie
        request.setAttribute("listaDeTallas", listaDeTallas);
        request.setAttribute("listaDeTallasPie", listaDeTallasPie); // Agrega la lista de tallas de pie al request
        request.setAttribute("catalogos", catalogos);
        request.getRequestDispatcher("AnadirArticulos.jsp").forward(request, response);
    }
}
