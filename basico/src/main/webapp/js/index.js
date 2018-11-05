'use strict';

function refrescarHora() {
	
	$.getJSON('hora', function(objeto) {
		$('#hora').text(objeto.hora);
	});
	
	//setTimeout(refrescarHora, 500);
}

function cargarLibros() {
	$.getJSON('libros', recibirLibros);
}

function recibirLibros(libros){
	$('#libros').empty();
	
	$(libros).each(cadaLibro);
}

function cadaLibro() {
	$('#libros').append('<li>' + this.id + ", " + this.nombre  + '</li>');
}

/* function cargarLibros() {
	$.getJSON('libros', function(libros){
		$(libros).each(function() {
			$('#libros').append('<li>' + this.id + ", " + this.nombre  + '</li>');
		});
	});
}
 */

function interceptarFormulario() {
	$('#altalibros').submit(function(e) {
		e.preventDefault();
		
		const vid = $('#id').val();
		const vnombre = $('#nombre').val();
		
		const libro = { id: vid, nombre: vnombre };
		
		console.log(libro);
		
		$.post('libros', libro, function(libros) {
			console.log(libros);
			
			recibirLibros(libros);
		}, 'json');
	});
}

$(function() { // Se ejecuta cuando se carga el documento completo
	setInterval(refrescarHora, 500);
	
	cargarLibros();
	
	interceptarFormulario();
});
