$(function() {
	cargarProductos();
	
	$('form').submit(function(e) {
		e.preventDefault();
		
		var productoid = $('#id').val();
		var productonombre = $('#nombre').val();
		var productoimagen = $('#imagen').val();
		var productodescripcion = $('#descripcion').val();
		var productoprecio = $('#precio').val();

		var metodo = productoid == 0 ? 'POST' : 'PUT';
		
		$.ajax({
			url: '/api/productos',
			method: metodo,
			data: JSON.stringify({ id: productoid, nombre: productonombre, imagen: productoimagen, descripcion: productodescripcion, precio: productoprecio }),
			contentType: 'application/json; charset=UTF-8'
		}).success(function() {
			cargarEditoriales();
			$('#nombre').val('');
			$('#id').val(0);
			$('#imagen').val('');
			$('descripcion').val('');
			$('#precio').val('');
		});
	});
});

function cargarEditoriales() {
	$.getJSON('/api/productos', function(productos) {
		console.log(productos);
		
		mostrarProductos(productos);
	});
}

}