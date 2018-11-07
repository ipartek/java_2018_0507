
/* window.onload= function (){
 //Los botones dentro de la botonera
	
	var botones=document.getElementById('botonera').getElementsByTagName('button');//.childNodes
	
	for(let i=0;i<botones.length;i++){
	
		botones[i].onclick=function(){
			console.log(this);//this-> El propio elemento que se ha pulsado
			alert(this.innerHTML);
		};
	}
*/	
	
/*	//Todos Los botones
	var botones=document.getElementsByTagName('button');
	for(let i=0;i<botones.length;i++){
	botones[i].onclick=function(){
		console.log(this);
	};
	}


*/
	window.onload = function (){
		
		
		
		
		//Cancelar accion por defecto del enlace
		var enlace=document.getElementById('enlace');
		
		var borrar=document.forms[0].getElementsByTagName('button')[0]//Cojo el boton primer del primer formulario
		
		borrar.onclick=function(){
			return confirm('Estas seguro?');
		};
		
		
		
		
		enlace.onclick=function(evento){ //Evento que se ha ejecutado
			//alert( evento.screenX); //Posicion donde e pinchado en la pantalla
			evento.preventDefault(); /*Cancelar el evento por defecto asi no nos borra la consola si 
										hay un error, tampoco se ejecuta la accion por defecto, en este 
										caso el href del a*/
			alert('No vayas a google');
			//return false;
		};
	
	//Crear un numero determinado de botones
		var botonera=document.getElementById('botonera');
		
		while(botonera.firstChild){
			botonera.removeChild(botonera.firstChild);
		}
		for(let i=0;i<=9;i++){
			var boton=document.createElement('button');
			boton.innerHTML=i;
			boton.onclick=function(){
				alert(this.innerHTML);
			};
			botonera.appendChild(boton);
		}
};
