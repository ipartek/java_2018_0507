window.onload = function() {
	var enlaces = document.getElementsByTagName('a');
	// Numero de enlaces de la pagina
	console.log(enlaces.length);
	// Direccion del penultimo enlace
	console.log(enlaces[(enlaces.length)-2])
	// Numero de enlaces que apuntan a http://prueba
    var contador = 0;
    for (i = 0; i<enlaces.length; i++){
       //if(enlaces[i].href.includes('http://prueba/')){
    	if(enlaces[i].href =='http://prueba/'){
        	contador++;
        }
    }
    console.log(contador);
	// Numero de enlaces del tercer párrafo
    var parrafos = document.getElementsByTagName('p');
    
   console.log(parrafos[2].getElementsByTagName('a').length);
}