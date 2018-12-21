$(function() {
	ocultarTodo();
	obtenerAlmacen();
	obtenerProductosUsuario();
	
	$("#btnAdminMantenimientoProductos").click(function(){
		obtenerTodosLosProductos();
	});
	
	$("#btnAdminMantenimientoRemotos").click(function(){
		obtenerProductosPorAlmacen();
	});
	
	$("#formProducto").submit(enviarFormularioProducto);
	$("#formProductoCompleto").submit(enviarFormularioProductoCompleto);
	
	$("#btnBuscarPorUbicacion").click(function(){
		var idAlmacen = $("#inputBuscarPorUbicacion option:selected").val();
		buscarProductosPorAlmacen(idAlmacen);
	});
	
	$("#btnCancelarCrearProducto").click(function(){
		ocultarTodo();
		$('#formProducto').trigger("reset");
		$("#inputProductoId").val("0");
		$("#sectionContentMantenimientoProductos").show();
		$("#tablaTodosLosProductos").show();
	});
	
	$("#btnCancelarCrearProductoCompleto").click(function(){
		ocultarTodo();
		$("#formProductoCompleto").trigger("reset");
		$("#inputProductoCompletoId").val("0");
		$("#sectionContentMantenimientoProductosRemotos").show();
		$("#tablaProductosRemotos").show();
	});
	
});

function ocultarTodo(){
	$("#sectionContentUser").hide();
	$("#sectionContentMantenimientoProductos").hide();
	$("#sectionContentMantenimientoProductosRemotos").hide();
	$("#formProducto").hide();
	$("#formProductoCompleto").hide();
}

function obtenerAlmacen(){
	var idUbicacion = $("#localizacionDefault").val();
	console.log("almacenId: "+idUbicacion);
  $.getJSON('/api/almacenes/'+ idUbicacion, function(almacen) {
		console.log("almacen: "+ almacen);
		$("#nombreUbicacionPorDefecto").text(almacen.nombre);
	});
	
}

function obtenerProductosUsuario(){
	 var idUbicacion = $("#localizacionDefault").val();
		
    $.getJSON('/api/productos/almacen/'+idUbicacion, function(productos) {
		console.log("productos usuario: "+productos);
		mostrarProductosUsuario(productos);
	});
}

function mostrarProductosUsuario(productos){
	$("#containerProductos").empty();
	$(productos).each(function(producto){
		$("#containerProductos").append('<div class="col-sm-6"><div class="card" style="width: 18rem;">'+
				  '<img class="card-img-top" src="/img/imagen'+this.id+'.jpg" alt="Card image cap">'+
				  '<div class="card-body">'+
				   '<h5 class="card-title">'+this.nombre+'</h5>'+
				    '<p class="card-text">'+this.descripcion+'</p>'+
				    '<p class="card-text">PVP '+this.precio+' €</p>'+
				  '</div>'+
				'</div></div>');
	});
	
	$("#sectionContentUser").show();
}

function obtenerTodosLosProductos(){
	 $.getJSON('/api/productos', function(productos) {
		console.log("todos los productos" +productos);
		mostrarProductos(productos);
	});
}

function mostrarProductos(productos){
	$("#tbodyTodosLosProductos").empty();
	$(productos).each(function(producto){
		$("#tbodyTodosLosProductos").append('<tr>' + 
				'<th>'+this.id+'</td>'+ 
			'<td>'+ this.nombre + '</td>'+ 
			'<td>'+ this.descripcion + '</td>'+ 
			'<td>'+ this.precio + '</td>'	+ 
			'<td>'+ this.imagen + '</td>'+ 
			'<td>'+ 
				'<a href="javascript:modificarProducto('+ this.id +')"><i class="far fa-edit fa-lg"></i></a> '+
				'<a href="javascript:borrarProducto('+ this.id +')"><i class="far fa-trash-alt fa-lg"></i></a>'+ 
			'</td>' + 
		'</tr>');
	});
	
	ocultarTodo();
	$("#sectionContentMantenimientoProductos").show();
	$("#tablaTodosLosProductos").show();
}

