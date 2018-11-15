$(function() {
	$.getJSON('/saludo', function(respuesta) {
		console.log(respuesta);
		$('#bienvenida').text(respuesta.contenido);
	})
});