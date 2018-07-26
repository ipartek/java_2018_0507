<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
    <link rel="stylesheet" href="index.css" />
    <script src="registro.js"></script>
</head>
<body>
	<jsp:useBean id="registro" scope="request" class="com.ipartek.formacion.javaee.modelos.LoginForm" />
    <h1>index.jsp</h1>
    <p id="mensaje">Introduce tus <span class ="destacado">datos</span> para <span class="destacado">registrarte</span></p>
    
    <form action="registro" method="post">
        <fieldset>
            <legend>Registro </legend> 
            <p>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre" 
                	value='<jsp:getProperty property="nombre" name="registro"/>' />
            </p>
            <p>
                <label for="apellido">apellido</label>
                <input type="text" name="apellido" id="apellido" 
                	value='<jsp:getProperty property="apellido" name="registro"/>' />
            </p>
            <p>
                <label for="password">Contraseña</label>
                <input type="text" name="password" id="password" />
            </p>
            <p>
                <button>Login</button> 
                <span class="errorTexto">
                	<jsp:getProperty property="mensajeError" name="login"/>
                </span>
            </p>
        </fieldset>
    </form>
    
</body>
</html>
