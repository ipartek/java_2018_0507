$(function(){
	$.getJSON('/api/editoriales',function(editoriales){
		console.log(editoriales;)
		$(editoriales).each(function()){
			$('tbody').append('<tr><th>'+this.id+"</th><td>"+this.nombre+"</td>");
		}
	});
)};