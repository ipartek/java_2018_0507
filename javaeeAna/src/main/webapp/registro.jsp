<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrate</title>
</head>
<body>
 	<fieldset>
            <legend>Registro</legend>
            <p>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre" value="" name="login"/>' />
            </p>
            <p>
                <label for="password">Contraseña</label>
                <input type="text" name="password" id="password" />
            </p>
            <p>
                <button>Crear Cuenta</button>
                <span class="errorTexto">
                	<jsp:getProperty property="mensajeError" name="login"/>
                </span>
            </p>
        </fieldset>
</body>
</html>