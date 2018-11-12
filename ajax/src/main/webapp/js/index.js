$(function() {
	$('#formulariolibros').hide().submit(enviarFormulario);
	
	pedirLibros();
});

function pedirLibros() {
	var jqxhr = $.ajax("libros")
	.done(rellenarTabla)
	.fail(function() { alert("error"); })
	.always(function() { console.log("complete"); });
}

function rellenarTabla(libros) {
	console.log("success");
	
	var $tablalibrosbody = $('#tablalibros > tbody');
	
	$tablalibrosbody.empty();
	
	$(libros).each(function() {
		$('<tr><th>' + this.id + '</th><td>' + this.nombre + '</td>' +
				'<td><a href="javascript:mostrarLibro('+ this.id + ')">Editar</a></td></tr>')
		.appendTo($tablalibrosbody);
		
		/*
		$(`
		<tr>
			<th>${this.id}</th>
			<td>${this.nombre}</td>
			<td><a href="javascript:mostrarLibro(${this.id})">Editar</a></td>
		</tr>
		`).appendTo($('#tablalibros > tbody'));
		*/
	});
}

function mostrarLibro(id) {
	var jqxhr = $.ajax("libros/" + id)
	.done(rellenarFormulario)
	.fail(function() { alert("error"); })
	.always(function() { console.log("complete"); });
}

function rellenarFormulario(libro) {
	$('#formulariolibros').show();
	
	$('#id').val(libro.id);
	$('#nombre').val(libro.nombre);
}

function enviarFormulario(e) {
	e.preventDefault();
	
	var vlibro = { id: $('#id').val(), nombre: $('#nombre').val() };
	
	console.log(vlibro);
	
	var jqxhr = $.ajax({
		method: 'PUT',
		url: 'libros',
		data: JSON.stringify(vlibro)
	})
	.done(function() { $('#formulariolibros').hide(); pedirLibros(); })
	.fail(function() { alert("error"); })
	.always(function() { console.log("complete"); });
}
