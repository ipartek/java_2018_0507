function anade() {
	/*var li = document.createElement('li');
	li.innerHTML = '<li>Gato</li>';
	var tlista = document.getElementById('lista')[0];
		tlista.appendChild(li);*/
	var li = document.createElement('li');
	li.innerHTML = '<li>Gato</li>';
	var lista = document.getElementById('lista');
	
	lista.appendChild(li);
	
	console.log("lista");
	
	
}