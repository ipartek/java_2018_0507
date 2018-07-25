 /*jslint browser:true,global window,global*/
window.onload = function () {   
    'use strict';
  var form=document.getElementsByTagName("form")[0];
    console.log(form);
  form.onsubmit=function(e){
      e.preventDefault();
	  var hayErrores=false;
        var txtNombre=document.getElementById('nombre');
      var txtPassword=document.getElementById('password');    
	  console.log(txtNombre);
      if(txtNombre.value.trim().length==0 ){
			  activarError(txtNombre,'es obligatorio el nombre');
			  hayErrores=true;
        	}else{               
           desactivarError(txtNombre);
               }
        if(txtPassword.value.trim().length==0){
         // txtPassword.style='border: 2px solid red';
			activarError(txtPassword,'password obliga');
			hayErrores=true;
          }else {desactivarError(txtPassword);}
      
     if(!hayErrores) form.submit();
   };
};
function activarError(objeto,texto){
	if(!objeto.fallo ){
	  		objeto.className='errorCuadro';//style='border: 2px solid red';
			var sError=document.createElement('span');
          sError.className='errorTexto';//style='color:red';
          sError.innerHTML=texto;
          objeto.parentNode.appendChild(sError);
          objeto.fallo=sError;}
}
function desactivarError(objeto)
{
		if(objeto.fallo){
            objeto.style='';	
           objeto.parentNode.removeChild(objeto.fallo);
        objeto.fallo=undefined;
       
        }

}