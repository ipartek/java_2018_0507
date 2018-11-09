$(function(){
	$('button:contains(2),button:contains(3)').click(function(){
		alert(this.innerHTML);
	});
	
	
	//por cada p que exista en el html pinto en la consola
	$('p').each(function(){
		console.log(this.innerHTML);
	});
	
	
	
	$('form').submit(function(e){
		//Cancelar el submit
		e.preventDefault();
		
		//Sacar el value del input que se llama nombre con jquery
		console.log($('input[name=nombre]').val());
		console.log($('input[name=nombre]').attr('type'));
		console.log();
		console.log();
		//Sacar en javascript el primer value del input que se llama nombre
		console.log($('input[name=nombre]')[0].value);
		console.log($('input[name=nombre]')[0].type);
	})
});