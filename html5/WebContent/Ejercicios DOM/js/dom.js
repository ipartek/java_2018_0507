function NumeroEnlaces() {
	var enlaces = document.getElementsByTagName('a');

	console.log(enlaces.length);
}

function PenultimoEnlace() {
	var enlaces = document.getElementsByTagName('a');
	var penultimo = enlaces[enlaces.length - 2].href;

	console.log(penultimo);
}

function EmpiezanPor() {
	var enlaces = document.getElementsByTagName('a');
	var cont = 0;

	for (i = 0; i < enlaces.length; i++) {
		if (enlaces[i].href == 'http://prueba' || enlaces[i].href == 'http://prueba/') {
			cont++;
		}
	}
	console.log(cont);
}

function EnlacesParrafo(){
	
	var parrafos = document.getElementsByTagName('p');
	var enlaces = parrafos[2].getElementsByTagName('a');
	
	console.log(enlaces);


}