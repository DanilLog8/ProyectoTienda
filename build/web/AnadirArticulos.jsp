<%@page import="Tablas.Tallaspie"%>
<%@page import="Tablas.Tallas"%>
<%@page import="java.util.List"%>
<%@page import="Tablas.Catalogos"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Agregar Artículo de Ropa</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    </head>

    <body class="bg-image">
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
        <nav class="navbar navbar-expand-lg navbar-light shadow bg-white">
            <div class="container d-flex justify-content-between align-items-center">
                <img class="imgIconopagina" src="https://cdn.icon-icons.com/icons2/3395/PNG/512/zigzag_shape_icon_214057.png" alt="iconoPagina">
                <a class="navbar-brand text-IconoPagina logo h1 align-self-center" href="index.html">
                    ZigZag
                </a>

                <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="align-self-center collapse navbar-collapse flex-fill d-lg-flex flex-direct flex-row w-100" id="templatemo_main_nav">
                    <div class="flex-fill">
                        <ul class="nav navbar-nav1">
                            <% if (session.getAttribute("usuario") != null && !session.getAttribute("usuario").equals("Trabajador1")) { %>
                            <a class="nav-link" href="Home2.jsp">Home</a>
                            <% } else if (session.getAttribute("usuario").equals("Trabajador1")) { %>
                            <a class="nav-link" href="Home2Trabajador.jsp">Home</a>
                            <% } else if (session.getAttribute("usuario") == null) {%>
                            <a class="nav-link" href="Home.jsp">Home</a>
                            <%}%>
                            <li class="nav-item">
                                <a class="nav-link" href="MostrarUsuarios">Modificar Datos de los usuarios</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="MostrarCatalogos">Añadir artículos a la tienda</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="cerrarSesion">Cerrar Sesión</a>
                            </li>
                            <li class="nav-item">
                                <span class="nav-link fsCustom"><%= session.getAttribute("usuario")%></span>
                            </li>
                        </ul>
                    </div>


                </div>

            </div>
        </nav>

        <div class="container mt-5 mb-5">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header"><span class="customFont">Agregar Artículo</span></div>
                        <div class="card-body">
                            <form action="AgregarArticulo" method="post">
                                <div class="mb-3">
                                    <label for="nombre" class="form-label">Nombre</label>
                                    <input type="text" class="form-control borderPers" id="nombre" name="nombre" required>
                                </div>
                                <div class="mb-3">
                                    <label for="cantidad" class="form-label">Cantidad</label>
                                    <input type="number" class="form-control borderPers" id="cantidad_disponible" name="cantidad" step="1" required>
                                </div>
                                <div class="mb-3">
                                    <label for="precio" class="form-label">Precio</label>
                                    <input type="number" class="form-control borderPers" id="precio" name="precio" step="0.01" required>
                                </div>
                                <div class="mb-3">
                                    <label for="descripcion" class="form-label">Descripción</label>
                                    <textarea class="form-control borderPers" id="descripcion" name="descripcion" rows="3"></textarea>
                                </div>
                                <div class="mb-3">
                                    <label for="catalogo" class="form-label">Catálogo</label>
                                    <select class="form-select" id="catalogo" name="catalogo" onchange="updateTallas()">
                                        <% List<Catalogos> catalogos = (List<Catalogos>) request.getAttribute("catalogos");
                                            for (Catalogos catalogo : catalogos) {%>
                                        <option value="<%= catalogo.getId()%>" data-categoria="<%= catalogo.getNombre()%>">
                                            <%= catalogo.getNombre()%>
                                        </option>
                                        <% }%>
                                    </select>
                                </div>

                                <div class="mb-3">
                                    <label id="NombreTalla" class="form-label">Talla</label>
                                    <div id="tallasContainer">
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label for="imagen" class="form-label">URL de la Imagen</label>
                                    <input type="text" class="form-control" id="imagen" name="imagen">
                                </div>
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            function updateTallas() {
                var catalogo = document.getElementById("catalogo");
                var tallasContainer = document.getElementById("tallasContainer");
                var tallasContainer1 = document.getElementById("NombreTalla");

                tallasContainer.innerHTML = "";
                tallasContainer1.style.display = "none";
                // Obtener el valor seleccionado del catálogo
                var categoriaSeleccionada = catalogo.options[catalogo.selectedIndex].getAttribute("data-categoria");

                // Si el catálogo seleccionado es "Calzado", cargar tallas de TallasPie
                if (categoriaSeleccionada === "Calzado") {
                    tallasContainer.style.display = "block";
                    tallasContainer1.style.display = "block";
            <% List<Tallaspie> listaDeTallasPie = (List<Tallaspie>) request.getAttribute("listaDeTallasPie");
                for (Tallaspie talla : listaDeTallasPie) {%>
                    var div = document.createElement("div");
                    div.className = "form-check form-check-inline";
                    var checkbox = document.createElement("input");
                    checkbox.type = "checkbox";
                    checkbox.className = "form-check-input";
                    checkbox.name = "tallas";
                    checkbox.value = "<%= talla.getId()%>";
                    var label = document.createElement("label");
                    label.className = "form-check-label";
                    label.innerHTML = "<%= talla.getTalla()%>";
                    div.appendChild(checkbox);
                    div.appendChild(label);
                    tallasContainer.appendChild(div);
            <% } %>
                }
                // Si el catálogo seleccionado es "Ropa de Mujer" o "Ropa de Hombre", cargar tallas de Tallas
                else if (categoriaSeleccionada === "Ropa de Mujer" || categoriaSeleccionada === "Ropa de Hombre") {
                    tallasContainer.style.display = "block";
                    tallasContainer1.style.display = "block";
            <% List<Tallas> listaDeTallas = (List<Tallas>) request.getAttribute("listaDeTallas");
                for (Tallas talla : listaDeTallas) {%>
                    var div = document.createElement("div");
                    div.className = "form-check form-check-inline";
                    var checkbox = document.createElement("input");
                    checkbox.type = "checkbox";
                    checkbox.className = "form-check-input";
                    checkbox.name = "tallas";
                    checkbox.value = "<%= talla.getId()%>";
                    var label = document.createElement("label");
                    label.className = "form-check-label";
                    label.innerHTML = "<%= talla.getNombre()%>";
                    div.appendChild(checkbox);
                    div.appendChild(label);
                    tallasContainer.appendChild(div);
            <% }%>
                }
                // Si no se selecciona "Calzado", "Ropa de Mujer" ni "Ropa de Hombre", ocultar la parte de tallas
                else {
                    tallasContainer.style.display = "none";
                    tallasContainer1.style.display = "none";
                }
            }

            // Llamar a la función una vez para actualizar las tallas inicialmente
            updateTallas();
        </script>





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




        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"
                integrity="sha384-QCfXE1v9/KO5nmz7ZcO+3jEZ8eZ5LIZvEjLrFy9w8PkRYhXBo/3pXBWNrELi6U5z"
        crossorigin="anonymous"></script>
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
    </body>

</html>
