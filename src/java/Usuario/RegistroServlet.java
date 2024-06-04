package Usuario;


import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            String usuario = request.getParameter("usuario");
            String correo = request.getParameter("correo");
            String contrasena = request.getParameter("contrasena");
            String confirmarContrasena = request.getParameter("confirmarContrasena");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String fechaNacimientoString = request.getParameter("fechaNacimiento");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
            Date fechaNac = sdf.parse(fechaNacimientoString);
            
            if (!contrasena.equals(confirmarContrasena)) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Las contraseñas no coinciden.');");
                out.println("window.location.href = 'registro.jsp';");
                out.println("</script>");
            }
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            if (usuarioDAO.usuarioExiste(usuario)) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('El nombre de usuario ya está en uso.');");
                out.println("window.location.href = 'registro.jsp';");
                out.println("</script>");
            } else {
                boolean registrado = usuarioDAO.registrarUsuario(usuario, correo, contrasena, telefono, direccion, "usuario", fechaNac);
                
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
        } catch (ParseException ex) {
            Logger.getLogger(RegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
