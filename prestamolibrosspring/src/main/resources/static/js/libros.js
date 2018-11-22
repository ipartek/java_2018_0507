$(function() {
	cargarLibros();
	
	$('form').submit(function(e) {
		e.preventDefault();
		
		var libroid = $('#id').val();
		var libronombre = $('#nombre').val();
		var libroeditorial = $('#editorial').val();
		var libroautor = $('#autor').val();
		var metodo = libroid == 0 ? 'POST' : 'PUT';
		
		$.ajax({
			url: '/api/libros',
			method: metodo,
			data: JSON.stringify({ id: libroid, nombre: libronombre, editorial:libroeditorial, autor:libroautor }),
			contentType: 'application/json; charset=UTF-8'
		}).success(function() {
			cargarLibros();
			$('#nombre').val('');
			$('#id').val(0);
			$('#editorial').val(0);
		});
	});
});

function cargarLibros() {
	$.getJSON('/api/libros', function(libros) {
		console.log(libros);
		
		mostrarlibros(libros);
	});
}

function mostrarlibros(libros) {
	$('tbody').empty();
	$(libros).each(function() {
		$('tbody').append(
				'<tr><th>' + this.id + "</th><td>" + this.nombre + '</td><td>' + this.editorial +'</td><td>'+this.autor+'</td><td>'
				+'<a href="javascript:editar(' + this.id + ')">Editar</a> ' +
				'<a href="javascript:borrar(' + this.id + ')">Borrar</a>' +
				'</tr>' );
	});
}

function editar(id) {
	$.getJSON('/api/libros/' + id, function(libro) {
		$('#id').val(libro.id);
		$('#nombre').val(libro.nombre);
		
	});
}

function borrar(id) {
	if(confirm('¿Estás seguro de borrar lel libro ' + id)) {
		$.ajax({
			url: '/api/libros/' + id,
			method: 'DELETE',
		}).success(function() {
			cargarLibros();
		});
	}
}