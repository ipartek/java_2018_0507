<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="index.css" />
   <!--   <script src="index.js"></script>  -->
</head>
<body>
	<jsp:useBean id="login" scope="request" class="com.ipartek.formacion.javaee.modelos.LoginForm" />
    <h1>Login</h1>
    <p id="mensaje">Introduce tus <span class ="destacado">credenciales</span> para <span class="destacado">iniciar sesión</span></p>
    
    <form action="login" method="post">
        <fieldset>
            <legend>Login</legend>
            <p>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre" >                	                
                <span><jsp:getProperty property="nombre" name="login"/>
                </span>
            </p>
            <p>
                <label for="password">Contraseña</label>
                <input type="text" name="password" id="password" />
                <span><jsp:getProperty property="password" name="login"/>
                </span>
            </p>
            <p>
                <button value="1" name="boton">Login</button>
                <button value="2" name="boton">Registrar</button> 
            </p>
            <span class="errorTexto">
           		 <jsp:getProperty property="mensajeError" name="login"/>
            </span>
        </fieldset>
    </form>
    
</body>
</html>
