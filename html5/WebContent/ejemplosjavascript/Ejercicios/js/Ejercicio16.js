/*
 * Crear un script que informe al usuario en que zona de la pantalla ha pulsado el ratón. Las zonas 
 * definidas son las siguientes: izquierda arriba, izquierda abajo, derecha arriba y derecha abajo. 
 * Para determinar el tamaño de la ventana del 
 * navegador, utilizar la función tamanoVentanaNavegador() proporcionada.
 */
function informacion(elEvento) {
	var evento = elEvento || window.event;
	
	var coordenadaX = elEvento.screenX;
	var coordenadaY = elEvento.screenY;
	var arraycoords=[coordenadaX,coordenadaY];
	
	muestraInformacion(arraycoords);	
	elegirPosicion(coordenadaX,coordenadaY);

}

function elegirPosicion(x,y) {
	var dimensiones=tamanoVentanaNavegador();
	
	var poshoriz="";
	var posvert="";
	if(x>dimensiones[0]/2){
		poshoriz="derecha";
	}else{
		poshoriz="izquierda";
	}
	
	if(y<dimensiones[1]/2){
		posvert="arriba";
	}else{
		posvert="abajo";
	}
	var mensaje = [poshoriz, posvert];
	muestraInformacion(mensaje);
}

function muestraInformacion(mensaje) {
	document.getElementById("info").innerHTML = '<h1>'+mensaje[0]+'</h1>';
	for(var i=1; i<mensaje.length; i++) {
		document.getElementById("info").innerHTML += '<p>'+mensaje[i]+'</p>';
	}
}

function tamanoVentanaNavegador(){
	// Adaptada de http://www.howtocreate.co.uk/tutorials/javascript/browserwindow
	var dimensiones = [];
	
	if(typeof(window.innerWidth) == 'number') {
		// No es IE
		dimensiones = [window.innerWidth, window.innerHeight];
	} else if(document.documentElement && (document.documentElement.clientWidth || document.documentElement.clientHeight)) {
		//IE 6 en modo estandar (no quirks)
		dimensiones = [document.documentElement.clientWidth, document.documentElement.clientHeight];
	} else if(document.body && (document.body.clientWidth || document.body.clientHeight)) {
		//IE en modo quirks
		dimensiones = [document.body.clientWidth, document.body.clientHeight];
	}

	return dimensiones;
}

document.onclick = informacion;
