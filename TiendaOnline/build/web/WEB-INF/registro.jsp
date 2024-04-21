<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <input type="text" class="form-control" id="username" name="username" placeholder="usuario" required autofocus>
                    <label for="username">Usuario</label>
                  </div>
    
                  <div class="form-floating mb-3">
                    <input type="email" class="form-control" id="email" name="email" placeholder="correo">
                    <label for="email">Correo electronico</label>
                  </div>
    
                  <hr>
    
                  <div class="form-floating mb-3">
                    <input type="password" class="form-control" id="password" name="password" placeholder="contraseña">
                    <label for="password">Contraseña</label>
                  </div>
    
                  <div class="form-floating mb-3">
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="confirma la contraseña">
                    <label for="confirmPassword">Confirma la contraseña</label>
                  </div>
    
                  <div class="d-grid mb-2">
                    
                    <button class="btn btn-lg text-bold btn-primary btn-login fw-bold text-uppercase bg-success" type="submit">Registrarse</button>
                    
                  </div>
    
                  <a class="d-block text-center mt-2 small" href="login.html">¿Tienes una cuenta? Inicia Sesion</a>
    
                  <hr class="my-4">
    
                  <div class="d-grid mb-2">
                    
                    <button class="btn btn-lg btn-google btn-login fw-bold text-uppercase bg-light" type="submit">
                      <i class="fab fa-google me-2"></i> Registrarse con Google
                      </a>
                    </button>
                    
                  </div>
    
                  <div class="d-grid">
                    
                    <button class="btn btn-lg btn-facebook btn-login fw-bold text-uppercase bg-light" type="submit">
                      <i class="fab fa-facebook-f me-2"></i> Registrarse con Facebook
                      </a>
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
