function cambiarTitulo(){
	var h1=document.getElementsByTagName('h1')[0];
	h1.innerText='Titulo cambiado desde javascript';
}

function modificarParrafos(){
	var parrafos=document.getElementsByTagName('p');
	
	for(var i=0;i<parrafos.length;i++){
		parrafos[i].innerText="Parrafo cambiado"+i;
	}
	
	
	var indice=1;
	for(var parrafo of parrafos){
		parrafo.innerText="Parrafo MUY modificado" + indice++;
	}
}

//Acceder por nombre de etiqueta
function leerFormulario(){
	var input=document.getElementsByName('nombre')[0];
	var nombre=input.value;
	
	
	//Acceder a los atributos de los elementos
	
	//Si no existe el texto error
	if(input.className.indexOf('error')==-1){
		input.className=input.className + ' error';
	}
	
	//
	
	
	alert(nombre);
	//console.log("Contenido del input: " + nombre);
	return false;//Cancelar el envio del fromulario para ver en el log el nombre
}

//Acceder por id
function accederPorId(){
	var importante=document.getElementById('elmasimportante');
	alert(importante.innerText);
}

//Acceder por nombre de clase
function destacar(){
	var destacados=document.getElementsByClassName('destacado');
	for (let destacado of destacados){
		destacado.innerText='******'+destacado.innerText+'******';
	}
}
//Añadir elementos a una etiqueta
function rellenarTabla(){
	//Crear el elemento
	var tr=document.createElement('tr');
	tr.innerHTML='<th>1<th><td>Javier</td>';
	
	//Añadir el elemento a la etiqueta
	var tbody=document.getElementsByTagName('tbody')[0];
	tbody.appendChild(tr);
	
	console.log(tr);
}

//Borrar elemento
function borrarParrafo(){
	var parrafoaborrar=document.getElementById('parrafoaborrar');
	parrafoaborrar.parentNode.removeChild(parrafoaborrar);
}


















