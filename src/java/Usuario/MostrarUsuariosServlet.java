package Usuario;

import DAO.UsuarioDAO;
import Tablas.Usuarios;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MostrarUsuariosServlet", urlPatterns = {"/MostrarUsuarios"})
public class MostrarUsuariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuarios> usuarios = usuarioDAO.obtenerUsuarios();
        usuarioDAO.close();

        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("mostrarUsuarios.jsp").forward(request, response);
    }
}