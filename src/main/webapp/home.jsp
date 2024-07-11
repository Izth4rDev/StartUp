<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Home admin</title>
</head>
<body>

<div class="container mx-auto">
    <h1 class="text-primary text-center bg-warning m-0">Bienvenido al panel de administracion</h1>
    <div class="border border-dark">
        <h3 class="text-center">Datos del usuario</h3>
        <div class="d-flex justify-content-around ">
            <p><span class="fw-bolder">Nombre usuario:</span> ${user.name}</p>
            <p><span class="fw-bolder">Correo:</span> ${user.mail}</p>
            <p><span class="fw-bolder">Rol Usuario:</span>  ${user.role_name}</p>
        </div>
    </div>

</div>

<h2 class="text-center text-primary mt-5">Lista de vehiculos y usuarios</h2>
<div class="container mx-auto my-5">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Nombre</th>
            <th scope="col">Nick</th>
            <th scope="col">Correo</th>
            <th scope="col">Peso</th>
            <th scope="col">Rol</th>
            <th scope="col">Direccion</th>
            <th scope="col">Numero</th>
            <th scope="col">Auto</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="carList" items="${uclList}">
            <tr>
                <td>${carList.name}</td>
                <td>${carList.nick}</td>
                <td>${carList.mail}</td>
                <td>${carList.weight}</td>
                <td>${carList.role_name}</td>
                <td>${carList.role_name}</td>
                <td>${carList.address_name}</td>
                <td>${carList.address_number}</td>
                <td>${carList.car_name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<h2 class="text-center text-primary">Lista de Proveedores</h2>
<div class="container mx-auto  my-5">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Proveedor</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="supplier" items="${suppList}">
            <tr>
                <td>${supplier.supplier_name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<a class="btn btn-primary" href="index.jsp">Volver</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>