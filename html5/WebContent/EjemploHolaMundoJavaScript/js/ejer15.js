function muestraInformacion(mensaje) {

	var x = mensaje.clientX;
	var y = mensaje.clientY;
	var xp = mensaje.pageX;
	var yp = mensaje.pageY;
//	var tecla = mensaje.keyCode;
	var codigo = mensaje.charCode;
//	console.log(tecla);
	console.log(codigo);
	var mensaje2 = null;
		
	var mensaje = '<h1> Raton </h1> </br>' + "Navegador  [" + x + '],[' + y
			+ ']</br> Pagina ' + '[' + xp + ']' + ', [' + yp + ']';
	
	mensaje2= '<h1> Teclado </h1> </br> Caracter []</br> Codigo [' + codigo +']';

	
		document.getElementById("info").innerHTML = mensaje;	
	
	
	//document.getElementById("1").innerHTML = mensaje2;
}

/*
 * window.onload = function(){ document.onmousemove = muestraInformacion(); }
 */

function myFunction() {
	console.log('me muevo');
}
