function limita(e ,maximoCaracteres) {
  var elemento = document.getElementById("texto");
  var restantes = 100;
  
  if(elemento.value.length >= maximoCaracteres ) {
	  if(kd(e)){
		console.log("Entro en el kd = true");
		  return true;
	  }else{
		  console.log("No entro en el kd = true")
		  return false;	
	  }
	  return false;
  }else {
	  restantes = (maximoCaracteres -1) - elemento.value.length;
	  document.getElementById("mensaje").innerHTML = 'Quedan '+ restantes + ' letras';	
    return true;
  }
}

function kd(event) {
    var key = event.keyCode || event.charCode;
    console.log(key);
    if( key == 8 || key == 46 || key  == 37 || key == 38 || key == 39 || key == 40){
    	return true;
    }
};