function nuevoProducto(){
	$("#formProducto").show();
	$("#tablaTodosLosProductos").hide();
}

function enviarFormularioProducto(e){
	e.preventDefault();

	var vproducto = {
		id : parseInt($('#inputProductoId').val()),
		nombre : $('#inputProductoNombre').val(),
		descripcion:$("#inputProductoDescripcion").val(),
		precio: $("#inputProductoPrecio").val(),
		imagen: null
	};

	console.log(vproducto);
	var operacion = vproducto.id ? 'PUT' : 'POST';
	console.log("operacion: "+operacion);

	$.ajax({
		method : (vproducto.id ? 'PUT' : 'POST'), // id == 0 POST / id != 0 PUT
		url : '/api/productos', 
		data : JSON.stringify(vproducto),
		contentType: 'application/json'
	}).done(function() {
		//ocultarFormulario();
		$('#formProducto').trigger("reset");
		$("#inputProductoId").val("0");
		$("#formProducto").hide();
		obtenerTodosLosProductos();
	}).fail(function() {
		alert("error al crear / modificar producto");
	});
}

function modificarProducto(id){
	 $.getJSON('/api/productos/'+id, function(producto) {
		console.log("producto: " +producto);
		
		$('#inputProductoId').val(producto.id);
		$('#inputProductoNombre').val(producto.nombre);
		$("#inputProductoDescripcion").val(producto.descripcion);
		$("#inputProductoPrecio").val(producto.precio);
		
		$("#formProducto").show();
		$("#tablaTodosLosProductos").hide();
	});
}

function borrarProducto(id){
	if (confirm('¿Estás seguro desea borrar el producto ' + id)) {
		$.ajax({
			url : '/api/productos/' + id,
			method : 'DELETE',
		}).done(function() {
			console.log("Borrado de producto OK");
			obtenerTodosLosProductos();
		}).fail(function(){
			alert("ERROR AL BORRAR");
		});
	}
}

function obtenerProductosPorAlmacen(){
	 var idUbicacion = $("#localizacionDefault").val();
	 $.getJSON('/api/productos/almacen/'+idUbicacion, function(productos) {
		console.log("productos por almacen: "+productos);
		mostrarProductosPorAlmacen(productos);
	});
	 
	 $.getJSON('/api/almacenes/', function(almacenes) {
			$('#inputBuscarPorUbicacion').empty();
			$(almacenes).each(function() {
				if (this.id == idUbicacion){
					$('#inputBuscarPorUbicacion').append('<option value="'+this.id+'" selected>'+this.nombre+'</option>');
					$("#inputProductoCompletoAlmacen").append('<option value="'+this.id+'" selected>'+this.nombre+'</option>');
				}else{
					$('#inputBuscarPorUbicacion').append('<option value="'+this.id+'">'+this.nombre+'</option>');
					$("#inputProductoCompletoAlmacen").append('<option value="'+this.id+'">'+this.nombre+'</option>');
				}
			});
		});
}

function buscarProductosPorAlmacen(idUbicacion){
	 $.getJSON('/api/productos/almacen/'+idUbicacion, function(productos) {
			console.log("productos por almacen: "+productos);
			mostrarProductosPorAlmacen(productos);
		});
		 
		 $.getJSON('/api/almacenes/', function(almacenes) {
				$('#inputBuscarPorUbicacion').empty();
				$(almacenes).each(function() {
					if (this.id == idUbicacion){
						$('#inputBuscarPorUbicacion').append('<option value="'+this.id+'" selected>'+this.nombre+'</option>');
						$("#inputProductoCompletoAlmacen").append('<option value="'+this.id+'" selected>'+this.nombre+'</option>');
					}else{
						$('#inputBuscarPorUbicacion').append('<option value="'+this.id+'">'+this.nombre+'</option>');
						$("#inputProductoCompletoAlmacen").append('<option value="'+this.id+'">'+this.nombre+'</option>');
					}
				});
			});
}

