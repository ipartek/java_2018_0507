
<!-- MODELO -->

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="index.css" />
    <script src="index.js"></script>
</head>
<body>
    <h1>Login</h1>
    <p id="mensaje">Introduce tus <span class ="destacado">credenciales</span> para <span class="destacado">iniciar sesion</span></p>
    
    <form action="login" method="post">
        <fieldset>
            <legend>Login</legend>
            <p>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre" />
            </p>
            <p>
                <label for="password">Contraseña</label>
                <input type="text" name="password" id="password" />
            </p>
            <p>
                <button>Login</button>
            </p>
        </fieldset>
    </form>
    
</body>
</html>