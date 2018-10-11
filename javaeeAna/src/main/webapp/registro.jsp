<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="index.css" />
    <!-- script src="index.js"></script -->
</head>
<body>

	<form action="registro" method="post">
        <fieldset>
            <legend>Datos Personales</legend>
             <p>
                <label for="dni">DNI</label>
                <input type="text" name="dni" id="dni"/>
            </p>
            <p>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre"/>
            </p>
            <p>
                <label for="password">Contraseña</label>
                <input type="text" name="password" id="password" />
            </p>
            <p>
                <label for="apellido">Apellido</label>
                <input type="text" name="apellido" id="apellido" />
            </p>
            <p>
                <label for="poblacion">Población</label>
                <input type="text" name="poblacion" id="poblacion" />
            </p>
            <p>
            	<input type="hidden" name="ACCION" id="ACCION" value="REGISTRO"/>
              	<button value="2">Registrar</button>
            </p>
        </fieldset>
    </form>
    
</body>
</html>