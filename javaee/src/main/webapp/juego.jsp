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
	<jsp:useBean id="JuegoServlet" scope="request" class="com.ipartek.formacion.javaee.modelos.Juego" />
    <h1>El ahorcado</h1>
    <p>introduce una letra o la palabra correcta</p>
    
    <form action="JuegoServlet" method="post">
        <fieldset>
            <legend>Login</legend>
            <p>
                <label for="introduce">Palabra/letra</label>
                <input type="text" name="introduce" id="introduce" >                	                
                <span><jsp:getProperty property="introduce" name="JuegoServlet"/>
                </span>
            </p>
            <p>
                <label for="palabra">respuesta:</label>
                <input type="text" name="palabra" id="palabra" />
                <span><jsp:getProperty property="palabra" name="JuegoServlet"/>
                </span>
            </p>
            <p>
                <button name="boton">Jugar</button>
            </p>
        </fieldset>
    </form>
    
</body>
</html>
