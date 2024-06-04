/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.80
 * Generated at: 2024-06-04 13:39:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.math.BigDecimal;

public final class Home2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.math.BigDecimal");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <title>ZigZag Tienda</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/templatemo.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/custom.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/fontawesome.min.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- Start Nav -->\n");
      out.write("        <nav class=\"navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block\" id=\"templatemo_nav_top\">\n");
      out.write("            <div class=\"container text-light\">\n");
      out.write("                <div class=\"w-100 d-flex justify-content-between\">\n");
      out.write("                    <div>\n");
      out.write("                        <i class=\"fa fa-envelope mx-2\"></i>\n");
      out.write("                        <a class=\"navbar-sm-brand text-light text-decoration-none\" href=\"mailto:info@company.com\">Zigzag@gmail.com</a>\n");
      out.write("                        <i class=\"fa fa-phone mx-2\"></i>\n");
      out.write("                        <a class=\"navbar-sm-brand text-light text-decoration-none\" href=\"tel:010-020-0340\">+34-123-456-789</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <a class=\"text-light\" href=\"https://fb.com/templatemo\" target=\"_blank\" rel=\"sponsored\"><i class=\"fab fa-facebook-f fa-sm fa-fw me-2\"></i></a>\n");
      out.write("                        <a class=\"text-light\" href=\"https://www.instagram.com/\" target=\"_blank\"><i class=\"fab fa-instagram fa-sm fa-fw me-2\"></i></a>\n");
      out.write("                        <a class=\"text-light\" href=\"https://twitter.com/\" target=\"_blank\"><i class=\"fab fa-twitter fa-sm fa-fw me-2\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <!-- Close Nav -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--Start Header -->\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light shadow\">\n");
      out.write("            <div class=\"container d-flex justify-content-between align-items-center\">\n");
      out.write("                <img class=\"imgIconopagina\" src=\"https://cdn.icon-icons.com/icons2/3395/PNG/512/zigzag_shape_icon_214057.png\" alt=\"iconoPagina\">\n");
      out.write("                <a class=\"navbar-brand text-IconoPagina logo h1 align-self-center\" href=\"index.html\">\n");
      out.write("                    ZigZag\n");
      out.write("                </a>\n");
      out.write("\n");
      out.write("                <button class=\"navbar-toggler border-0\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#templatemo_main_nav\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <div class=\"align-self-center collapse navbar-collapse flex-fill  d-lg-flex  flex-direct flex-row\" id=\"templatemo_main_nav\">\n");
      out.write("                    <div class=\"flex-fill\">\n");
      out.write("                        <ul class=\"nav navbar-nav d-flex justify-content-between mx-lg-auto marg-1\">\n");
      out.write("                            ");
 if (session.getAttribute("usuario") != null && !session.getAttribute("usuario").equals("Trabajador1")) { 
      out.write("\n");
      out.write("                            <a class=\"nav-link\" href=\"Home2.jsp\">Home</a>\n");
      out.write("                            ");
 } else if (session.getAttribute("usuario").equals("Trabajador1")) { 
      out.write("\n");
      out.write("                            <a class=\"nav-link\" href=\"Home2Trabajador.jsp\">Home</a>\n");
      out.write("                            ");
 } else if (session.getAttribute("usuario") == null) {
      out.write("\n");
      out.write("                            <a class=\"nav-link\" href=\"Home.jsp\">Home</a>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"SobreNosotros.jsp\">Sobre Nosotros</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"MostrarArticulo\">Tienda</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"\">Contacto</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"navbar align-self-center d-flex \">\n");
      out.write("                        <div class=\"d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3\">\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"inputMobileSearch\" placeholder=\"Search ...\">\n");
      out.write("                                <div class=\"input-group-text\">\n");
      out.write("                                    <i class=\"fa fa-fw fa-search\"></i>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a class=\"nav-icon d-none d-lg-inline\" href=\"#\" data-bs-toggle=\"modal\" data-bs-target=\"#templatemo_search\">\n");
      out.write("                            <i class=\"fa fa-fw fa-search text-dark mr-2\"></i>\n");
      out.write("                        </a>\n");
      out.write("\n");
      out.write("                        <!-- Agregar icono del carrito -->\n");
      out.write("                        <a class=\"nav-icon d-none d-lg-inline\" href=\"#\" data-bs-toggle=\"modal\" data-bs-target=\"#templatemo_search\">\n");
      out.write("                            <i class=\"fas fa-shopping-cart fa-fw text-dark mr-2\"></i>\n");
      out.write("                        </a>\n");
      out.write("\n");
      out.write("                        <div class=\"navbar align-self-center d-flex\">\n");
      out.write("                            <div class=\"dropdown\">\n");
      out.write("                                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                    ");
      out.print( session.getAttribute("usuario"));
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuLink\">\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"modificarDatos\">Modificar Datos</a></li>\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"donarRopa\">Donar Ropa</a></li>\n");
      out.write("                                        ");
 BigDecimal huchaUsuario = (BigDecimal) request.getAttribute("saldoHucha");
      out.write("\n");
      out.write("                                    <li style=\"margin-left:15px;\">");
      out.print( huchaUsuario != null ? huchaUsuario + "€" : "0.00€");
      out.write("</li>\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"cerrarSesion\">Cerrar Sesión</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <!-- Close Header -->\n");
      out.write("\n");
      out.write("        <!-- Start Modal de buscar-->\n");
      out.write("        <div class=\"modal fade bg-white\" id=\"templatemo_search\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog modal-lg\" role=\"document\">\n");
      out.write("                <div class=\"w-100 pt-1 mb-5 text-right\">\n");
      out.write("                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                </div>\n");
      out.write("                <form action=\"\" method=\"get\" class=\"modal-content modal-body border-0 p-0\">\n");
      out.write("                    <div class=\"input-group mb-2\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"inputModalSearch\" name=\"q\" placeholder=\"Search ...\">\n");
      out.write("                        <button type=\"submit\" class=\"input-group-text bg-success text-light\">\n");
      out.write("                            <i class=\"fa fa-fw fa-search text-white\"></i>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Close Modla -->\n");
      out.write("\n");
      out.write("        <!-- Carusel -->\n");
      out.write("        <div id=\"template-mo-zay-hero-carousel\" class=\"carousel slide\" data-bs-ride=\"carousel\">\n");
      out.write("            <ol class=\"carousel-indicators\">\n");
      out.write("                <li data-bs-target=\"#template-mo-zay-hero-carousel\" data-bs-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                <li data-bs-target=\"#template-mo-zay-hero-carousel\" data-bs-slide-to=\"1\"></li>\n");
      out.write("                <li data-bs-target=\"#template-mo-zay-hero-carousel\" data-bs-slide-to=\"2\"></li>\n");
      out.write("            </ol>\n");
      out.write("            <div class=\"carousel-inner\">\n");
      out.write("                <div class=\"carousel-item active\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row p-5\">\n");
      out.write("                            <div class=\"mx-auto col-md-8 col-lg-6 order-lg-last\">\n");
      out.write("                                <img class=\"img-fluid\" src=\"./assets/img/banner_img_01.jpg\" alt=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-6 mb-0 d-flex align-items-center\">\n");
      out.write("                                <div class=\"text-align-left align-self-center\">\n");
      out.write("                                    <h1 class=\"h1 text-success\"><b>ZigZag</b> Comercio</h1>\n");
      out.write("                                    <h3 class=\"h2\">Tu Estilo, Nuestro Compás de Moda.</h3>\n");
      out.write("                                    <p>\n");
      out.write("                                        Explora el universo de la moda con Zigzag, donde la tendencia y la originalidad se entrelazan. Encuentra ropa y accesorios únicos que reflejen tu estilo individual. Con Zigzag, cada elección es un giro hacia la autenticidad y la elegancia.\n");
      out.write("                                    </p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"carousel-item\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row p-5\">\n");
      out.write("                            <div class=\"mx-auto col-md-8 col-lg-6 order-lg-last\">\n");
      out.write("                                <img class=\"img-fluid\" src=\"./assets/img/banner_img_02.jpg\" alt=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-6 mb-0 d-flex align-items-center\">\n");
      out.write("                                <div class=\"text-align-left\">\n");
      out.write("                                    <h1 class=\"h1\">Explora nuestros productos</h1>\n");
      out.write("                                    <h3 class=\"h2\">Encontraras lo que buscas</h3>\n");
      out.write("                                    <p>\n");
      out.write("                                        En Zigzag, la calidad es nuestro hilo conductor; cada prenda y accesorio está tejido con esmero para brindarte una experiencia de moda excepcional.\n");
      out.write("                                    </p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"carousel-item\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row p-5\">\n");
      out.write("                            <div class=\"mx-auto col-md-8 col-lg-6 order-lg-last\">\n");
      out.write("                                <img class=\"img-fluid\" src=\"./assets/img/banner_img_03.jpg\" alt=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-6 mb-0 d-flex align-items-center\">\n");
      out.write("                                <div class=\"text-align-left\">\n");
      out.write("                                    <h1 class=\"h1\">Envios seguros<i class=\"fas fa-check-circle p-2 text-success\"></i></h1>\n");
      out.write("                                    <p>\n");
      out.write("                                        Moda de calidad entregada directo a tu puerta. Envíos rápidos y seguros para que disfrutes de tus compras sin preocupaciones.\n");
      out.write("                                    </p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <a class=\"carousel-control-prev text-decoration-none w-auto ps-3\" href=\"#template-mo-zay-hero-carousel\" role=\"button\" data-bs-slide=\"prev\">\n");
      out.write("                <i class=\"fas fa-chevron-left\"></i>\n");
      out.write("            </a>\n");
      out.write("            <a class=\"carousel-control-next text-decoration-none w-auto pe-3\" href=\"#template-mo-zay-hero-carousel\" role=\"button\" data-bs-slide=\"next\">\n");
      out.write("                <i class=\"fas fa-chevron-right\"></i>\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <!-- End Carusel -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Start Categorias -->\n");
      out.write("        <section class=\"container py-5\">\n");
      out.write("            <div class=\"row text-center pt-3\">\n");
      out.write("                <div class=\"col-lg-6 m-auto\">\n");
      out.write("                    <h1 class=\"h1\">Las mejores categorias este mes</h1>\n");
      out.write("                    <p>\n");
      out.write("                        Adentrate en las categorias mas destacados durante este mes de <strong class=\"text-success\">Febrero</strong>!\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-12 col-md-4 p-5 mt-3\">\n");
      out.write("                    <a href=\"MostrarArticulo?categoria=4\"><img src=\"./assets/img/category_img_01.jpg\" class=\"rounded-circle img-fluid border\"></a>\n");
      out.write("                    <h5 class=\"text-center mt-3 mb-3\">Accesorios</h5>\n");
      out.write("                    <p class=\"text-center\"><a href=\"MostrarArticulo?categoria=4\" class=\"btn btn-success\">Comprar</a></p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-12 col-md-4 p-5 mt-3\">\n");
      out.write("                    <a href=\"MostrarArticulo?categoria=3\"><img src=\"./assets/img/category_img_02.jpg\" class=\"rounded-circle img-fluid border\"></a>\n");
      out.write("                    <h2 class=\"h5 text-center mt-3 mb-3\">Calzado</h2>\n");
      out.write("                    <p class=\"text-center\"><a href=\"MostrarArticulo?categoria=3\" class=\"btn btn-success\">Comprar</a></p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-12 col-md-4 p-5 mt-3\">\n");
      out.write("                    <a href=\"MostrarArticulo?categoria=1\"><img src=\"./assets/img/category_img_03.jpg\" class=\"rounded-circle img-fluid border\"></a>\n");
      out.write("                    <h2 class=\"h5 text-center mt-3 mb-3\">Ropa de Mujer</h2>\n");
      out.write("                    <p class=\"text-center\"><a href=\"MostrarArticulo?categoria=1\" class=\"btn btn-success\">Comprar</a></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- End Categorias -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Start Footer -->\n");
      out.write("        <footer class=\"bg-dark\" id=\"tempaltemo_footer\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-4 pt-5\">\n");
      out.write("                        <h2 class=\"h2 text-success border-bottom pb-3 border-light logo\">ZigZag</h2>\n");
      out.write("                        <ul class=\"list-unstyled text-light footer-link-list\">\n");
      out.write("                            <li>\n");
      out.write("                                <i class=\"fas fa-map-marker-alt fa-fw\"></i>\n");
      out.write("                                Calle Pamplona 4\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <i class=\"fa fa-phone fa-fw\"></i>\n");
      out.write("                                <a class=\"text-decoration-none\" href=\"tel:010-020-0340\">+34-123-456-789</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <i class=\"fa fa-envelope fa-fw\"></i>\n");
      out.write("                                <a class=\"text-decoration-none\" href=\"mailto:info@company.com\">ZigZag@gmail.com</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-4 pt-5\">\n");
      out.write("                        <h2 class=\"h2 text-light border-bottom pb-3 border-light\">Productos</h2>\n");
      out.write("                        <ul class=\"list-unstyled text-light footer-link-list\">\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"shop.html\">Ropa deportiva</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"shop.html\">Relojes Deportivos</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"shop.html\">Articulos de lujo</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"shop.html\">Zapatos Mujer</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"shop.html\">Vestidos</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"shop.html\">Accesorios de gym</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"shop.html\">Accesorios Unisex</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-4 pt-5\">\n");
      out.write("                        <h2 class=\"h2 text-light border-bottom pb-3 border-light\">Mas Información</h2>\n");
      out.write("                        <ul class=\"list-unstyled text-light footer-link-list\">\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"index.html\">Home</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"about.html\">Sobre Nosotros</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"shop.html\">Tienda</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"contact.html\">Contacto</a></li>\n");
      out.write("                            <li><a class=\"text-decoration-none\" href=\"registro.html\">Registro</a></li>\n");
      out.write("                            <li>\n");
      out.write("                                <a class=\"text-decoration-none\" href=\"administracion.html\"\n");
      out.write("                                   >Sugerir Ropa</a\n");
      out.write("                                >\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row text-light mb-4\">\n");
      out.write("                    <div class=\"col-12 mb-3\">\n");
      out.write("                        <div class=\"w-100 my-3 border-top border-light\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-auto me-auto\">\n");
      out.write("                        <ul class=\"list-inline text-left footer-icons\">\n");
      out.write("                            <li class=\"list-inline-item border border-light rounded-circle text-center\">\n");
      out.write("                                <a class=\"text-light text-decoration-none\" target=\"_blank\" href=\"http://facebook.com/\"><i class=\"fab fa-facebook-f fa-lg fa-fw\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"list-inline-item border border-light rounded-circle text-center\">\n");
      out.write("                                <a class=\"text-light text-decoration-none\" target=\"_blank\" href=\"https://www.instagram.com/\"><i class=\"fab fa-instagram fa-lg fa-fw\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"list-inline-item border border-light rounded-circle text-center\">\n");
      out.write("                                <a class=\"text-light text-decoration-none\" target=\"_blank\" href=\"https://twitter.com/\"><i class=\"fab fa-twitter fa-lg fa-fw\"></i></a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-auto\">\n");
      out.write("                        <label>Siguenos para no perderte ningun articulo nuevo!</label>\n");
      out.write("                        <label class=\"sr-only\" for=\"subscribeEmail\">Correo electronico</label>\n");
      out.write("                        <div class=\"input-group mb-2\">\n");
      out.write("                            <input type=\"text\" class=\"form-control bg-dark border-light text-white\" id=\"subscribeEmail\" placeholder=\"Correo electronico\">\n");
      out.write("                            <div class=\"input-group-text btn-success text-light\">Subscribe</div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"w-100 bg-black py-3\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row pt-2\">\n");
      out.write("                        <div class=\"col-12\">\n");
      out.write("                            <p class=\"text-left text-light\">\n");
      out.write("                                Copyright &copy; 2024 ZigZag \n");
      out.write("                                | Diseñado por Danil Loginov 2ºDAW\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </footer>\n");
      out.write("        <!-- End Footer -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"assets/js/jquery-1.11.0.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery-migrate-1.2.1.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/templatemo.js\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
