<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  


<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/estilos.css">
 </head>
<body>
<center>


<div id="menu">

	<form action="loginServlet" method="post">
			<label for="usuario">Usuario</label>
			<input type="usuario" name="user" id="user"/>
			<label for="pass">Contraseña</label>
			<input type="password" name="pass" id="pass" />
			<button>Login</button>
	</form>
	<form action="cerrarSession" method="post">
			<button>Logout</button>
	</form>
	

	<a href="cerrarSession">Cerrar Session</a>
	<a href="verPaginas">VerPaginas</a>
	<br><br>Hola <%=request.getSession().getAttribute("user") %>
</div>

<div id="contenido">

	<a href="">Anterior</a> - <a href="">Siguiente</a><br><br><br>
	<div id="libro">
		<div id="pagina" style="width:500px;height=500px">
				<form action="aniadirPag" method="post">
					Autor : <input type="text" name="autor"><br><br><br>
					<textarea name="escritonuevo" width="400px" height="400px"></textarea>
					<br><button>Enviar</button>
			</form>
		</div>
	</div>
</div>

</center>

</body>
<footer>Libros compartidos</footer>

</html>
