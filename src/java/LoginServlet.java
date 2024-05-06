import DAO.UsuarioDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Verificar credenciales de inicio de sesi�n
        if (usuarioDAO.verificarUsuario(usuario, contrasena)) {
            // Iniciar sesi�n y guardar el nombre de usuario en la sesi�n
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            
            // Redirigir a la p�gina de inicio o a otra p�gina deseada
            response.sendRedirect("Home2.jsp");
            System.out.println("Nombre de usuario en la sesi�n: " + usuario);
        } else {
            // Si las credenciales son incorrectas, mostrar mensaje de error y redirigir a la p�gina de inicio de sesi�n
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Usuario o contrase�a incorrectos.');");
            out.println("window.location.href = 'login.jsp';");
            out.println("</script>");
        }

        out.close();
    }
}
