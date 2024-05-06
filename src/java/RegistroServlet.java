import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("usuario");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String confirmarContrasena = request.getParameter("confirmarContrasena");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        // Verificar si las contraseñas coinciden
        if (!contrasena.equals(confirmarContrasena)) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Las contraseñas no coinciden.');");
            out.println("window.location.href = 'registro.jsp';");
            out.println("</script>");
            return; // Terminar la ejecución del servlet
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Verificar si el usuario ya existe
        if (usuarioDAO.usuarioExiste(usuario)) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('El nombre de usuario ya está en uso.');");
            out.println("window.location.href = 'registro.jsp';");
            out.println("</script>");
        } else {
            // Registrar usuario en la base de datos y asignar tipo de usuario
            boolean registrado = usuarioDAO.registrarUsuario(usuario, correo, contrasena, telefono, direccion, "usuario");
            if (registrado) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('¡Registro exitoso!');");
                out.println("window.location.href = 'login.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error al registrar usuario. Inténtalo de nuevo más tarde.');");
                out.println("window.location.href = 'registro.jsp';");
                out.println("</script>");
            }
        }

        out.close();
    }
}
