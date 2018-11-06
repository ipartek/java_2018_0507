function cambiarTitulo() {
	var h1 = document.getElementsByTagName('h1')[0];

	h1.innerText = 'Título cambiado desde JavaScript';
}

function modificarParrafos() {
	var parrafos = document.getElementsByTagName('p');
	
	for(var i = 0; i < parrafos.length; i++) {
		parrafos[i].innerText = 'Párrafo modificado ' + i;
	}
	
	/*
	var indice = 1;
	for(var parrafo of parrafos) {
		parrafo.innerText = 'Párrafo MUY modificado ' + indice++;
	}
	*/
}

function leerFormulario() {
	var input = document.getElementsByName('nombre')[0];
	var nombre = input.value;
	
	//input.style = 'border: 1px solid red';
	if(input.className.indexOf('error') == -1){ //-1 significa que NO ha encontrado el texto 'error'
		input.className = input.className + ' error';
	}
	
	alert(nombre);
	
	return false; //Cancelar el envío del formulario al action
}

function accederPorId() {
	var importante = document.getElementById('elmasimportante');
	
	alert(importante.innerText);
}

function destacar() {
	var destacados = document.getElementsByClassName('destacado');
	
	/*
	for(let destacado of destacados) {
		destacado.innerText = '****' + destacado.innerText + '****';
	}
	*/
	
	for(var i = 0; i < destacados.length; i++) {
		destacados[i].innerText = '****' + destacados[i].innerText + '****';
	}
}

function rellenarTabla() {
	var tr = document.createElement('tr');
	
	tr.innerHTML = '<th>1</th><td>Javier</td>';
	
	var tbody = document.getElementsByTagName('tbody')[0];
	
	tbody.appendChild(tr);
	
	console.log(tr);
}

function borrarImportante() {
	var importante = document.getElementById('elmasimportante');
	
	importante.parentNode.removeChild(importante);
	
	//importante.remove();
}
