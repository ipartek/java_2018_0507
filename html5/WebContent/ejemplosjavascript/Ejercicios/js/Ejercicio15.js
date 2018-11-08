/*
Al mover el ratón en cualquier punto de la ventana del navegador, se muestre la posición del puntero respecto del navegador y respecto de la página:
Información que se muestra para los eventos del ratón
Figura 6.1 Información que se muestra para los eventos del ratón

Para mostrar los mensajes, utilizar la función muestraInformacion() deduciendo su funcionamiento a partir de su código fuente.
Al pulsar cualquier tecla, el mensaje mostrado debe cambiar para indicar el nuevo evento y su información asociada:
Información que se muestra para los eventos del teclado



Figura 6.2 Información que se muestra para los eventos del teclado

Añadir la siguiente característica al script: cuando se pulsa un botón del ratón, el color de fondo del cuadro de 
mensaje debe ser amarillo (#FFFFCC) y OK

cuando se pulsa una tecla, el color de fondo debe ser azul (#CCE6FF). 


Al volver a mover el ratón, el color de fondo vuelve a ser blanco.
El color de fondo del cuadro de información cambia en función del tipo de evento
Figura 6.3 El color de fondo del cuadro de información cambia en función del tipo de evento*/


window.onload = function (){		
		//Que se haga on mousemove
		window.onmousemove=function(evento){ //Evento que se ha ejecutado
			//alert(evento.screenX); //Posicion donde e pinchado en la pantalla
			//alert(evento.screenY);
			
			var coordenadaX = evento.screenX;
			var coordenadaY = evento.screenY;
			var arraycoords=[coordenadaX,coordenadaY];
			
			muestraInformacion(arraycoords);
			document.getElementById("info").style.backgroundColor='#FFFFFF'
		}
		window.onkeyup=function(evento){
			document.getElementById("info").style.backgroundColor='#CCE6FF'
		}
		window.onclick=function(){
			document.getElementById("info").style.backgroundColor='#FFFFCC'
			
			
		}
		
		//AL PULSAR TECLA CAMBIAR COLOR
		/*window.keyup=function(){
			document.getElementById("info").style.backgroundColor='#CCE6FF'
			
		}*/
	
};	



function muestraInformacion(mensaje) {
	document.getElementById("info").innerHTML = '<h1>'+mensaje[0]+'</h1>';
	for(var i=1; i<mensaje.length; i++) {
		document.getElementById("info").innerHTML += '<p>'+mensaje[i]+'</p>';
	}
}

