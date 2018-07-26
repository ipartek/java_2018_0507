<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Registro</title>
        <link rel="stylesheet" href="index.css">
    </head>
    <body>
    	<jsp:useBean id="registro" scope="request" class="com.ipartek.formacion.javaee.modelos.LoginForm" />
        <h1>Registro</h1>
        <p id="mensaje">
            Introduce tus <span class="destacado">datos</span>
            para <span class="destacado">registrarse</span></p>
        <form action="registro" method="post">
            <fieldset>
                <legend>Registro</legend>
                <p>
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" id="nombre" 
                    	value='<jsp:getProperty property="nombre" name="registro"/>'/>
                    <span class="errorTexto">
                    	<jsp:getProperty property="errorNombre" name="registro"/>
                    </span>
                </p>
                <p>
                    <label for="apellido">Apellido</label>
                    <input type="text" name="apellido" id="apellido" 
                    	value='<jsp:getProperty property="apellido" name="registro"/>'/>
                    <span class="errorTexto">
                    	<jsp:getProperty property="errorApellido" name="registro"/>
                    </span>
                </p>
                <p>
                    <label for="password">Contraseña</label>
                    <input type="password" name="password" id="password"/>
                    <span class="errorTexto">
                    	<jsp:getProperty property="errorPassword" name="registro"/>
                    </span>
                </p>
                 <p>
                    <label for="password">Repite contraseña</label>
                    <input type="password" name="password2" id="password2"/>
                </p>
                <p>
                    <button>Registrarse</button>
                    <span class="errorTexto">
                    	<jsp:getProperty property="mensajeError" name="registro"/>
                    </span>
                </p>
            </fieldset>
        </form>
    </body>
</html>