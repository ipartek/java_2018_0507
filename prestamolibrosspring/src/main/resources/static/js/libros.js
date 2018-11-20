$(function() {
	cargarLibros();
	
	$('form').submit(function(e) {
		e.preventDefault();
		
		var libroid = $('#idlibro').val();
		var libronombre = $('#nombre').val();
		var metodo = libroid == 0 ? 'POST' : 'PUT';
		
		$.ajax({
			url: '/api/libros',
			method: metodo,
			data: JSON.stringify({ idlibro: libroid, nombre: libronombre }),
			contentType: 'application/json; charset=UTF-8'
		}).success(function() {
			cargarEditoriales();
			$('#nombre').val('');
			$('#idlibro').val(0);
		});
	});
});

function cargarLibros() {
	$.getJSON('/api/libros', function(libros) {
		console.log(libros);
		
		mostrarEditoriales(libros);
	});
}

function mostrarLibros(libros) {
	$('tbody').empty();
	$(libros).each(function() {
		$('tbody').append(
				'<tr><th>' + this.idlibro + "</th><td>" + this.nombre + '</td>' +
				'<td>' + 
				'<a href="javascript:editar(' + this.idlibro + ')">Editar</a> ' +
				'<a href="javascript:borrar(' + this.idlibro + ')">Borrar</a>' +
				'</tr>' );
	});
}

function editar(id) {
	$.getJSON('/api/editoriales/' + idlibro, function(libro) {
		$('#idlibro').val(libro.idlibro);
		$('#nombre').val(libro.nombre);
	});
}

function borrar(id) {
	if(confirm('¿Estás seguro de borrar el libro ' + idlibro)) {
		$.ajax({
			url: '/api/libro/' + idlibro,
			method: 'DELETE',
		}).success(function() {
			cargarLibros();
		});
	}
}