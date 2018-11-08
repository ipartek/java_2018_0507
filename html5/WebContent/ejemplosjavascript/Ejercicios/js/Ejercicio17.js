function limita(event,maximoCaracteres) {
	
	
	var evento = event || window.event;
	var codigoCaracter = event.charCode || event.keyCode;
	var elemento = document.getElementById("texto");
 
	if(elemento.value.length >= maximoCaracteres ) {
		  if(codigoCaracter==8){
			  maximoCaracteres=maximoCaracteres-1;
			  return true;
		  }else if (codigoCaracter==37){
			 // console.log("info: flechaizq");
		   return true;
	}else if(codigoCaracter==39){
		 // console.log("info: flechader");
			  return true;
		  }else{
			  return false;
		  }
	  } else {
		  actualizarInfomacion(maximoCaracteres);
	    return true;
	  }
	}

function actualizarInfomacion(maximoCaracteres) {

	  var elemento = document.getElementById("texto");
	  var info = document.getElementById("info");
	 
	/*  console.log("texto"+texto.value);
	  console.log("maximoCaracteres: "+maximoCaracteres);
	  console.log("elemento: "+elemento.value);
	  console.log("info: "+info);
	  */
	 
	  if(elemento.value.length >= maximoCaracteres ) {
	    info.innerHTML = "Máximo "+maximoCaracteres+" caracteres";
	  }else{
	    info.innerHTML = "Puedes escribir hasta "+(maximoCaracteres-elemento.value.length-1)+" caracteres adicionales";
	  }
	}


function muestraInformacion(mensaje) {
	document.getElementById("info").innerHTML = '<h1>'+mensaje[0]+'</h1>';
	for(var i=1; i<mensaje.length; i++) {
		document.getElementById("info").innerHTML += '<p>'+mensaje[i]+'</p>';
	}
}