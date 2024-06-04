<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>ZigZag Tienda</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-xl-9 mx-auto">
                <div class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
                    <div class="card-body p-4 p-sm-5">
                        <h5 class="card-title text-center mb-5 fs-5 text-success"><strong style="font-size:30px;">Inicio de Sesión</strong></h5>
                        <form action="LoginServlet" method="post">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Usuario" required autofocus>
                                <label for="usuario">Usuario</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control" id="contrasena" name="contrasena" placeholder="Contraseña" required>
                                <label for="contrasena">Contraseña</label>
                            </div>
                            <div class="d-grid mb-2">
                                <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase bg-success" type="submit">Iniciar Sesión</button>
                            </div>
                            <div class="d-grid mb-2">
                                <button class="btn btn-lg btn-google btn-login fw-bold text-uppercase bg-light" type="button" onclick="window.location.href='googleLoginURL'">
                                    <i class="fab fa-google me-2"></i> Entrar con Google
                                </button>
                            </div>
                            <div class="d-grid">
                                <button class="btn btn-lg btn-facebook btn-login fw-bold text-uppercase bg-light" type="button" onclick="window.location.href='facebookLoginURL'">
                                    <i class="fab fa-facebook-f me-2"></i> Entrar con Facebook
                                </button>
                            </div>
                        </form>
                    </div>
                    <div class="card-img-right d-none d-md-flex"></div>
                </div>
            </div>
        </div>
    </div>

    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
</body>
</html>
