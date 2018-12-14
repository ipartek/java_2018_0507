$(function() {
    mostrar('Aquí saldrán los datos');

    $('#btnusuario').click(function () {
        $.getJSON('api/foos')
            .done(mostrar)
            .fail(error);
    });

    $('#btnadmin').click(function () {
        $.getJSON('api/admin/x')
            .done(mostrar)
            .fail(error);
    });

    $('form').submit(function(e) {
        e.preventDefault();
        
        $.post('login', { username: $('#username').val(), password: $('#password').val() }, mostrar)
            .fail(error);
    });
});

function mostrar(datos) {
    $('#datos').text(JSON.stringify(datos));
}

function error(objError, mensaje, error){
    mostrar('ERROR: ' + objError.status + ', ' + objError.responseText + ', ' + mensaje + ', ' + JSON.stringify(error));
}
