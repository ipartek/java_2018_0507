
//Numero de enlaces de la pagina
function contarEnlaces(){	
	var links=document.getElementsByTagName('a');
	var numeroenlaces=0;
	
	for(var i=0;i<links.length;i++){
		numeroenlaces++;
	}
	console.log("Numero de enlaces en la pagina: "+numeroenlaces);
}

// Direccion del penultimo enlace
function penultimoEnlace(){
	var nlinks=document.getElementsByTagName("a").length;
	console.log("Ultimo enlace: " + document.getElementsByTagName("a")[nlinks-1].href);
}

function numenlacesaprueba(){
	
// Numero de enlaces que apuntan a http://prueba
	var contador = 0;
	for(var i=0; i<document.getElementsByTagName("a").length; i++) {
		if(document.getElementsByTagName("a")[i].href == "http://prueba/") {
	    contador++;
	   
		}
	}
	console.log("Numero Enlaces a http://prueba/ "+contador);
}
// Numero de enlaces del tercer parrafo
function numenlacesen3parrafo(){
		
	var parrafos=document.getElementsByTagName('p');
	
	var numeroenlaces=0;

	for(var i=0;i<parrafos[2].getElementsByTagName("a").length;i++){
		numeroenlaces++;
	}
	console.log("Numero de enlaces en el tercer parrafo: "+numeroenlaces);
}
