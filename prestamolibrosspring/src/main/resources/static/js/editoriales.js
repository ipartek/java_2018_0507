$(function() {
	cargarEditoriales();
	
	$('form').submit(function(e) {
		e.preventDefault();
		
		$.ajax({
			url: '/api/editoriales',
			method: 'PUT',
			data: JSON.stringify({ id: $('#id').val(), nombre: $('#nombre').val() }),
			contentType: 'application/json; charset=UTF-8'
		}).success(function() {
			cargarEditoriales();
			$('#nombre').val('');
			$('#id').val(0);
		});
	});
});

function cargarEditoriales() {
	$.getJSON('/api/editoriales', function(editoriales) {
		console.log(editoriales);
		
		mostrarEditoriales(editoriales);
	});
}

function mostrarEditoriales(editoriales) {
	$('tbody').empty();
	$(editoriales).each(function() {
		$('tbody').append(
				'<tr><th>' + this.id + "</th><td>" + this.nombre + '</td>' +
				'<td>' + 
				'<a href="javascript:editar(' + this.id + ')">Editar</a> ' +
				'<a href="javascript:borrar(' + this.id + ')">Borrar</a>' +
				'</tr>' );
	});
}

function editar(id) {
	$.getJSON('/api/editoriales/' + id, function(editorial) {
		$('#id').val(editorial.id);
		$('#nombre').val(editorial.nombre);
	});
}

function borrar(id) {
	if(confirm('¿Estás seguro de borrar la editorial ' + id)) {
		$.ajax({
			url: '/api/editoriales/' + id,
			method: 'DELETE',
		}).success(function() {
			cargarEditoriales();
		});
	}
}