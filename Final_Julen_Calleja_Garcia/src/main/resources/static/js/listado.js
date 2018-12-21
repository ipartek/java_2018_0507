$(function() {
	
	lista();
	$('#fproducto').submit(function (e){
		e.preventDefault();
		
		var prod= {
				
				titulo : $('#titulo').val(),
				descripcion : $('#descripcion').val(),
				precio : $('#precio').val()

		}

		$.ajax({
			url : '/api/listado',
			method : 'POST',
			data : JSON.stringify(prod),
			contentType : 'application/json; charset=UTF-8'
		}).done(function() {
			
			$('#titulo').val("");
			$('#descripcion').val("");	
			$('#precio').val("");
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
	$.getJSON('/api/listado', function(prod) {
		$('#list');
		$(prod).each(function() {
			$('#list').append('<p>'+this.id+'</p><p>'+this.nombre+'</p><p>'+this.imagen+
				'</p><p>'+this.descripcion+'</p><p>'+this.precio+'</p><p><a href="javascript:editar(' + this.id +
				')">Editar</a></p>');
			
		});
	});
	}
	