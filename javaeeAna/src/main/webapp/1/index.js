
/* eslint-env browser:true, global window, global alert  */



window.onload = function () {
    'use strict';
    
  // var boton = document.getElementsByTagName("button")[0];
    var form = document.getElementsByTagName("form")[0];
    
    //console.log(form);
    
    form.onsubmit = function (e) {
        e.preventDefault(); //Hace que no se vaya a otra pantalla
        
        var hayErrores = false;
        
       
        //alert('hola');
        
        var iNombre, iPassword;
        var iNombre = document.getElementById('nombre');
        var iPassword = document.getElementById('password');
        //console.log(iNombre);
        
      /*  if (iNombre.value.trim().length!=0){ //trim quita los espacios
            iNombre.style = 'border:2px solid red';
        }
        if(iPassword.value.trim().length!=0){
            iPassword.style='border:2px solid red';
        }*/
        
        
         if(iNombre.value.trim().length==0 ){ //trim quita los espacios
            activarError(iNombre,'Es obligatorio rellenar el nombre') ;   
            hayErrores=true;
        }else{
            desactivarError(iNombre);
        }
        
        if(iPassword.value.trim().length==0){
           // iPassword.style='border:2px solid red';
            activarError(iPassword,'Es obligatorio la contraseña');
            hayErrores=true;
        }else{
            //iPassword.style='';
            desactivarError(iPassword);
        }       
        
        if(!hayErrores) form.submit() ;
    };
};

function activarError(objeto,texto){
    if (!objeto.fallo){
        objeto.className='errorCuadro';     //.style='border:2px solid red';

         var sError = document.createElement('span');
         sError.className='errorTexto';     //.style='color : red';
         sError.innerHTML=texto;

         objeto.parentNode.appendChild(sError);
         objeto.fallo = sError;  
    }
}

function desactivarError(objeto) {
    if (objeto.fallo){
        objeto.className='';//.style='';
        objeto.parentNode.removeChild(objeto.fallo);
        objeto.fallo= undefined;
    }
}