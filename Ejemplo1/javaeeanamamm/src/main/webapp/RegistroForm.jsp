<%@ page  contentType="Text/html ; charset=UTF-8" pageEncoding="UTF-8" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Registro</title>
    <link rel="stylesheet" href="index.css" />
    <script src="index.js"></script>
</head>
<body>
<jsp:useBean id="login" scope="request" class="com.ipartek.formacion.javaeeanamamm.modelos.LoginForm"/> 
    <h1>Login</h1>
<h1>Registro</h1>
    <p id="mensaje">Introduce tus <span class ="destacado">datos</span> para <span class="destacado">registrarte</span></p> 


 <form action="registro" method="post">
        <fieldset>
            <legend>Registro de usuario</legend>
            <p>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre" 
                 value='<jsp:getProperty property="nombre" name="login"/>'/>
            </p>
            
            <p>
                <label for="email">Email</label>
                <input type="text" name="email" id="email"/>
            </p>
            
             <p>
                <label for="password">Contraseña</label>
                <input type="password" name="password" id="password" />
            </p>
            
            
            <p>
                <button>Enviar</button>
                <span class="errorTexto">
                <jsp:getProperty property="mensajeError" name="login"/>
                <span/>
                
            </p>
        </fieldset>
    </form>
















</body>
</html>