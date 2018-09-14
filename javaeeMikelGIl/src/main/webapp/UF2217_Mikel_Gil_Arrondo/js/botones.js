/**
 * 
 */

$(document).ready(function(){
	/*$("#btnEditar").on("click", function(){
	    $("#div_contenido").empty();
	    $("#div_contenido").load("editar.jsp");
	});
    $("#btnVerLibros").on("click", function(){
    	$("#div_contenido").empty();
    	$("#div_contenido").load("librosBonito.jsp");
    });*/
	
	$("#btnListadoCliente").on("click", function(){
		$("#div_contenido").empty();
		$("#div_contenido").load("productos.jsp");
	});
	$("#btnLogIn").on("click", function(){
		$("#div_contenido").empty();
		$("#div_contenido").load("login.jsp");
	});
	$("#btnListadoAdmin").on("click", function(){
		$("#div_contenido").empty();
		$("#div_contenido").load("productos.jsp");
	});
	$("#btnListadoCliente").on("click", function(){
		$("#div_contenido").empty();
		$("#div_contenido").load("productos.jsp");
	});
	$("#btnNuevo").on("click", function(){
		$("#div_contenido").empty();
		$("#div_contenido").load("nuevoProducto.jsp");
	});
});