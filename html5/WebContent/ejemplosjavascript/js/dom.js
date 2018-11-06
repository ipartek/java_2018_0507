function cambiarTitulo() {
	var h1 = document.getElementsByTagName('h1')[0];

	h1.innerText = 'Título cambiado desde JavaScript';
}

function modificarParrafos() {
	var parrafos = document.getElementsByTagName('p');
	
	for(var i = 0; i < parrafos.length; i++) {
		parrafos[i].innerText = 'Párrafo modificado ' + i;
	}
	
	var indice = 1;
	for(var parrafo of parrafos) {
		parrafo.innerText = 'Párrafo MUY modificado ' + indice++;
	}
}