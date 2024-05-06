<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Registro</title>
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
                    <div class="card-img-left d-none d-md-flex">
                    </div>
                    <div class="card-body p-4 p-sm-5">
                        <h5 class="card-title text-center mb-5 fs-5 text-success"> <strong style=" font-size:30px;">Registro</strong></h5>
                        <form action="RegistroServlet" method="post">

                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInputUsername" name="usuario" placeholder="usuario" required autofocus>
                                <label for="floatingInputUsername">Usuario</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="email" class="form-control" id="floatingInputEmail" name="correo" placeholder="correo">
                                <label for="floatingInputEmail">Correo electrónico</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="password" class="form-control" id="floatingPassword" name="contrasena" placeholder="contraseña">
                                <label for="floatingPassword">Contraseña</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="password" class="form-control" id="floatingPasswordConfirm" name="confirmarContrasena" placeholder="confirma la contraseña">
                                <label for="floatingPasswordConfirm">Confirmar contraseña</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInputTelefono" name="telefono" placeholder="telefono">
                                <label for="floatingInputTelefono">Teléfono</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInputDireccion" name="direccion" placeholder="direccion">
                                <label for="floatingInputDireccion">Dirección</label>
                            </div>

                            <div class="d-grid mb-2">
                                <button class="btn btn-lg text-bold btn-primary btn-login fw-bold text-uppercase bg-success" type="submit">Registrarse</button>
                            </div>

                            <a class="d-block text-center mt-2 small" href="login.jsp">¿Ya tienes una cuenta? Inicia sesión</a>

                            <hr class="my-4">

                            <div class="d-grid mb-2">
                                <button class="btn btn-lg btn-google btn-login fw-bold text-uppercase bg-light" type="submit">
                                    <a href="index.html"></a>
                                    <i class="fab fa-google me-2"></i> Registrarse con Google
                                </button>
                            </div>

                            <div class="d-grid">
                                <button class="btn btn-lg btn-facebook btn-login fw-bold text-uppercase bg-light" type="submit">
                                    <a href="index.html"></a>
                                    <i class="fab fa-facebook-f me-2"></i> Registrarse con Facebook
                                </button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
