$(function() {
	$.getJSON('/api/editoriales', function(datos) {
		$(datos).each(function() {
			console.log(this);
			$('tbody').append('<tr><th>' + this.id + '</th><td>' + this.nombre + '</td></tr>');
		});
	});
	
	$('#fEditorial').submit(function(e) {
		e.preventDefault();
		
		var idEditorial = $('#idEditorial').val();
		
		$.getJSON('/api/editoriales/' + idEditorial, respuestarest)
	});
});

function respuestarest(respuesta) {
	$('#respuestaId').html('Id: ' + respuesta.id + ' nombre: ' + respuesta.nombre);
}
