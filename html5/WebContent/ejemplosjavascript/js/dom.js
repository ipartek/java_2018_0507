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

function leerFormulario() {
	var nombre = document.getElementsByName('nombre')[0].value;
	
	alert(nombre);
	
	return false; //Cancelar el envío del formulario al action
}

function accederPorId() {
	var importante = document.getElementById('elmasimportante');
	
	alert(importante.innerText);
}

function destacar() {
	var destacados = document.getElementsByClassName('destacado');
	
	for(let destacado of destacados) {
		destacado.innerText = '****' + destacado.innerText + '****';
	}
}