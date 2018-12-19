$(function() {
    mostrarSeccionMisIncidencias();

    /* Botones admin */
    /* Incidencias */
    $("#btnAdminIncidencias").click(function(e){
        e.preventDefault();
        mostrarTodasLasIncidencias();
    });
    $("#formNuevaIncidencia").submit(enviarFormularioIncidencia);
    /* Historico */
    $("#btnAdminHistorico").click(function(e){
        e.preventDefault();
        mostrarHistorico();
    });
    /* Usuarios */
    $("#btnAdminUsuarios").click(function(e){
        e.preventDefault();
        mostrarUsuarios();
    });
    
    $("#btnCancelarNuevoUsuario").click(function(){
    	cancelarCrearUsuario();
    });
   
    //javascript:crearUsuario()
    //$("#formularioNuevoUsuario").submit(enviarFormularioUsuario);
    //javascript:modificarUsuario()
    $('.btn_save').click(function(){
        enviarFormularioModificarUsuario();
    }); 
    //javascript:cancelarModificarUsuario();
    //javascript:borrarUsuario()
});

/*******************
 * 	  Globales	   *
 *******************/
function ocultarTodo(){
    //Ocultar todas las secciones
	$("#seccionMisIncidencias").hide();
	$("#formNuevaIncidencia").hide();
	$("#seccionUsuarios").hide();
	$("#formNuevoUsuario").hide();
	$("#seccionHistoricos").hide();
}

/*******************
 * Mis incidencias *
 *******************/
function mostrarSeccionMisIncidencias(){
    ocultarTodo();
    
    var id = $("#userID").val();
	
    $.getJSON('/api/incidencias/open/'+ id, function(incidencias) {
		console.log(incidencias);
		mostrarMisIncidencias(incidencias);
	});
}

function mostrarMisIncidencias(incidencias){
	$('#tbodyMisIncidencias').empty();
	$(incidencias).each(function() {
		$('#tbodyMisIncidencias').append(
						'<tr class="i'+this.id+'">' + 
							'<td>'+ 
								'<a href="javascript:mostrarIncidenciaCompleta('+ this.id +')" class="btn btn-success btn-sm">' + 
									'<i class="fas fa-plus"></i>' +
								'</a>' +
							'</td>'+ 
							'<td>'+ this.fecha + '</td>'+ 
							'<td>'+ this.usuarioCreador.nombre + '</td>'+ 
							'<td>'+ this.titulo + '</td>'	+ 
							'<td>'+ this.descripcion + '</td>'+ 
							'<td>'+ this.usuarioAsignado.nombre + '</td>'+ 
							'<td>'+ 
								'<a href="javascript:modificarIncidencia('+ this.id +')"><i class="far fa-edit fa-lg"></i></a> '+
								'<a href="javascript:borrarIncidencia('+ this.id +')"><i class="far fa-trash-alt fa-lg"></i></a>'+ 
							'</td>' + 
						'</tr>');
		$('#tbodyMisIncidencias').append(
				'<tr class="d'+this.id+'">' +
				'</tr>');
	});
	
	$("#seccionMisIncidencias").show();
}

//Ampliar / Comprimir fila de cartas con incidencia completa
function mostrarIncidenciaCompleta(id){
    // Pedir historico de incidencia por ajax
	$.getJSON('/api/historicos/open/' + id, function(historicos){
		console.log(historicos);
		mostrarHistoricoIncidencia(historicos);
	});
}

function mostrarHistoricoIncidencia(historicos){
	//Obtener id fila
	var idFila = historicos[0].incidencia.id;
	
	$(".d"+idFila).empty();
	
	console.log("idFila: " + idFila);
	
	var tablaAppend = '<table class="table">';
	$(historicos).each(function(){
		tablaAppend += '<tr>' +
							'<td>' +
							'<div class="card">' +
								'<div class="card-header">'+ this.incidencia.id +' / '+ this.usuario.nombre +' / '+ this.estado +'</div>' +
								'<div class="card-body">' +
									'<h5 class="card-title">'+ this.incidencia.titulo +'</h5>' +
									'<p class="card-text">'+ this.comentario +'</p>' +
								'</div>' +
								'<div class="card-footer">'+ this.fecha +'</div>' +
							'</div>' +
						'</td>' +
						'</tr>';
	});
	$(tablaAppend).appendTo(".d"+idFila).slideDown("slow");
}

