$(function() {
	$('#formulariolibros').hide();
	
	var jqxhr = $.ajax("libros")
		.done(rellenarTabla)
		.fail(function() { alert("error"); })
		.always(function() { console.log("complete"); });
});

function rellenarTabla(libros) {
	console.log("success");
	
	$(libros).each(function() {
		$('<tr><th>' + this.id + '</th><td>' + this.nombre + '</td>' +
				'<td><a href="javascript:mostrarLibro('+ this.id + ')">Editar</a></td></tr>')
		.appendTo($('#tablalibros > tbody'));
		
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
