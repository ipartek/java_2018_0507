$(function() {
	
	lista();
	$('#fincidencia').submit(function (e){
		e.preventDefault();
		
		var f = new Date();
		// var dia = f.getDate();
		// var mes = f.getMonth() +1;
		// var yyy = f.getFullYear();
		// var fecha_formateada = yyy + '-' + mes + '-' + dia;
		
		var inci= {
				fecha : f,
				titulo : $('#tituloi').val(),
				descripcion : $('#descripcioni').val()
				// usuario_asignado : $('#usuarioAsignadoi').val()
				// aqui iria del id del usuario, sacado de la sesion del login.
				// Cundo lo haga irme a la insert y meter el campo usuario_id
				
		}

		$.ajax({
			url : '/api/incidencias',
			method : 'POST',
			data : JSON.stringify(inci),
			contentType : 'application/json; charset=UTF-8'
		}).done(function() {
			
			$('#tituloi').val("");
			$('#descripcioni').val("");	
			lista();
			
		}).fail(function() {
			console.log("No se han insertado bien los datos");
		});
	});
	
		
});

function borrar(id){
	$.ajax({
		url: '/api/incidencias/'+ id,
		method : 'DELETE'
	}).done(function() {
		console.log("TODO OK");
		$('#inci_' + id).remove();
		lista();
	}).fail(function() {
		console.log(id + "esta mal metido");
	});
		
}

function lista(){	
	$.getJSON('/api/incidencias', function(inci) {
		$('#tincidencias > tbody').empty();
		$(inci).each(function() {
			$('#tincidencias > tbody').append('<tr><td>'+this.id+'</td><td>'+this.titulo+'</td><td>'+this.descripcion+
				'</td><td>'+this.fecha+'</td><td>'+this.usuario_asignado+'</td><td><a href="javascript:borrar(' + this.id +
				')">Borrar Indicendia</a></td></tr>');
			
		});
	});
	}
	