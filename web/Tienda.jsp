<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.List"%>
<%@page import="Tablas.Articulos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <title>ZigZag Tienda</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
        <style>
            .fixed-height-img {
                height: 350px; /* Ajusta la altura según tus necesidades */
                object-fit: cover; /* Asegura que la imagen se ajuste dentro de las dimensiones especificadas */
            }
        </style>
    </head>

    <body>
        <!-- Start Nav -->
        <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
            <div class="container text-light">
                <div class="w-100 d-flex justify-content-between">
                    <div>
                        <i class="fa fa-envelope mx-2"></i>
                        <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">Zigzag@gmail.com</a>
                        <i class="fa fa-phone mx-2"></i>
                        <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">+34-123-456-789</a>
                    </div>
                    <div>
                        <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                        <a class="text-light" href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                        <a class="text-light" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                    </div>
                </div>
            </div>
        </nav>
        <!-- Close Nav -->






        <!--Start Header -->
        <nav class="navbar navbar-expand-lg navbar-light shadow">
            <div class="container d-flex justify-content-between align-items-center">
                <img class="imgIconopagina" src="https://cdn.icon-icons.com/icons2/3395/PNG/512/zigzag_shape_icon_214057.png" alt="iconoPagina">
                <a class="navbar-brand text-IconoPagina logo h1 align-self-center" href="index.html">
                    ZigZag
                </a>

                <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex  flex-direct flex-row" id="templatemo_main_nav">
                    <div class="flex-fill">
                        <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto marg-1">
                            <% if (session.getAttribute("usuario") != null && !session.getAttribute("usuario").equals("Trabajador1")) { %>
                            <a class="nav-link" href="Home2.jsp">Home</a>
                            <% } else if (session.getAttribute("usuario").equals("Trabajador1")) { %>
                            <a class="nav-link" href="Home2Trabajador.jsp">Home</a>
                            <% } else if (session.getAttribute("usuario") == null) {%>
                            <a class="nav-link" href="Home.jsp">Home</a>
                            <%}%>
                            <li class="nav-item">
                                <a class="nav-link" href="SobreNosotros.jsp">Sobre Nosotros</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="MostrarArticulo">Tienda</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="contact.html">Contacto</a>
                            </li>
                        </ul>
                    </div>
                    <div class="navbar align-self-center d-flex ">
                        <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                            <div class="input-group">
                                <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                                <div class="input-group-text">
                                    <i class="fa fa-fw fa-search"></i>
                                </div>
                            </div>
                        </div>
                        <%
                            String usuario = (String) session.getAttribute("usuario");
                            if (usuario != null && !"Trabajador1".equals(usuario)) {
                        %>
                        <div class="navbar align-self-center d-flex">
                            <div class="dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="dropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <%= usuario%>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                    <li><a class="dropdown-item" href="modificarDatos">Modificar Datos</a></li>
                                    <li><a class="dropdown-item" href="donarRopa">Donar Ropa</a></li>
                                        <% BigDecimal huchaUsuario = (BigDecimal) request.getAttribute("saldoHucha");%>
                                    <li style="margin-left:15px;"><%= huchaUsuario != null ? huchaUsuario + "€" : "0.00€"%></li>
                                    <li><a class="dropdown-item" href="cerrarSesion">Cerrar Sesión</a></li>
                                </ul>
                            </div>
                        </div>
                        <a class="nav-icon d-none d-lg-inline" href="#" data-bs-toggle="modal" data-bs-target="#templatemo_search">
                            <i class="fas fa-shopping-cart fa-fw text-dark mr-2"></i>
                        </a>
                        <%
                            }
                        %>


                    </div>
                </div>

            </div>
        </nav>
        <!-- Close Header -->

        <!-- STart Modal de buscar-->
        <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="w-100 pt-1 mb-5 text-right">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="" method="get" class="modal-content modal-body border-0 p-0">
                    <div class="input-group mb-2">
                        <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                        <button type="submit" class="input-group-text bg-success text-light">
                            <i class="fa fa-fw fa-search text-white"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <!-- Close Modal -->



        <!-- Start Contenido -->
        <div class="container py-5">
            <div class="row">

                <div class="col-lg-3">
                    <h1 class="h2 pb-4">Categorías</h1>
                    <ul class="list-unstyled templatemo-accordion">
                        <form action="MostrarArticulo" method="post">
                            <li class="pb-3">
                                <a class="collapsed d-flex justify-content-between h3 text-decoration-none text-success" href="MostrarArticulo?categoria=">
                                    <span class="agrandar">Ver todo</span>
                                </a> 
                            </li>
                            <li class="pb-3">
                                <a class="collapsed d-flex justify-content-between h3 text-decoration-none text-success" href="MostrarArticulo?categoria=1">
                                    <span class="agrandar">Ropa de Mujer</span>
                                </a> 
                            </li>
                            <li class="pb-3">
                                <a class="collapsed d-flex justify-content-between h3 text-decoration-none text-success" href="MostrarArticulo?categoria=2">
                                    <span class="agrandar">Ropa de Hombre</span>
                                </a>
                            </li>
                            <li class="pb-3">
                                <a class="collapsed d-flex justify-content-between h3 text-decoration-none text-success" href="MostrarArticulo?categoria=3">
                                    <span class="agrandar">Calzado</span>
                                </a>
                            </li>
                            <li class="pb-3">
                                <a class="collapsed d-flex justify-content-between h3 text-decoration-none text-success" href="MostrarArticulo?categoria=4">
                                    <span class="agrandar">Accesorios</span>
                                </a>
                            </li>
                            <li class="pb-3">
                                <a class="collapsed d-flex justify-content-between h3 text-decoration-none text-success" href="MostrarArticulo?categoria=5">
                                    <span class="agrandar">Informática</span>
                                </a>
                            </li>
                            <li class="pb-3">
                                <a class="collapsed d-flex justify-content-between h3 text-decoration-none text-success" href="MostrarArticulo?categoria=6">
                                    <span class="agrandar">Niños</span>
                                </a>
                            </li>
                            <li class="pb-3">
                                <a class="collapsed d-flex justify-content-between h3 text-decoration-none text-success" href="MostrarArticulo?categoria=7">
                                    <span class="agrandar">Juguetes
                                </a>
                            </li>
                        </form>
                    </ul>
                </div>


                <div class="col-lg-9">
                    <div class="row">

                        <div class="container py-5">
                            <div class="row">
                                <%
                                    List<Articulos> listaDeArticulos = (List<Articulos>) request.getAttribute("listaDeArticulos");
                                    for (int i = 0; i < listaDeArticulos.size(); i++) {
                                        Articulos articulo = listaDeArticulos.get(i);
                                        if (i % 3 == 0) {
                                %>
                                <div class="row">
                                    <% }%>
                                    <div class="col-md-4">
                                        <div class="card mb-4 product-wap rounded-0 flex-direct-row">
                                            <div class="card rounded-0">
                                                <img class="card-img rounded-0 img-fluid fixed-height-img" src="<%= articulo.getImagen()%>" style="max-width: 100%; max-height: 350px;">
                                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                                    <ul class="list-unstyled">

                                                        <li><a class="btn btn-success text-white mt-2" href="DetalleProductoServlet?idProducto=<%= articulo.getId()%>"><i class="far fa-eye"></i></a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="card-body">
                                                <a href="shop-single.html" class="h3 text-decoration-none"><%= articulo.getNombre()%></a>
                                                <p class="text-center mb-0"><%= articulo.getPrecio()%>€</p>
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                        if ((i + 1) % 3 == 0 || i == listaDeArticulos.size() - 1) {
                                    %>
                                </div>
                                <% } %>
                                <% }%>
                            </div>
                        </div>



                    </div>

                </div>
            </div>
        </div>
        <!-- End Contenido -->

        <!-- Start Patrocinadores -->
        <section class="bg-light py-5">
            <div class="container my-4">
                <div class="row text-center py-3">
                    <div class="col-lg-6 m-auto">
                        <h1 class="h1">Nuestros patrocinadores</h1>
                        <p>
                            Descubre las mejores marcas de ropa y zapatos en nuestra tienda!
                        </p>
                    </div>
                    <div class="col-lg-9 m-auto tempaltemo-carousel">
                        <div class="row d-flex flex-row">
                            <!--Controles-->
                            <div class="col-1 align-self-center">
                                <a class="h1" href="#templatemo-slide-brand" role="button" data-bs-slide="prev">
                                    <i class="text-light fas fa-chevron-left"></i>
                                </a>
                            </div>
                            <!--End Controles-->

                            <!--Carusel-->
                            <div class="col">
                                <div class="carousel slide carousel-multi-item pt-2 pt-md-0" id="templatemo-slide-brand" data-bs-ride="carousel">
                                    <!--Slides-->
                                    <div class="carousel-inner product-links-wap" role="listbox">

                                        <!--First slide-->
                                        <div class="carousel-item active">
                                            <div class="row">
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_01.png" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_02.png" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_03.png" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_04.png" alt="Brand Logo"></a>
                                                </div>
                                            </div>
                                        </div>
                                        <!--End First slide-->

                                        <!--Second slide-->
                                        <div class="carousel-item">
                                            <div class="row">
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_05.png" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_06.png" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_07.png" alt="Brand Logo"></a>
                                                </div>
                                                <div class="col-3 p-md-5">
                                                    <a href="#"><img class="img-fluid brand-img" src="assets/img/brand_08.png" alt="Brand Logo"></a>
                                                </div>
                                            </div>
                                        </div>
                                        <!--End Second slide-->



                                    </div>
                                    <!--End Slides-->
                                </div>
                            </div>
                            <!--End Carusel-->

                            <!--Controles-->
                            <div class="col-1 align-self-center">
                                <a class="h1" href="#templatemo-slide-brand" role="button" data-bs-slide="next">
                                    <i class="text-light fas fa-chevron-right"></i>
                                </a>
                            </div>
                            <!--End Controles-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--End Patrocinadores-->


        <!-- Start Footer -->
        <footer class="bg-dark" id="tempaltemo_footer">
            <div class="container">
                <div class="row">

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-success border-bottom pb-3 border-light logo">ZigZag</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li>
                                <i class="fas fa-map-marker-alt fa-fw"></i>
                                Calle Pamplona 4
                            </li>
                            <li>
                                <i class="fa fa-phone fa-fw"></i>
                                <a class="text-decoration-none" href="tel:010-020-0340">+34-123-456-789</a>
                            </li>
                            <li>
                                <i class="fa fa-envelope fa-fw"></i>
                                <a class="text-decoration-none" href="mailto:info@company.com">ZigZag@gmail.com</a>
                            </li>
                        </ul>
                    </div>

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-light border-bottom pb-3 border-light">Productos</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li><a class="text-decoration-none" href="shop.html">Ropa deportiva</a></li>
                            <li><a class="text-decoration-none" href="shop.html">Relojes Deportivos</a></li>
                            <li><a class="text-decoration-none" href="shop.html">Articulos de lujo</a></li>
                            <li><a class="text-decoration-none" href="shop.html">Zapatos Mujer</a></li>
                            <li><a class="text-decoration-none" href="shop.html">Vestidos</a></li>
                            <li><a class="text-decoration-none" href="shop.html">Accesorios de gym</a></li>
                            <li><a class="text-decoration-none" href="shop.html">Accesorios Unisex</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-light border-bottom pb-3 border-light">Mas Información</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li><a class="text-decoration-none" href="index.html">Home</a></li>
                            <li><a class="text-decoration-none" href="about.html">Sobre Nosotros</a></li>
                            <li><a class="text-decoration-none" href="shop.html">Tienda</a></li>
                            <li><a class="text-decoration-none" href="contact.html">Contacto</a></li>
                            <li><a class="text-decoration-none" href="registro.html">Registro</a></li>
                            <li>
                                <a class="text-decoration-none" href="administracion.html"
                                   >Sugerir Ropa</a
                                >
                            </li>
                        </ul>
                    </div>

                </div>

                <div class="row text-light mb-4">
                    <div class="col-12 mb-3">
                        <div class="w-100 my-3 border-top border-light"></div>
                    </div>
                    <div class="col-auto me-auto">
                        <ul class="list-inline text-left footer-icons">
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-auto">
                        <label>Siguenos para no perderte ningun articulo nuevo!</label>
                        <label class="sr-only" for="subscribeEmail">Correo electronico</label>
                        <div class="input-group mb-2">
                            <input type="text" class="form-control bg-dark border-light text-white" id="subscribeEmail" placeholder="Correo electronico">
                            <div class="input-group-text btn-success text-light">Subscribe</div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="w-100 bg-black py-3">
                <div class="container">
                    <div class="row pt-2">
                        <div class="col-12">
                            <p class="text-left text-light">
                                Copyright &copy; 2024 ZigZag 
                                | Diseñado por Danil Loginov 2ºDAW
                            </p>
                        </div>
                    </div>
                </div>
            </div>

        </footer>
        <!-- End Footer -->


        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
    </body>

</html>
