package Usuario;

import DAO.UsuarioDAO;
import Tablas.Usuarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ActualizarUsuarioServlet", urlPatterns = {"/ActualizarUsuario"})
public class ActualizarUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuarios usuario = usuarioDAO.obtenerUsuarioPorId(id);

        if (usuario != null) {
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setTelefono(telefono);
            usuario.setDireccion(direccion);
            usuarioDAO.actualizarDatosUsuario(usuario);
        }
        usuarioDAO.close();
        response.sendRedirect("MostrarUsuarios");
    }
}