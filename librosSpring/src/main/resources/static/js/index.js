$(function(){
	cargarLibros();
	$('#exampleModal').on('hidden.bs.modal', function () {
		$('#titulo').val('');
		$('#isbn').val('');
		$('#editorial').val('');
		$('#id').val(0);
		$('#autor').val('');
	});
	$('#formRegLibro').submit(function(e){
		var libroid = $('#id').val();
		var libroNombre = $('#titulo').val();
		var isbnlibro=$('#isbn').val();
		var editoriallibro=$('#editorial').val();
		var autorLibro=$('#autor').val();
		var metodo = libroid == 0 ? 'POST' : 'PUT';
		e.preventDefault();
		$.ajax({
			url: '/api/libros',
			method: metodo,
			data: JSON.stringify({ id: libroid,titulo: libroNombre,editorial: editoriallibro,isbn: isbnlibro,autor:autorLibro }),
			contentType: 'application/json; charset=UTF-8'
		}).success(function() {
			cargarLibros();
			$('#titulo').val('');
			$('#isbn').val('');
			$('#editorial').val('');
			$('#id').val(0);
			$('#autor').val('');
			 $('#exampleModal').modal('toggle');
		});
	});
});

function cargarLibros() {
	$.getJSON('/api/libros', function(libros) {
		console.log(libros);
		
		mostrarLibros(libros);
	});
}
function borrar(id){
	if (confirm('¿Estás seguro de que quieres borrar el libro cuyo id es ' + id + '?')) {

		$.ajax({
			method : 'DELETE',
			url : 'api/libros/' + id
		}).done(function() {
			cargarLibros();
		}).fail(function() {
			alert("error");
		}).always(function() {
			console.log("complete");
		});
	} else {
		alert('No se borrará el libro');
	}
}
function editar(id){
	$.getJSON('/api/libros/'+ id,function(libro){
		console.log(libro);
		$('#exampleModal').modal('show'); 
		$('#titulo').val(libro.titulo);
		$('#isbn').val(libro.isbn);
		$('#editorial').val(libro.editorial);
		$('#id').val(libro.id);
		$('#autor').val(libro.autor);
	});
}
function mostrarLibros(libros) {
	$('tbody').empty();
	$(libros).each(function() {
		$('tbody').append(
				'<tr><th>' + this.titulo + "</th><td>" + this.isbn + '</td>' +"<td>" + this.editorial + '</td>'+"<td>" + this.autor + '</td>'+
				'<td>' + 
				'<a href="javascript:editar(' + this.id + ')">Editar</a> ' +
				'<a href="javascript:borrar(' + this.id + ')">Borrar</a>' +
				'</tr>' );
	});
}