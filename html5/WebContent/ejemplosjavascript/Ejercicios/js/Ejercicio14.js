
/*A partir de la página web proporcionada, completar el código JavaScript para que:

Cuando se pinche sobre el primer enlace, se oculte su sección relacionada
Cuando se vuelva a pinchar sobre el mismo enlace, se muestre otra vez esa sección de contenidos
Completar el resto de enlaces de la página para que su comportamiento sea idéntico al del primer enlace
Cuando una sección se oculte, debe cambiar el mensaje del enlace asociado (pista: propiedad innerHTML)*/
function muestra_oculta(pinchado) {
	
	//alert("pinchado"+pinchado);
	
	var parrafos=document.getElementsByTagName('p');	
	switch(pinchado) {
	    case 'contenidos_1': 
	    	if(document.getElementById(pinchado).style.display != 'none'){
	    		document.getElementById('contenidos_1').style.display='none'
	    	}else{
	    		document.getElementById('contenidos_1').style.display='block';
	    	}
	        break;
	    case 'contenidos_2':
	    	if(document.getElementById(pinchado).style.display != 'none'){
	    		document.getElementById('contenidos_2').style.display='none'
	    	}else{
	    		document.getElementById('contenidos_2').style.display='block';
	    	}
	        break;
	    case 'contenidos_3':
	    	if(document.getElementById(pinchado).style.display != 'none'){
	    		document.getElementById('contenidos_3').style.display='none'
	    	}else{
	    		document.getElementById('contenidos_3').style.display='block';
	    	}
	        break;
	    default:
	}
}