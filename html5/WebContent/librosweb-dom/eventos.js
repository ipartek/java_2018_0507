window.onload = function () {
	function mostrarOcultar(id) {
		var elemento = document.getElementById('contenidos_' + id);
		var enlace = document.getElementByID('enlace_' + id);
		
		if (elemento.style.display == "" || elemento.style.display == "block") {
			elemento.style.display =  "none";
			enlace.innerHTML = 'Mostrar contenido';
		}else{
			elemento.style.display = "block";
			enlace.innerHTML = 'Ocultar contenido';
		}
	}
	
	/*
	 * var elemento = document.getElementById('contenidos_'+id); 
	 * var enlace = document.getElementById('enlace_'+id);
	 * 
	 * if(elemento.style.display == "" || elemento.style.display == "block") {
	 * elemento.style.display = "none"; 
	 * enlace.innerHTML = 'Mostrar contenidos'; }
	 * else { elemento.style.display = "block"; enlace.innerHTML = 'Ocultar
	 * contenidos'; }
	 * 
	 */
}