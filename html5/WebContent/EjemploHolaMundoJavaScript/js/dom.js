function cambiarTitulo(){
	var h1 = document.getElementsByTagName('h1')[0];
	
	h1.innerText = 'Titulo cambiado desde JavaScript';
	}

function modificarParrafos(){
	var parrafos = document.getElementsByTagName('p');
	var indice = 0;
	for(var i = 0; i < parrafos.length; i++){
		parrafos[i].innerText = 'Parrafo modificado ' + i;
	}
	for (var parrafo of parrafos){
		parrafo.innerText = 'Parrafo Muy Modificado ' + indice++;
	}
	
}
function leerFormulario(){
	var input = document.getElementsByName('nombre')[0];
	var nombre = input.value;
	
//	input.style = 'border: 1px solid red';
	if(input.className.indexOf('error') == -1){
	input.className = input.className + ' error';
	}
	alert(nombre);
	return false;
}

function accederPorId(){
	var importante = document.getElementById('elmasimportante');
	
	alert(importante.innerText)
}
function destacar(){
	var destacados = document.getElementsByClassName('destacado');
	
	for(let destacado of destacados){
		destacado.innerText = '*****' +destacado.innerText + '*****';
	}
}
function rellenarTabla(){
	var tr = document.createElement('tr');
	tr.innerHTML = '<th>1</th><td>Javier</td>';
	var tbody = document.getElementsByTagName('tbody')[0];
		tbody.appendChild(tr);
	console.log(tr);
}
function eliminarParrafo(){
	var importante = document.getElementById('elmasimportante');
	
	//importante.parentNode.removeChild(importante);
	
	importante.remove();
}