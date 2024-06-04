package Usuario;


import DAO.UsuarioDAO;
import Tablas.Usuarios;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ActualizarDatosServlet", urlPatterns = {"/actualizarDatos"})
public class ActualizarDatosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String fechaNacimientoString = request.getParameter("fechaNacimiento");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
            Date fechaNac = sdf.parse(fechaNacimientoString);
            String nombreUsuario = (String) request.getSession().getAttribute("usuario");

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuarios usuario = usuarioDAO.obtenerUsuario(nombreUsuario);

            usuario.setTelefono(telefono);
            usuario.setDireccion(direccion);
            usuario.setFechaNacimiento(fechaNac);
            usuario.setEmail(correo);
            
            usuarioDAO.actualizarDatosUsuario(usuario);
            
            response.sendRedirect(request.getContextPath() + "/modificarDatos");
} catch (ParseException ex) {
            Logger.getLogger(ActualizarDatosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
          

