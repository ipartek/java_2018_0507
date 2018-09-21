window.onload = function () { //todos los objetos que tengo pueden tener eventos, los eventos son carcasas de metodos que van a ser llamados cuando ocurra algo que provoca un usuario. Solo se ejecuta cuando ha cargado entero. Le paso una funcion como argumento.

    var  form = document.getElementsByTagName("form")[0];
    
    form.onsubmit = function(e){
        'use strict';
        e.preventDefault(); //Parecido al return false, cancelar por defecto el error

        var hayErrores = false;
        
        var iNombre,iPassword,sError;
        var iNombre = document.getElementById('nombre');
        var iPassword = document.getElementById('password');
        
        if(iNombre.value.trim().length === 0) { //si al quitar los espacios, la longitud es 0, esque esta vacío          
            activarError(iNombre, 'Es obligatorio rellenar el nombre');
            hayErrores = true;
        }else {
            desactivarError(iNombre);
        }

        if(iPassword.value.trim().length === 0) { 
            activarError(iPassword, 'Es obligatorio rellenar la contraseña');
            hayErrores = true;

        }else {
            desactivarError(iPassword);
        }

       if(!hayErrores)  //solo se envia el formulario cuando es true, cuando no hay errores hayErrores = true;
             form.submit(); //no puede haber return con el  e.preventDefault()

    }; //cuando alguien le de al submit ejecuta este codigo.
   
};

function activarError(objeto, texto){
    if(!objeto.fallo){ //si no existe fallo,, lo marca en rojo, pero si ya hay fallo, ya no lo repite de nuevo
         objeto.className = 'errorCuadro'; //.style = 'border: 2px solid red';

            var sError = document.createElement('span'); //creo nuevo elemento de tipo span
            sError.className = 'errorTexto'; //.style = 'color: red';
            sError.innerHTML = texto; //'Es obligatorio rellenar el nombre'

            objeto.parentNode.appendChild(sError); //aparece un hijo en el padre de objeto?

            objeto.fallo = sError; 
    }
   
}

function desactivarError(objeto){
    if(objeto.fallo){ 
        objeto.className = ''; //.style = '';
        objeto.parentNode.removeChild(objeto.fallo);
        objeto.fallo = undefined;
    }
}
