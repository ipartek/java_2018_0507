//El uso del dolar viene dado por el jquery
$(function(){
	$('button:contains(2), button:contains(3)').click(function(){
		alert(this.innerHTML);
	});
	$('p').each(function(){
		console.log(this.innerHTML);
	});
	$('form').submit(function(e){
		e.preventDefault();
		
		console.log($('input[name=nombre]').val());
		console.log($('input[name=nombre]')[0].value);
		console.log($('input[name=nombre]').attr('type'));
		console.log($('input[name=nombre]')[0].type);
	});
});