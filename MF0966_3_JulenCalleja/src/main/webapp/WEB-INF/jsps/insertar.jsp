<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insertar</title>
</head>
<body>
		<form action="modificar" method="post">
					<legend>Dar Alta </legend>
					<div>
						<label for="nombre">Nombre</label> <input type="text"
							 id="nombre" placeholder="Nombre" name="nombre" />
					</div>
					<div>
						<label for="apellido">Apellido</label> <input type="text"
							 id="apellido" placeholder="apellido" name="apellido" />
					</div>
					<div>
						<label for="direccion">Direccion</label> <input type="text"
							 id="direccion" placeholder="direccion" name="direccion" />
					</div>
					<div>
						<label for="portal">Portal</label> <input type="text"
							 id="portal" placeholder="portal" name="portal" />
					</div>
					<div>
						<label for="email">Email</label> <input type="text"
							 id="email" placeholder="email" name="email" />
					</div>
					<div>
						<label for="Dni">Dni</label> <input type="text"
							 id="Dni" placeholder="Dni" name="dni" />
					</div>
					<div>
						<label for="puesto">Puesto</label> <input type="text"
							 id="puesto" placeholder="puesto" name="puesto" />
					</div>
					
					<button>Registrar</button>
				</form>
</body>
</html>