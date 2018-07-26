<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conversor</title>
</head>
<body>

	<h1>Conversor</h1>
    <p>Introduce los datos</p>
    
    <form action="conversor" method="post">
        <fieldset>
            <legend>Conversor </legend> 
            <p>
                <label for="km">Km</label>
                <input type="text" name="km" id="km" 
                	value='<jsp:getProperty property="nombre" name="login"/>' />
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