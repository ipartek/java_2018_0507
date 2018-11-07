window.onload = function () {
	var botones = document.getElementById('botonera').getElementsByTagName('button'); //.childNodes
	
	for(let i = 0; i < botones.length; i++) {
		botones[i].onclick = function () {
			alert(this.innerHTML);
		};
	}
};