// Mostrar crear nueva incidencia
function nuevaIncidencia(){
    //Ocultar tabla mis incidencias
	$("#tablaMisIncidencias").hide();
  
	$.getJSON('/api/usuarios/admin', function(usuarios) {
		console.log(usuarios);
		$('#inputUsuarioAsignado').empty();
		$('#inputUsuarioAsignado').append('<option value="0">Usuario Asignado</option');
		$(usuarios).each(function() {
			$('#inputUsuarioAsignado').append('<option value="'+this.id+'">'+this.nombre+'</option>');
		});
	});
	
	//Mostrar formulario crear incidencia
	$("#formNuevaIncidencia").show();
}

// Crear nueva incidencia
function enviarFormularioIncidencia(e){
	e.preventDefault();
	
	var incidencia = {
			fecha : new Date(),
			titulo : $('#inputTitulo').val(),
			descripcion: $('#inputDescripcion').val(),
			usuarioCreadorId : $("#userID").val(),
			usuarioAsignadoId : $('#inputUsuarioAsignado').val()
		};

		console.log(incidencia);

		$.ajax({
			method : 'POST',
			url : 'incidencias', 
			data : JSON.stringify(incidencia)
		}).done(function() {
			console.log("TODO OK");
			mostrarSeccionMisIncidencias();
		}).fail(function() {
			alert("Error al intentar crear una incidencia");
		});
}

// Añadir comentario
function modificarIncidencia(id){
    //Cargar datos "principales" de la incidencia por ajax

    //Ampliar fila de tabla y mostrar formulario nuevo para comentario
    

}

// Cerrar la incidencia / darla por arreglada
function borrarIncidencia(id){
    //Cargar datos "principales de la incidencia" por ajax
	if (confirm('¿Estás seguro desea dar por solucionada la incidencia ' + id)) {
		$.ajax({
			url : '/api/incidencias/' + id,
			method : 'DELETE',
		}).done(function() {
			mostrarSeccionMisIncidencias();
		}).fail(function(){
			alert("ERROR AL BORRAR");
		});
	}
}


/*******************
 * 		ADMIN 	   *
 *******************/

/*******************
 * 	 Incidencias   *
 *******************/
function mostrarTodasLasIncidencias(){
    ocultarTodo();

    //Llamada ajax todas las incidencias abiertas
    
    //Mostrar tabla todas las incidencias abiertas

}

/*******************
 * 	  Historico    *
 *******************/
function mostrarHistorico(){
	ocultarTodo();
    
    $.getJSON('/api/historicos/', function(historicos) {
		console.log(historicos);
		mostrarDatosHistoricos(historicos);
	});
}

function mostrarDatosHistoricos(historicos){
	$('#tbodyHistoricos').empty();
	$(historicos).each(function() {
		$('#tbodyHistoricos').append(
						'<tr>' + 
							'<th>'+ this.id + '</th>' + 
							'<td>'+ this.nombre + '</td>'+ 
							'<td>'+ this.email + '</td>'+ 
							'<td>'+ this.password + '</td>'	+ 
							'<td>'+ 
								'<a href="javascript:modificarHistorico('+ this.id +')"><i class="far fa-edit fa-lg"></i></a> '+
								'<a href="javascript:borrarHistorico('+ this.id +')"><i class="far fa-trash-alt fa-lg"></i></a>'+ 
							'</td>' + 
						'</tr>');
	});
	
	$("#seccionHistoricos").show();
}

function modificarHistorico(id){
	
}

function borrarHistorico(id){
	
}

/*******************
 * 	  Usuarios 	   *
 *******************/
function mostrarUsuarios(){
	ocultarTodo();
    
    $.getJSON('/api/usuarios/', function(usuarios) {
		console.log(usuarios);
		mostrarDatosUsuarios(usuarios);
	});
}

function mostrarDatosUsuarios(usuarios){
	$('#tbodyUsuarios').empty();
	$(usuarios).each(function() {
		$('#tbodyUsuarios').append(
						'<tr>' + 
							'<th>'+ this.id + '</th>' + 
							'<td>'+ this.nombre + '</td>'+ 
							'<td>'+ this.email + '</td>'+ 
							'<td>'+ this.password + '</td>'	+ 
							'<td>'+ this.rol + '</td>'	+ 
							'<td>'+ 
								'<a href="javascript:modificarUsuario('+ this.id +')"><i class="far fa-edit fa-lg"></i></a> '+
								'<a href="javascript:borrarUsuario('+ this.id +')"><i class="far fa-trash-alt fa-lg"></i></a>'+ 
							'</td>' + 
						'</tr>');
	});
	
	$("#seccionUsuarios").show();
}

