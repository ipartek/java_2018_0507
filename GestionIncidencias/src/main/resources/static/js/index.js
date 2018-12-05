$(function() {
    mostrarSeccionMisIncidencias();


    /* Botones admin */
    /* Incidencias */
    $("#btnAdminIncidencias").click(function(){
        e.preventDefault();
        mostrarTodasLasIncidencias();
    });
    /* Historico */
    $("#btnAdminHistorico").click(function(){
        e.preventDefault();
        mostrarHistorico();
    });
    /* Usuarios */
    $("#btnAdminUsuarios").click(function(){
        e.preventDefault();
        mostrarUsuarios();
    });
   
    //javascript:crearUsuario()
    $("#formularioNuevoUsuario").submit(enviarFormularioUsuario);
    //javascript:modificarUsuario()
    $('.btn_save').click(function(){
        enviarFormularioModificarUsuario();
    }); 
    //javascript:cancelarModificarUsuario();
    //javascript:borrarUsuario()
});

function ocultarTodo(){
    //Ocultar todas las secciones

}

function mostrarSeccionMisIncidencias(){
    ocultarTodo();

    //mostrar seccion mis incidencias

}

/*Mis incidencias*/

// Crear una nueva
function nuevaIncidencia(){
    //Ocultar tabla mis incidencias

    //Mostrar formulario crear incidencia

}

// Añadir comentario
function modificarIncidencia(){
    //Cargar datos "principales" de la incidencia por ajax

    //Ampliar fila de tabla y mostrar formulario nuevo para comentario
    

}

// Cerrar la incidencia / darla por arreglada
function borrarIncidencia(){
    //Cargar datos "principales de la incidencia" por ajax

    //Amplicar fila de tabla y mostrar formulario para comentario y boton "cerrar incidencia"

}

// Ampliar / Comprimir fila de cartas con incidencia completa
function mostrarIncidenciaCompleta(){
    // Pedir historico de incidencia por ajax
    
    //Mostrar datos de incidencia

}


/*** ADMIN ***/

/* INCIDENCIAS*/
function mostrarTodasLasIncidencias(){
    ocultarTodo();

    //Llamada ajax todas las incidencias abiertas
    
    //Mostrar tabla todas las incidencias abiertas

}

/* HISTORICO */
function mostrarHistorico(){
    ocultarTodo();

    //Llamada ajax todas las incidencias con historico
    
    //Mostrar tabla historico
}

/* USUARIOS */
function mostrarUsuarios(){
    ocultarTodo();

    //Llamada ajax mostrar todos los usuarios

    //Mostrar Tabla usuarios
}

function crearUsuario(){
    //Ocultar tabla Usuarios

    //Mostrar formulario nuevo usuario

}

function enviarFormularioNuevoUsuario(){
    e.preventDefault();

	var vUsuario = {
		id : parseInt($('#id').val()),
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

function modificarUsuario(){
    event.preventDefault();
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
    event.preventDefault();

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

function borrarUsuario(){
    //Modal con llamada ajax para borrar usuario

    mostrarUsuarios();
}