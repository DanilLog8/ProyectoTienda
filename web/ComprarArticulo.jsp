<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Tablas.Articulos" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Detalles del Artículo</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <style>
            body {
                background-color: #f8f9fa;
                width:100%;
            }

            .container-fluid{
                max-width:900px;
            }
            .card-title {
                color: #343a40;
                font-weight: bold;
            }

            .card-text {
                color: #6c757d;
            }

            .btn-success {
                background-color: #28a745;
                border-color: #28a745;
            }

            .btn-success:hover {
                background-color: #218838;
                border-color: #1e7e34;
            }

            .margin-top{
                margin-top:200px;
            }


        </style>
    </head>

    <body>
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
                            if (usuario != null) {
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
        <%
            Articulos articulo = (Articulos) request.getAttribute("articulo");
        %>
        <div class="container-fluid mt-5 mb-5">
            <h1 class="mb-4 text-success">Detalles del Artículo</h1>

            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-4">
                                    <img src="<%= articulo.getImagen()%>" class="card-img-top img-thumbnail" alt="Imagen del Artículo">
                                </div>
                                <div class="col-md-8">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="mb-3">
                                                <h5 class="card-title"><%= articulo.getNombre()%></h5>
                                                <p class="card-text"><%= articulo.getDescripcion()%></p>
                                                <% String catalogo = articulo.getNombreCatalogo(); %>
                                                <% if (catalogo.equals("1") || catalogo.equals("2") || catalogo.equals("3")) {%>
                                                <p>Talla seleccionada: <%= request.getParameter("talla")%></p>
                                                <% }%>

                                                <p class="card-text text-primary h3">Precio: <%= articulo.getPrecio()%>€</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <h3 class="mt-4">Pagar</h3>
            <form action="comprar" method="POST">
                <input type="hidden" name="idProducto" value="<%= articulo.getId()%>">
                <input type="hidden" name="talla" value="<%= request.getParameter("talla")%>">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="nombreTarjeta">Nombre en la Tarjeta</label>
                            <input type="text" class="form-control" id="nombreTarjeta" name="nombreTarjeta" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="apellidoTarjeta">Apellido en la Tarjeta</label>
                            <input type="text" class="form-control" id="apellidoTarjeta" name="apellidoTarjeta" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="numeroTarjeta">Número de Tarjeta</label>
                            <input type="text" class="form-control" id="numeroTarjeta" name="numeroTarjeta" required>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="fechaCaducidad">Fecha de Caducidad</label>
                            <input type="text" class="form-control" id="fechaCaducidad" name="fechaCaducidad" placeholder="MM/AA" required>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="cvcTarjeta">CVC</label>
                            <input type="text" class="form-control" id="cvcTarjeta" name="cvcTarjeta" required>
                        </div>
                    </div>
                </div>
                <%

                    if (session != null && session.getAttribute("usuario") != null) {
                        BigDecimal huchaUsuario = (BigDecimal) request.getAttribute("huchaUsuario");
                %>
                <div class="form-group mt-5">
                    <label for="utilizarHucha">Utilizar dinero de la hucha:</label>
                    <input type="checkbox" class="form-check-input" id="utilizarHucha" name="utilizarHucha">
                </div>

                <%
                    }
                %>
                <button type="submit" class="btn btn-success mt-5">Realizar Pago</button>
            </form>
        </div>


        <footer class="bg-dark" id="tempaltemo_footer">
            <div class="container margin-top">
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