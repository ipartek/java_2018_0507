var editarid = 0;

$(function() {
	$('#flibros').submit(function(e) {
		e.preventDefault();

		var libro = {
			id : editarid,
			titulo : $('#titulo').val(),
			isbn : $('#isbn').val(),
			editorial : {
				id : $('#editorial').val(),
				nombre : $('#editorial option:selected').text()
			}
		}

		// $('#editorial')[0].selectedText

		$.ajax({
			url : '/api/libros',
			method : editarid == 0 ? 'POST': 'PUT',
			data : JSON.stringify(libro),
			contentType : 'application/json; charset=UTF-8'
		}).done(function(id) {
			if(editarid == 0) {
				libro.id = id;
				addFila(libro);
			} else {
				$('#libro_' + id).html(filaSinTrLibro(libro));
			}
		});
	});

	$.getJSON('/api/editoriales', function(editoriales) {
		$(editoriales).each(function() {
			$('#editorial').append('<option value="' + this.id + '">' + this.nombre + '</option>');
		});
	});

	$.getJSON('/api/libros', function(libros) {
		$(libros).each(function() {
			console.log(this);

			// var $tr = $('<tr>');
			//			
			// $('<th>').text(this.id).appendTo($tr);
			// $('<td>').text(this.titulo).appendTo($tr);
			// $('<td>').text(this.isbn).appendTo($tr);
			// $('<td>').text(this.editorial.nombre).appendTo($tr);
			// $editar = $('<a>').attr('href', 'javascript:editar(' +
			// this.id + ')').text('Editar');
			// $borrar = $('<a>').attr('href', 'javascript:borrar(' +
			// this.id + ')').text('Borrar');
			// $('<td>').append($editar).append('
			// ').append($borrar).appendTo($tr);
			//			
			// $('#tlibros > tbody').append($tr);
			//			
			addFila(this);
		});
	});
});

function borrar(id) {
	$.ajax({
		url : '/api/libros/' + id,
		method : 'DELETE'
	}).done(function() {
		$('#libro_' + id).html(filaLi);
	});
}

function editar(id) {
	$.getJSON('/api/libros/' + id, function(libro) {
		console.log(libro);
		
		$('#titulo').val(libro.titulo);
		$('#isbn').val(libro.isbn);
		$('#editorial').val(libro.editorial.id);
		
		editarid = libro.id;
	});
}

function addFila(libro) {
	$('#tlibros > tbody').append(filaLibro(libro));
}
function filaLibro(libro) {
	return '<tr id="libro_' + libro.id + '">'+filaSinTrLibro(libro)+'</tr>'
}

function filaSinTrLibro(libro){
	return '<th>' + libro.id + '</th><td>' + libro.titulo + '</td><td>' + libro.isbn
	+ '</td><td>' + libro.editorial.nombre + '</td><td><a href="javascript:editar(' + libro.id
	+ ')">Editar</a> <a href="javascript:borrar(' + libro.id + ')">Borrar</a></td>';
}