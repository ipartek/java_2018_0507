<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="index.css" />
    <%-- <script src="index.jsenpruebas"></script> --%>
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
                <input type="text" name="nombre" id="nombre" 
                	value='<jsp:getProperty property="nombre" name="login"/>' />
            </p>
            <p>
                <label for="password">Contraseña</label>
                <input type="password" name="password" id="password" />
                <%-- <jsp:getProperty property="password" name="login"/> --%>
            </p>
            <p>
                <button>Login</button>
                <span class="errorTexto">
                	<jsp:getProperty property="mensajeError" name="login"/>
                </span>
            </p>
            
            
        </fieldset>
    </form>
    	<p>
    			<a href="registro.jsp" >¿Desea registrarse? </a>
        </p>
</body>
</html>
