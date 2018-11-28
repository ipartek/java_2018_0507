$(function() {
	cargarDatos();
	cambiarMenu();
	
	$(".nav-link").click(function(){
		cambiarMenu(this.id);
	});

	$('form').submit(function(e) {
		e.preventDefault();
		enviarForm();
	});
});

function ocultarMenus(){
	$("#sectionAlumnos").hide();
	$("#sectionEditoriales").hide();
	$("#sectionLibros").hide();
}

function cambiarMenu(idLink){
	ocultarMenus();
	
	switch(idLink) {
	    case "librosLink":
	    	$("#sectionLibros").show();
	        break;
	    case "editorialesLink":
	    	$("#sectionEditoriales").show();
	        break;
	    case "alumnosLink":
	    	$("#sectionAlumnos").show();
	    	break;
	    default:
	    	$("#sectionLibros").show();
	}
}

function cargarDatos(){
	cargarLibros();
	cargarEditoriales();
	cargarAlumnos();
}
function cargarLibros() {
	$.getJSON('/api/libros', function(libros) {
		console.log(libros);
		mostrarLibros(libros);
	});
}
function mostrarLibros(libros) {
	$('#tbodyLibros').empty();
	$(libros).each(function() {
		$('#tbodyLibros').append(
				'<tr>'+
					'<th>' + this.id + '</th>' +
					'<td>' + this.titulo + '</td>' +
					'<td>' + this.isbn + '</td>' +
					'<td>' + this.editorial.nombre + '</td>' +
					'<td></td>' +
					'<td></td>' +
					'<td></td>' +
					'<td></td>' +
					'<td></td>' +
					'<td>' + 
						'<a href="gestionPrestamo?operacion=prestamo&id=' + this.id +'" class="btn btn-primary">' +
						'<i class="fab fa-leanpub"></i>&nbsp;Prestar</a>' +
						'<a href="gestionPrestamo?operacion=devolver&id=' + this.id +'" class="btn btn-danger">' +
						'<i class="fas fa-undo"></i>&nbsp;Devolver</a>' +
						'<a href="gestionPrestamo?operacion=ampliar&id=' + this.id +'" class="btn btn-success">+7</a>' +
						'<a href="javascript:editar(' + this.id + ')"><i class="far fa-edit fa-lg"></i></a> ' +
						'<a href="javascript:borrar(' + this.id + ')"><i class="far fa-trash-alt fa-lg"></i></a>' +
					'</td>' +
				'</tr>' );
	});
	
	$("#tablaLibros").DataTable();
}

function cargarEditoriales() {
	$.getJSON('/api/editoriales', function(editoriales) {
		console.log(editoriales);
		mostrarEditoriales(editoriales);
	});
}

function mostrarEditoriales(editoriales) {
	$('#tbodyEditoriales').empty();
	$(editoriales).each(function() {
		$('#tbodyEditoriales').append(
				'<tr>'+
					'<th>' + this.id + '</th>' +
					'<td>' + this.nombre + '</td>' +
					'<td>' + 
						'<a href="javascript:editar(' + this.id + ')"><i class="far fa-edit fa-lg"></i></a> ' +
						'<a href="javascript:borrar(' + this.id + ')"><i class="far fa-trash-alt fa-lg"></i></a>' +
					'</td>' +
				'</tr>' );
	});
	$('#tablaEditoriales').DataTable();
}

function cargarAlumnos() {
	$.getJSON('/api/alumnos', function(alumnos) {
		console.log(alumnos);
		mostrarAlumnos(alumnos);
	});
}

function mostrarAlumnos(alumnos) {
	$('#tbodyAlumnos').empty();
	$(alumnos).each(function() {
		$('#tbodyAlumnos').append(
				'<tr>'+
					'<th>' + this.id + '</th>' +
					'<td>' + this.nombre + '</td>' +
					'<td>' + this.apellido + '</td>' +
					'<td>' + this.dni + '</td>' +
					'<td>' + 
						'<a href="javascript:editar(' + this.id + ')"><i class="far fa-edit fa-lg"></i></a> ' +
						'<a href="javascript:borrar(' + this.id + ')"><i class="far fa-trash-alt fa-lg"></i></a>' +
					'</td>' +
				'</tr>' );
	});
	$('#tablaAlumnos').DataTable();
}

function enviarForm(){
	var editorialid = $('#id').val();
	var editorialnombre = $('#nombre').val();
	var metodo = editorialid == 0 ? 'POST' : 'PUT';
	
	$.ajax({
		url: '/api/editoriales',
		method: metodo,
		data: JSON.stringify({ id: editorialid, nombre: editorialnombre }),
		contentType: 'application/json; charset=UTF-8'
	}).success(function() {
		cargarEditoriales();
		$('#nombre').val('');
		$('#id').val(0);
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
