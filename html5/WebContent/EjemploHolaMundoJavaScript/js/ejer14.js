window.onload = function () {
		var enlaces = document.getElementsByTagName('a'); 
		var parrafos = document.getElementsByTagName('p');
		
		for(let i = 0; i < enlaces.length; i++) {
			enlaces[i].onclick = function () {
				if(enlaces[i]){
					var stilito = document.getElementsByTagName('p')[i].style.display;
					if (stilito == 'none') {
						parrafos[i].style.display = 'block';
						enlaces[i].innerHTML = 'Ocultar';
						return false;
					} else {
						parrafos[i].style.display = 'none';
						enlaces[i].innerHTML = 'Mostrar';
						return false;
					}
				}
					
			};
		}
	};
function muestraOculta() {}

