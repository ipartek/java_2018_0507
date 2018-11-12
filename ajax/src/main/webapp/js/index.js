$(function() {
	$('#formulariolibros').hide().submit(enviarFormulario);

	pedirLibros();
});

function pedirLibros() {
	$.ajax("libros").done(rellenarTabla).fail(function() {
		alert("error");
	}).always(function() {
		console.log("complete");
	});
}

function rellenarTabla(libros) {
	console.log("success");

	var $tablalibrosbody = $('#tablalibros > tbody');

	$tablalibrosbody.empty();

	$(libros).each(
			function() {
				$(
						'<tr><th>' + this.id + '</th><td>' + this.nombre
								+ '</td>'
								+ '<td><a href="javascript:mostrarLibro('
								+ this.id + ')">Editar</a> '
								+ '<a href="javascript:borrarLibro(' + this.id
								+ ')">Borrar</td></tr>').appendTo(
						$tablalibrosbody);

				/*
				 * $(` <tr> <th>${this.id}</th> <td>${this.nombre}</td> <td><a
				 * href="javascript:mostrarLibro(${this.id})">Editar</a></td>
				 * </tr> `).appendTo($('#tablalibros > tbody'));
				 */
			});
}

function mostrarLibro(id) {
	$.ajax("libros/" + id).done(rellenarFormulario).fail(function() {
		alert("error");
	}).always(function() {
		console.log("complete");
	});
}

function rellenarFormulario(libro) {
	$('#formulariolibros').show();

	$('#id').val(libro.id);
	$('#nombre').val(libro.nombre);
}

function enviarFormulario(e) {
	e.preventDefault();

	var vlibro = {
		id : $('#id').val(),
		nombre : $('#nombre').val()
	};

	console.log(vlibro);

	$.ajax({
		method : 'PUT',
		url : 'libros',
		data : JSON.stringify(vlibro)
	}).done(function() {
		$('#formulariolibros').hide();
		pedirLibros();
	}).fail(function() {
		alert("error");
	}).always(function() {
		console.log("complete");
	});
}

function borrarLibro(id) {
	if (confirm('¿Estás seguro de que quieres borrar el libro cuyo id es ' + id
			+ '?')) {

		$.ajax({
			method : 'DELETE',
			url : 'libros/' + id
		}).done(function() {
			pedirLibros();
		}).fail(function() {
			alert("error");
		}).always(function() {
			console.log("complete");
		});
	} else {
		alert('No se borrará el libro');
	}
}