function crearUsuario(){
    //Ocultar tabla Usuarios
	$("#tablaUsuarios").hide(); 
	
	//Mostrar formulario crear usuario
	$("#formNuevoUsuario").show();
}

function cancelarCrearUsuario(){
	$("#formNuevoUsuario").trigger("reset");
	$("#formNuevoUsuario").hide();
	$("#tablaUsuarios").show();
}

function enviarFormularioNuevoUsuario(e){
    e.preventDefault();

	var vUsuario = {
        nombre : $('#nombre').val(),
        email : $('#email').val(),
        password: $('#password').val()
	};

	console.log(vUsuario);

	$.ajax({
		method : 'POST',
		url : 'usuarios', 
		data : JSON.stringify(vUsuario)
	}).done(function() {
		mostrarUsuarios();
	}).fail(function() {
		alert("Error al intentar crear el usuario");
	});
}

function modificarUsuario(id){
    var tbl_row = $(this).closest('tr');

    var row_id = tbl_row.attr('row_id');

    tbl_row.find('.btn_save').show();
    tbl_row.find('.btn_cancel').show();

    //hide edit button
    tbl_row.find('.btn_edit').hide(); 

    //make the whole row editable
    tbl_row.find('.row_data')
    .attr('contenteditable', 'true')
    .attr('edit_type', 'button')
    .addClass('bg-warning')
    .css('padding','3px')

    tbl_row.find('.row_data').each(function(index, val) 
    {  
        //this will help in case user decided to click on cancel button
        $(this).attr('original_entry', $(this).html());
    }); 		
}

function cancelarModificarUsuario(){
	var tbl_row = $(this).closest('tr');

	var row_id = tbl_row.attr('row_id');

	//hide save and cacel buttons
	tbl_row.find('.btn_save').hide();
	tbl_row.find('.btn_cancel').hide();

	//show edit button
	tbl_row.find('.btn_edit').show();

	//make the whole row editable
	tbl_row.find('.row_data')
	.attr('edit_type', 'click')	 
	.removeClass('bg-warning')
	.css('padding','') 

	tbl_row.find('.row_data').each(function(index, val){   
		$(this).html( $(this).attr('original_entry') ); 
	});  
}

function enviarFormularioModificarUsuario(){
    event.preventDefault();
	var tbl_row = $(this).closest('tr');

	var row_id = tbl_row.attr('row_id');

	var arr = {}; 
	tbl_row.find('.row_data').each(function(index, val) 
	{   
		var col_name = $(this).attr('col_name');  
		var col_val  =  $(this).html();
		arr[col_name] = col_val;
	});

	//use the "arr"	object for your ajax call
	$.extend(arr, {row_id:row_id});

    console.log(arr);

	/*var vUsuario = {
		id : parseInt($('#id').val()),
        nombre : $('#nombre').val(),
        email : $('#email').val(),
        password: $('#password').val()
	};

	console.log(vUsuario);

	$.ajax({
		method : 'PUT',
		url : 'usuarios/' + vUsuario.id, 
		data : JSON.stringify(vUsuario)
	}).done(function() {
		mostrarUsuarios();
	}).fail(function() {
		alert("Error al intentar modificar el usuario");
	});*/
}

/*<table class="table table-hover">
	<thead>
        <tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Options</th>
		</tr>
    </thead>
    <tbody>
        <tr row_id="'+row_id+'">
			<td><div class="row_data" edit_type="click" col_name="fname">nombre</div></td>
			<td><div class="row_data" edit_type="click" col_name="lname">apellido</div></td>
			<td><div class="row_data" edit_type="click" col_name="email">email</div></td>
            <td>
				<span class="btn_edit"><a href="#" class="btn btn-link" row_id="'+row_id+'">Edit</a></span>
                //only show this button if edit button is clicked
                <span class="btn_save"><a href="#" class="btn btn-link" row_id="'+row_id+'"> Save</a> | </span>
                <span class="btn_cancel"><a href="#" class="btn btn-link" row_id="'+row_id+'"> Cancel</a></span>
            </td>
        </tr>
    </tbody>
</table>*/

function borrarUsuario(id){
    //Modal con llamada ajax para borrar usuario

    mostrarUsuarios();
}