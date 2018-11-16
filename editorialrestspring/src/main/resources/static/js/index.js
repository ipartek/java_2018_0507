$(function() {
	$.getJSON('/api/editoriales', function(datos) {
		$(datos).each(function() {
			console.log(this);
			$('tbody').append('<tr><th>' + this.id + '</th><td>' + this.nombre + '</td></tr>');
		});
	});
	
	$('#fEditorial').submit(function(e) {
		e.preventDefault();
		
		buscarPorId();
	});
	
	$('#crearEditorial').click(function(){
		crearEditorial();
	});
	
	$('#modificarEditorial').click(function() {
		modificarEditorial();
	});
	
	$('#borrarEditorial').click(function() {
		borrarEditorial();
	});
});

function buscarPorId(){
	var idEditorial = $('#idEditorial').val();
	
	$.getJSON('/api/editoriales/' + idEditorial, respuestarest)
}

function respuestarest(respuesta) {
	$('#respuestaId').html('Id: ' + respuesta.id + ' nombre: ' + respuesta.nombre);
}

function crearEditorial(){
	var vEditorial = {
			id : parseInt($('#id').val()),
			nombre : $('#nombre').val()
		};

	$.ajax{
		url: "/api/editoriales",
		method: "POST",
		data : JSON.stringify(vEditorial)
	}).done(function() {
		// ocultarFormulario();
		// pedirLibros();
		alert("CORRECTO");
	}).fail(function() {
		alert("error");
	}).always(function() {
		console.log("complete");
	});
}

function modificarEditorial(){
	var vEditorial = {
			id : parseInt($('#id').val()),
			nombre : $('#nombre').val()
		};
	
	$.ajax{
		url: "/api/editoriales",
		method: "PUT",
		data : JSON.stringify(vEditorial)
	}).done(function() {
		// ocultarFormulario();
		// pedirLibros();
		alert("CORRECTO");
	}).fail(function() {
		alert("error");
	}).always(function() {
		console.log("complete");
	});
}

function borrarEditorial(){
	if (confirm('¿Estás seguro de que quieres borrar el libro cuyo id es ' + id + '?')) {
		var idBorrar = $('#id').val();
		
		$.ajax{
			url: "/api/editoriales/"+idBorrar,
			method: "DELETE"
		}).done(function() {
			// pedirLibros();
			alert("CORRECTO");
		}).fail(function() {
			alert("error");
		}).always(function() {
			console.log("complete");
		});
	}else{
		alert('No se borrará el libro');
	}
}
