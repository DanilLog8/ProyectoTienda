package Usuario;

import DAO.UsuarioDAO;
import Tablas.Usuarios;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

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
        Usuarios usuarioEspecifico = usuarioDAO.obtenerUsuario(usuario);
        BigDecimal hucha = usuarioEspecifico != null ? usuarioEspecifico.getHucha() : BigDecimal.ZERO;
        request.setAttribute("huchaUsuario", hucha);
        
        if (usuarioDAO.verificarUsuario(usuario, contrasena)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            // Determinar el tipo de usuario y redirigir
            String tipoUsuario = usuarioEspecifico.getTipoUsuario();
            session.setAttribute("tipoUsuario", tipoUsuario);
            System.out.println(tipoUsuario);
            if ("usuario".equals(tipoUsuario)) {
                response.sendRedirect("Home2.jsp");
            } else if ("trabajador".equals(tipoUsuario)) {
                response.sendRedirect("Home2Trabajador.jsp");
            }

            System.out.println("Nombre de usuario en la sesión: " + usuario);
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Usuario o contraseña incorrectos.');");
            out.println("window.location.href = 'login.jsp';");
            out.println("</script>");
        }

        out.close();
    }
}
