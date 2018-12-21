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
		url: '/api/listado/'+ id,
		method : 'DELETE'
	}).done(function() {
		console.log("TODO OK");
		$('#prod_' + id).remove();
		lista();
	}).fail(function() {
		console.log(id + "esta mal metido");
	});
		
}

function lista(){	
	$.getJSON('/api/listado', function(prod) {
		$('#list');
		$(prod).each(function() {
			$('#list').append('<div class="col-sm-6 col-md-4 col-lg-3"><div class="thumbnail"><img src= "../IMG/'+this.imagen+'"</p><p>'+this.nombre+'</p><p>'
					+this.descripcion+'</p><p>'+this.precio+'</p><p><a class="btn btn-primary" href="javascript:editar(' + this.id +
				')">Editar</a> <a class="btn btn-danger" href="javascript:borrar(' + this.id +
				')">Borrar</a></p></div></div>');
			
		});
	});
}
	