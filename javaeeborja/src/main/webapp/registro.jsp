
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
<title>formulario de registro</title>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="index.css" />
    <!--   <script src="index.js"></script>-->
</head>
<body>
	<jsp:useBean id="login" scope="request" class="com.ipartek.formacion.javaee.modelos.RegisterForm" />

<!--  -->	
    <h1>Registro</h1>
    <p id="mensaje">Introduce tus <span class ="destacado">credenciales</span> para <span class="destacado">Registrarte</span></p>
    
    <form action="login" method="post">
        <fieldset>
            <legend>Registro</legend>
            <p>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombrer" id="nombrer"  value='<jsp:getProperty property="nombrer" name="login"/>'/>
            </p>
            <p>
                <label for="password">Contraseña</label>
                <input type="password" name="passwordr" id="passwordr" />
            </p>
                <p>
                <label for="email">email</label>
                <input type="email" name="emailr" id="emailr" />
            </p>
            <p>
                <button>Registrar</button>
                <span class="errorTexto">
                	                	<jsp:getProperty property="mensajeError" name="login"/>
                	
                </span>
            </p>
        </fieldset>
    </form>
    
</body>
</html>
