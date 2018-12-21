$(function() {
	
	lista();
	$('#flogin').submit(function (e){
		e.preventDefault();
		
		
		var usuario= {
				
				nombre : $('#nombre').val(),
				password : $('#password').val()
		}

		$.ajax({
			url : '/api/login',
			method : 'POST',
			data : JSON.stringify(usuario),
			contentType : 'application/json; charset=UTF-8'
		}).done(function() {
			location.href = "listadoproductos.html"
			
		});
	});
	
		
});