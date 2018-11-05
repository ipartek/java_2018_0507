<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<script src="js/index.js"></script>
</head>
<body>
	<h2 id="hora">Cargando el reloj</h2>
	
	<form action="libros" method="post" id="altalibros">
		<input type="number" id="id" name="id" placeholder="id" />
		<input type="text" id="nombre" name="nombre" placeholder="nombre" />
		<button>Enviar</button>
	</form>
	
	<ul id="libros">
	</ul>
</body>
</html>
