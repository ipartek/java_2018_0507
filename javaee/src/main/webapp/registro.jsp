<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="index.css" />
<title>Registro</title>
</head>
<body>
	 <jsp:useBean id="DatosUsu" scope="request" class="com.ipartek.formacion.javaee.modelos.LoginForm" />
	 <form action="registrar" method="post">
        <fieldset>
            <legend>Registro</legend>
            <p>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre"/>

            </p>
            <p>
                <label for="Password">Password</label>
                <input type="password" name="password" id="password" />

            </p>
  
            <p>
                <button>Registrarse</button>
				<a href="index.jsp">Voler al Login</a>
            </p>
        </fieldset>
    </form>

</body>
</html>