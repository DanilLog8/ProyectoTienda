import DAO.UsuarioDAO;
import Tablas.Usuarios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.NoResultException;

@WebServlet("/ModificarDatosServlet")
public class ModificarDatosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Obtener el nombre de usuario de la sesión
    String nombreUsuario = (String) request.getSession().getAttribute("usuario");

    // Imprimir el nombre de usuario en la consola
    System.out.println("Nombre de usuario en la sesión: " + nombreUsuario);

    // Crear una instancia de UsuarioDAO para acceder a la base de datos
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    
        // Obtener los datos del usuario de la base de datos
        Usuarios usuario = usuarioDAO.obtenerUsuario(nombreUsuario);

        // Establecer los atributos en el objeto request para enviarlos a modificarDatos.jsp
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("/modificarDatos.jsp").forward(request, response);
        
}

}