function mostrarProductosPorAlmacen(productos){
	$("#tbodyProductosRemotos").empty();
	$(productos).each(function(producto){
		$("#tbodyProductosRemotos").append('<tr>' + 
				'<th>'+this.id+'</td>'+ 
			'<td>'+ this.nombre + '</td>'+ 
			'<td>'+ this.descripcion + '</td>'+ 
			'<td>'+ this.precio + '</td>'	+ 
			'<td>'+ this.imagen + '</td>'+ 
			'<td>'+ this.almacen.nombre + '</td>'+ 
			'<td>'+ this.stock.stock + '</td>'+ 
			'<td>'+ 
				'<a href="javascript:modificarProductoCompleto('+ this.id +')"><i class="far fa-edit fa-lg"></i></a> '+
				'<a href="javascript:borrarProductoCompleto('+ this.id +')"><i class="far fa-trash-alt fa-lg"></i></a>'+ 
			'</td>' + 
		'</tr>');
	});
	
	ocultarTodo();
	$("#tablaProductosRemotos").show();
	$("#sectionContentMantenimientoProductosRemotos").show();
	$("#capaBuscador").show();
}

function nuevoProductoCompleto(){
	$("#formProductoCompleto").show();
	$("#tablaProductosRemotos").hide();
	$("#capaBuscador").hide();
}

function enviarFormularioProductoCompleto(e){
	e.preventDefault();

	var vproducto = {
		id : parseInt($('#inputProductoCompletoId').val()),
		nombre : $('#inputProductoCompletoNombre').val(),
		descripcion:$("#inputProductoCompletoDescripcion").val(),
		precio: $("#inputProductoCompletoPrecio").val(),
		almacen:{
			id: $("#inputProductoCompletoAlmacen option:selected").val(),
			nombre:$("#inputProductoCompletoAlmacen option:selected").text()
		},
		stock:{
			id: $("#inputProductoCompletoStockId").val(),
			precio: $("#inputProductoCompletoStock").val()
		},
		imagen: null
	};

	console.log(vproducto);
	var operacion = vproducto.id ? 'PUT' : 'POST';
	console.log("operacion: "+operacion);

	$.ajax({
		method : (vproducto.id ? 'PUT' : 'POST'), // id == 0 POST / id != 0 PUT
		url : '/api/productos/completo', 
		data : JSON.stringify(vproducto),
		contentType: 'application/json'
	}).done(function() {
		//ocultarFormulario();
		$('#formProductoCompleto').trigger("reset");
		$("#inputProductoCompletoId").val("0");
		$("#formProductoCompleto").hide();
		obtenerTodosLosProductos();
	}).fail(function() {
		alert("error al crear / modificar producto");
	});
}

function modificarProductoCompleto(id){
	 $.getJSON('/api/productos/completo/'+id, function(producto) {
		console.log("producto: " +producto);
		
		$('#inputProductoCompletoId').val(producto.id);
		$('#inputProductoCompletoNombre').val(producto.nombre);
		$("#inputProductoCompletoDescripcion").val(producto.descripcion);
		$("#inputProductoCompletoPrecio").val(producto.precio);
		
		//cargar select almacen
		/*
		 * id: $("#inputProductoCompletoAlmacen option:selected").val(),
					nombre:$("#inputProductoCompletoAlmacen option:selected").text()
					*/
		//cargar stock id y stock
		/*
		 * id: $("#inputProductoCompletoStockId").val(),
					precio: $("#inputProductoCompletoStock").val()
		 * */
		
		$("#formProductoCompleto").show();
		$("#tablaProductosRemotos").hide();
		$("#capaBuscador").hide();
	});
}

function borrarProductoCompleto(id){
	if (confirm('¿Estás seguro desea borrar DEFINITIVAMENTE el producto ' + id)) {
		$.ajax({
			url : '/api/productos/completo' + id,
			method : 'DELETE',
		}).done(function() {
			console.log("Borrado de producto OK");
			obtenerProductosPorAlmacen();
		}).fail(function(){
			alert("ERROR AL BORRAR");
		});
	}
}