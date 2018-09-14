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
		$("#div_contenido").load("listadoProductos.jsp");
	});
	$("#btnListadoCliente").on("click", function(){
		$("#div_contenido").empty();
		$("#div_contenido").load("productos.jsp");
	});
	$("#btnNuevo").on("click", function(){
		$("#div_contenido").empty();
		$("#div_contenido").load("nuevoProducto.jsp");
	});
	
	
	//When the user scrolls down 20px from the top of the document, show the button
	window.onscroll = function() {scrollFunction()};

	function scrollFunction() {
		 if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
		     document.getElementById("btnArriba").style.display = "block";
		 } else {
		     document.getElementById("btnArriba").style.display = "none";
		 }
	}

	//When the user clicks on the button, scroll to the top of the document
	$("#btnArriba").on("click", function(){
	    document.body.scrollTop = 0;
	    document.documentElement.scrollTop = 0;
	});
});

