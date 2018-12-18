$(function() {
	$('#fincidencia').submit(function e(){
		e.preventDefault();
		
		var incidencia= {
				
				fecha : $('#fecha').val(),
				titulo : $('#titulo').val(),
				descripcion : $('#descripcion').val(),
				usuario_asignado : $('#usuarioAsignado').val()
		}
		

		$.ajax({
			url : '/api/incidencias',
			method : 'POST',
			data : JSON.stringify(incidencia),
			contentType : 'application/json; charset=UTF-8'
		}).done(function() {
			
			$('#tituloi').val("");
			$('#descripcioni').val("");
			$('#fechai').val("");
			$('#usuarioAsignadoi').val();
		});
	});
		
	$.getJSON('/api/incidencias', function(inci) {
		$('#tincidencias > tbody').empty();
		$(inci).each(function() {
			$('#tincidencias > tbody').append('<tr><td>'+this.id+'</td><td>'+this.titulo+'</td><td>'+this.descripcion+
				'</td><td>'+this.fecha+'</td><td>'+this.usuario_asignado+'</td></tr>');
			
		});
	});

		
});