<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro</title>
</head>
<body>
	 <jsp:useBean id="DatosUsu" scope="request" class="com.ipartek.formacion.javaee.modelos.LoginForm" />
	 <form action="login" method="post">
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
         				 <%-- LO COMENTO PORQUE NO LO VOY A USAR AHORA <p>
               				 <label for="Password2">Inserte el password otra vewz</label>
               				 <input type="password" name="password2" id="password2" />
            			</p>--%> 
            <p>
                <button>Registrarse</button>
          
            </p>
        </fieldset>
    </form>

</body>
</html>