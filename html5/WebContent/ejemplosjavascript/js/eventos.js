window.onload = function () {
	var borrar = document.forms[0].getElementsByTagName('button')[0];
	
	borrar.onclick = function() {
		return confirm('¿Estás segurísimo de que quieres borrar?');
	};
	
	var enlace = document.getElementById('enlace');
	
	enlace.onclick = function (evento) {
		evento.preventDefault();
		
		alert('No vayas a Google!!!!, SON UN MONOPOLIO!!!!!!!!! VAMOS A MORIRRRRRRRR!!!!!');
		
		//return false;
	};
	
	var botonera = document.getElementById('botonera');
	
	while (botonera.firstChild) {
		botonera.removeChild(botonera.firstChild);
	}
	
	for(let i = 0; i <= 9; i++) {
		var boton = document.createElement('button');
		
		boton.innerHTML = i;
		
		boton.onclick = function () {
			alert(this.innerHTML);
		};
		
		botonera.appendChild(boton);
	}
};
/*
window.onload = function () {
	var botones = document.getElementById('botonera').getElementsByTagName('button'); //.childNodes
	
	for(let i = 0; i < botones.length; i++) {
		botones[i].onclick = function () {
			alert(this.innerHTML);
		};
	}
};
*/