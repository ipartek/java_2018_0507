$(function(){
	alert('yeaa');
	cargarLibros();
});

function cargarLibros() {
	$.getJSON('/api/libros', function(libros) {
		console.log(libros);
		
		mostrarLibros(libros);
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