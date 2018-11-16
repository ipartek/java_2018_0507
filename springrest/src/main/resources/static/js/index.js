$(function() {
	$.getJSON('/saludo', respuestarest);
	
	$.getJSON('/datos', function(datos) {
		$(datos).each(function() {
			console.log(this);
			//$('<tr><th>' + this.id + '</th><td>' + this.contenido + '</td></tr>').appendTo($('tbody'));
			$('tbody').append('<tr><th>' + this.id + '</th><td>' + this.contenido + '</td></tr>');
		});
	});
	
	$('#fsaludo').submit(function(e) {
		e.preventDefault();
		
		var nombre = $('#nombre').val();
		
		$.getJSON('/saludo?nombre=' + nombre, respuestarest)
	});
});

function respuestarest(respuesta) {
	console.log(respuesta);
	$('#bienvenida').text(respuesta.contenido);
}