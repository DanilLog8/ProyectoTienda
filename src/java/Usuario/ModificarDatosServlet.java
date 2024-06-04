package Usuario;

import DAO.UsuarioDAO;
import Tablas.Usuarios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ModificarDatosServlet", urlPatterns = {"/modificarDatos"})
public class ModificarDatosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nombreUsuario = (String) session.getAttribute("usuario");
        System.out.println(nombreUsuario);
        if (nombreUsuario != null) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuarios usuario = usuarioDAO.obtenerUsuario(nombreUsuario);
            request.setAttribute("usuario", usuario);
            System.out.println(usuario);
            request.getRequestDispatcher("/modificarDatos.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
