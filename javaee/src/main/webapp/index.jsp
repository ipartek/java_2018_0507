<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="index.css" />
<<<<<<< HEAD
   <!--   <script src="index.js"></script>  -->
=======
    <%-- <script src="index.jsenpruebas"></script> --%>
>>>>>>> refs/heads/master
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
<<<<<<< HEAD
                <input type="text" name="nombre" id="nombre" >                	                
                <span><jsp:getProperty property="nombre" name="login"/>
=======
                <input type="text" name="nombre" id="nombre" 
                	value='<jsp:getProperty property="nombre" name="login"/>' />
                
                <span class="errorTexto">
                	<jsp:getProperty property="errorNombre" name="login"/>

                <input type="text" name="password" id="password" />
                <span><jsp:getProperty property="password" name="login"/>
                <input type="password" name="password" id="password" />
                
                <span class="errorTexto">
                	<jsp:getProperty property="errorPassword" name="login"/>
                </span>
                <%-- <jsp:getProperty property="password" name="login"/> --%>
            </p>
            <p>
                <button>Login</button>
                <span class="errorTexto">
                	<jsp:getProperty property="mensajeError" name="login"/>
>>>>>>> refs/heads/master
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
