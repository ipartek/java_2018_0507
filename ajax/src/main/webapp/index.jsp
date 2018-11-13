<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<script src="js/index.js"></script>
</head>
<body>

	<table id="tablalibros">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<%-- <tr><th>id</th><td>nombre</td><td><a href="javascript:mostrarLibro(id)">Editar</a><tr> --%>
		</tbody>
	</table>
	
	<form id="formulariolibros">
		<span></span>
		<input type="hidden" name="id" id="id" />
		<input name="nombre" id="nombre" />
		<button>Aceptar</button>
		<button id="botoncancelar">Cancelar</button>
	</form>

	<a id="enlaceNuevoLibro" href="#">Nuevo libro</a>
	<%-- El evento de click del href se hará en jQuery --%>
</body>
</html>
