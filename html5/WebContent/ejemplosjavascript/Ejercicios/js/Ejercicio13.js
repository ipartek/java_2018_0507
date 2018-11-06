
/*Completar el código JavaScript proporcionado para que se añadan nuevos elementos a la lista cada vez que se 
pulsa sobre el botón. Utilizar las funciones DOM para crear nuevos nodos y añadirlos a la lista existente. 
Al igual que sucede en el ejercicio anterior, la acción de pinchar sobre un botón forma parte de los "Eventos" 
de JavaScript que se ven en el siguiente capítulo. En este ejercicio, sólo se debe saber que al pinchar sobre 
el botón, se ejecuta la función llamada anade().*/

function anade() {
		
	var puntolista = document.createElement("li");
	var texto = document.createTextNode("Elemento de prueba");
	puntolista.appendChild(texto);
	 
	var lista = document.getElementById("lista");
	lista.appendChild(puntolista);
	
}