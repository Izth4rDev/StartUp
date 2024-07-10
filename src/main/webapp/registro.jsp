<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1 class="text-primary text-center">Formulario de registro</h1>
<div class="container mx-auto">
    <form action="user" method="post">
        <div class="mb-3">
            <label class="form-label" for="nameUser">Nombre</label>
            <input class="form-control" type="text" name="nameUser" id="nameUser" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="mail">Correo</label>
            <input class="form-control" type="email" name="mail" id="mail" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="nick">Nick</label>
            <input class="form-control" type="text" name="nick" id="nick" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="pass">Contraseña</label>
            <input class="form-control" type="password" name="pass" id="pass" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="weight">Peso</label>
            <input class="form-control" type="text" name="weight" id="weight" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="addressName">Direccion</label>
            <input class="form-control" type="text" name="addressName" id="addressName" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="addressNum">Numero de Direccion</label>
            <input class="form-control" type="text" name="addressNum" id="addressNum" required>
        </div>

        <div class="mb-3">
            <label class="form-label" for="role">Rol</label>
            <select class="form-select" name="role" id="role">
                <option selected>Selecciona un Rol</option>
                <c:forEach var="rol" items="${roles}" >
                    <option value="${rol.id_role}">${rol.role_name}</option>
                </c:forEach>
                <!-- aqui los roles cargados de la bd-->
            </select>
        </div>
        <button class="btn btn-primary" type="submit">Registrar</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>