<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="Tablas.Articulos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <title>ZigZag Tienda</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/slick.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/slick-theme.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <style>
            .widthCustom{
                width:300px;
            }
        </style>
    </head>

    <body>
        <%
            Articulos articulo = (Articulos) request.getAttribute("articulo");
        %>
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
                            <li class="nav-item">
                                <% if (session.getAttribute("usuario") != null && !session.getAttribute("usuario").equals("Trabajador1")) { %>
                                <a class="nav-link" href="Home2.jsp">Home</a>
                                <% } else if (session.getAttribute("usuario").equals("Trabajador1")) { %>
                                <a class="nav-link" href="Home2Trabajador.jsp">Home</a>
                                <% } else if (session.getAttribute("usuario") == null) {%>
                                <a class="nav-link" href="Home.jsp">Home</a>
                                <%}%>
                            </li>
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

        <section class="bg-light">
            <div class="container pb-5">
                <div class="row">
                    <div class="col-lg-5 mt-5">
                        <div class="card mb-3">
                            <img class="card-img img-fluid" src="<%=articulo.getImagen()%>" alt="Card image cap" id="product-detail">
                        </div>

                    </div>
                    <div class="col-lg-7 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h1 class="h2"><%=articulo.getNombre()%></h1>
                                <p class="h3 py-2"><%=articulo.getPrecio()%></p>
                                <p class="py-2">
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-warning"></i>
                                    <i class="fa fa-star text-secondary"></i>
                                    <span class="list-inline-item text-dark">Rating 4.8 | 36 Commentarios</span>
                                </p>


                                <h6>Descripcion</h6>
                                <p><%=articulo.getDescripcion()%></p>

                                <form action="" method="GET">
                                    <input type="hidden" name="product-title" value="Activewear">
                                    <% String catalogo = articulo.getNombreCatalogo(); %>
                                    <% if (catalogo.equals("1") || catalogo.equals("2") || catalogo.equals("3")) { %>
                                    <div class="row">
                                        <div class="col-auto">
                                            <ul class="list-inline pb-3">
                                                <h6>Tamaño</h6>
                                                <ul class="list-inline pb-3">
                                                    <% List<String> tallasDisponibles = (List<String>) request.getAttribute("tallasDisponibles"); %>
                                                    <% List<Integer> cantidadesDisponibles = (List<Integer>) request.getAttribute("cantidadesDisponibles"); %>
                                                    <% if (tallasDisponibles != null && !tallasDisponibles.isEmpty()) { %>
                                                    <% for (int i = 0; i < tallasDisponibles.size(); i++) {%>
                                                    <li class="list-inline-item">
                                                        <input type="hidden" name="product-size" id="product-size" value="<%= tallasDisponibles.get(i)%>">
                                                        <% if (cantidadesDisponibles.get(i) > 0) {%>
                                                        <button class="btn btn-success btn-size" type="button" onclick="seleccionarTalla('<%= tallasDisponibles.get(i)%>')"><%= tallasDisponibles.get(i)%></button>
                                                        <% } else {%>
                                                        <button class="btn btn-secondary btn-size disabled" type="button"><%= tallasDisponibles.get(i)%></button>
                                                        <% } %>
                                                    </li>
                                                    <% } %>
                                                    <% } else { %>
                                                    <li class="list-inline-item">No hay tallas disponibles</li>
                                                        <% } %>
                                                </ul>
                                            </ul>
                                        </div>
                                    </div>
                                    <% }%>
                                    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                                    <script>
                                                            $(document).ready(function () {
                                                                var botonCarrito = $("#botonCarrito");
                                                                var catalogo = "<%= articulo.getNombreCatalogo()%>";
                                                                var usuarioEnSesion = "<%= session.getAttribute("usuario")%>";

                                                                if (!usuarioEnSesion) {
                                                                    botonCarrito.prop("disabled", true);
                                                                }
                                                                if ((catalogo === "4" || catalogo === "5" || catalogo === "6" || catalogo === "7") && usuarioEnSesion) {
                                                                    botonCarrito.prop("disabled", false);
                                                                }
                                                            });


                                                            function seleccionarTalla(talla) {
                                                                var botonComprar = document.getElementById("botonComprar");
                                                                var idProducto = <%= articulo.getId()%>;
                                                                var url = "ComprarArticulo?idProducto=" + idProducto + "&talla=" + encodeURIComponent(talla);
                                                                botonComprar.setAttribute("href", url);
                                                                botonComprar.removeAttribute("disabled");
                                                                var botonCarrito = document.getElementById("botonCarrito");
                                                                botonCarrito.removeAttribute("disabled");
                                                                document.getElementById("tallaSeleccionada").value = talla;
                                                            }



                                                            function verificarSeleccionTalla(event) {
                                                                var tallaSeleccionada = document.getElementById("tallaSeleccionada").value;
                                                                var cantidadDisponible = <%= articulo.getCantidadDisponible()%>;
                                                                var catalogo = <%= articulo.getNombreCatalogo()%>;
                                                                var botonComprar = document.getElementById("botonComprar");
                                                                var idProducto = <%= articulo.getId()%>;

                                                                if (catalogo === 4 || catalogo === 5 || catalogo === 6 || catalogo === 7) {
                                                                    var url = "ComprarArticulo?idProducto=" + idProducto;
                                                                    botonComprar.setAttribute("href", url);
                                                                    botonComprar.removeAttribute("disabled");
                                                                }
                                                                if (catalogo === 1 || catalogo === 2 || catalogo === 3) {
                                                                    if (!tallaSeleccionada) {
                                                                        event.preventDefault();
                                                                        Swal.fire({
                                                                            icon: 'warning',
                                                                            title: 'Atención',
                                                                            text: 'Por favor, selecciona una talla antes de continuar.'
                                                                        });
                                                                    }
                                                                }

                                                                if (cantidadDisponible === 0) {
                                                                    event.preventDefault();
                                                                    Swal.fire({
                                                                        icon: 'error',
                                                                        title: 'Oops...',
                                                                        text: 'No hay artículos disponibles.'
                                                                    });
                                                                }
                                                            }

                                                            function verificarSeleccionTalla1(event) {
                                                                var cantidadDisponible = <%= articulo.getCantidadDisponible()%>;
                                                                var usuarioEnSesion = <%= session.getAttribute("usuario")%>; // Obtener el usuario en sesión

                                                                if (!usuarioEnSesion) {
                                                                    event.preventDefault();
                                                                    Swal.fire({
                                                                        icon: 'warning',
                                                                        title: 'Atención',
                                                                        text: 'Por favor, inicia sesión antes de continuar.'
                                                                    });
                                                                } else if (cantidadDisponible === 0) {
                                                                    event.preventDefault();
                                                                    Swal.fire({
                                                                        icon: 'error',
                                                                        title: 'Oops...',
                                                                        text: 'No hay artículos disponibles.'
                                                                    });
                                                                }
                                                            }
                                    </script>

                                    <% if (!(catalogo.equals("1") || catalogo.equals("2") || catalogo.equals("3"))) {%>
                                    <input type="hidden" id="tallaSeleccionada" value="<%= articulo.getCantidadDisponible()%>">
                                    <% } else { %>
                                    <input type="hidden" id="tallaSeleccionada" value="">
                                    <% }%>

                                    <h6>Cantidad Disponible</h6>
                                    <p><%= articulo.getCantidadDisponible()%></p>

                                    <div class="row pb-3">
                                        <div class="col">
                                            <a id="botonComprar" class="btn btn-success btn-lg widthCustom" href="#" onclick="verificarSeleccionTalla(event)" disabled>Comprar</a>
                                        </div>
                                        <div class="col">
                                            <button id="botonCarrito" type="button" class="btn btn-success btn-lg widthCustom" name="submit" value="addtocard" onclick="verificarSeleccionTalla1(event)" disabled>Añadir al carrito</button>
                                        </div>
                                    </div>
                                </form>


                            </div>
                            </section>

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
                                                <input type="text" class="form-control bg-dark border-light" id="subscribeEmail" placeholder="Correo electronico">
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

                            <!-- Start Script -->
                            <script src="assets/js/jquery-1.11.0.min.js"></script>
                            <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
                            <script src="assets/js/bootstrap.bundle.min.js"></script>
                            <script src="assets/js/templatemo.js"></script>
                            <script src="assets/js/custom.js"></script>
                            <!-- End Script -->





                            </body>

                            </html>
