$(function() {
	ocultarFormulario();
	
	$('#formulariolibros').submit(enviarFormulario);
	
	$('#botoncancelar').click(function(e) {
		e.preventDefault();
		
		ocultarFormulario();
	});
	
	$('#enlaceNuevoLibro').click(function(e) {
		e.preventDefault();
		
		mostrarFormulario();
	});
	
	pedirLibros();
});

function pedirLibros() {
	$.ajax("libros").done(rellenarTabla).fail(function() { //Al cargar rellenar libros
		alert("error");
	}).always(function() {
		console.log("complete");
	});
}

function rellenarTabla(libros) {
	console.log("success");

	var $tablalibrosbody = $('#tablalibros > tbody');

	$tablalibrosbody.empty();

	$(libros).each(  //Por cada libro mostrar los links de editar y borrar
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
	$.ajax("libros/" + id).done(rellenarFormulario).fail(function() {  //Error al mostrar el libro con ese id
		alert("error");
	}).always(function() {
		console.log("complete");
	});
}

function rellenarFormulario(libro) {
	mostrarFormulario();

	$('#id').val(libro.id);
	$('#nombre').val(libro.nombre);
}

function enviarFormulario(e) {
	e.preventDefault();  //Evitar el acion del form

	var vlibro = {
		id : parseInt($('#id').val()),  //Convertir a int para que el servlet no falle
		nombre : $('#nombre').val()
	};

	console.log(vlibro);

	$.ajax({
		method : (vlibro.id ? 'PUT' : 'POST'), //Si id == 0 se hace POST y si no PUT
		url : 'libros' + (vlibro.id ? '/' + vlibro.id : ''), //Si id != 0 se agrega /id
		data : JSON.stringify(vlibro)
	}).done(function() {
		ocultarFormulario();
		pedirLibros();
	}).fail(function() {
		alert("error");
	}).always(function() {
		console.log("complete");
	});
}

function borrarLibro(id) {
	if (confirm('�Est�s seguro de que quieres borrar el libro cuyo id es ' + id
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
		alert('No se borrar� el libro');
	}
}

function mostrarFormulario() {
	$('#enlaceNuevoLibro').hide();
	$('#formulariolibros').show();
}

function ocultarFormulario() {
	$('#enlaceNuevoLibro').show(); // mostrar boton de crear libro
	$('#formulariolibros').hide();  //ocultar formulario
	$('#formulariolibros').trigger('reset');  //lanza el evento reset -- el evento reset te los pone a valor por defecto
	$('#id').val(0);
}
