window.onload = function () {
    'use-strict';

    var form = document.getElementsByTagName("form")[0];
    
    form.onsubmit = function (e) {
        e.preventDefault();

        var hayErrores = false;

        var iNombre, iPassword;
        iNombre = document.getElementById('nombre');
        iPassword = document.getElementById('password');

        console.log(iNombre, iPassword);

        if (iNombre.value.trim().length === 0){
            activarError(iNombre, "Es obligatorio rellenar el nombre");
            hayErrores = true;
        }else{
           desactivarError(iNombre);
        }
        if (iPassword.value.trim().length === 0){
            activarError(iPassword, "Es obligatorio rellenar el password");
            hayErrores = true;
        }else{
            desactivarError(iPassword);
        }
    
        if(!hayErrores){
            form.submit();
        } 
   };
};

function activarError(objeto, texto){
    if (!objeto.fallo){
        objeto.className = 'errorCuadro';

        var sError = document.createElement('span');
        sError.className = 'errorTexto';
        sError.innerHTML = texto;
    
        objeto.parentNode.appendChild(sError);
    
        objeto.fallo = sError;
    }
}

function desactivarError(objeto){
    if (objeto.fallo){
        objeto.className = '';
        objeto.parentElement.removeChild(objeto.fallo);
        objeto.fallo = undefined;
    }
}
