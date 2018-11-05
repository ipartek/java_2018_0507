<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<script>
function refrescarHora() {
	
	$.getJSON('hora', function(objeto) {
		$('#hora').text(objeto.hora);
	});

	setTimeout(refrescarHora, 500);
}

function cargarLibros() {
	$.getJSON('libros', function(libros){
		$(libros).each(function() {
			$('#libros').append('<li>' + this.id + ", " + this.nombre  + '</li>');
		});
	});
}

$(function() {
	refrescarHora();
	
	cargarLibros();
});
</script>
</head>
<body>
	<h2 id="hora">Hello World!</h2>
	
	<ul id="libros">
	</ul>
</body>
</html>
