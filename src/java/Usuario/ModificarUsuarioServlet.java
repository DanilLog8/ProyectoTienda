package Usuario;

import DAO.UsuarioDAO;
import Tablas.Usuarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ModificarUsuarioServlet", urlPatterns = {"/ModificarUsuario"})
public class ModificarUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("usuarioId"));
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuarios usuario = usuarioDAO.obtenerUsuarioPorId(id);
        usuarioDAO.close();

        if (usuario != null) {
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
        } else {
            response.sendRedirect("MostrarUsuarios");
        }
    }
}