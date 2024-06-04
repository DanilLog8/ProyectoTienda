package filtros;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/Home2Trabajador.jsp", "/AnadirArticulos.jsp"})
public class AccessControlFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // M�todo de inicializaci�n, si se necesita alg�n proceso
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("usuario") == null) {
            // Redirige al usuario a la p�gina de inicio de sesi�n si no hay sesi�n o usuario en sesi�n
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            String tipoUsuario = (String) session.getAttribute("tipoUsuario");
            if ("usuario".equals(tipoUsuario)) {
                // Si el tipo de usuario es 'usuario', redirige a Home2.jsp
                response.sendRedirect(request.getContextPath() + "/Home2.jsp");
            } else {
                // Si el tipo de usuario es diferente de 'usuario', permite el acceso a la p�gina solicitada
                chain.doFilter(req, resp);
            }
        }
    }

    public void destroy() {
        // M�todo de destrucci�n, si se necesita alg�n proceso
    }
}
