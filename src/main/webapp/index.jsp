<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Hello, world!</title>
</head>
<body>

<!-- Modal -->
<div class="modal fade" id="modalLogin" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Login sistema</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="login" method="post">
                    <label class="form-label" for="mail">Correo</label>
                    <input class="form-control" type="email" name="mail" id="mail" placeholder="nombre@correo.cl">
                    <label class="form-label" for="pass">Contraseña</label>
                    <input class="form-control" type="password" name="pass" id="pass">

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Logearse</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <h1 class="text-primary text-center">Bienvenido al Sistema de gestion de vehiculos</h1>
    <h4 class="text-center">Escoja una opcion</h4>

    <div class="d-flex justify-content-center">
        <a type="button" class="btn btn-warning me-2" data-bs-toggle="modal" data-bs-target="#modalLogin">
            Login
        </a>
        <a class="btn btn-primary ms-2" href="rolserv">Registrarse</a>
    </div>

    <c:if test="${userResp}">
        <div class="container mx-auto text-center">
            <h3 class="text-success">${message}</h3>
            <p>${userAdded.name}</p>
            <p>${userAdded.mail}</p>
            <p>${userAdded.weight}</p>
        </div>
    </c:if>

    <p class="text-danger">${messageUsr}</p>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>