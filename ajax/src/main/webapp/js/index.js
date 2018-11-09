$(function() {
	var jqxhr = $.ajax("libros").done(function(libros) {
		console.log("success");
		
		$(libros).each(function() {
			$('<tr><th>' + this.id + '</th><td>' + this.nombre + '</td></tr>').appendTo($('#tablalibros > tbody'));
		});
		
	}).fail(function() {
		alert("error");
	}).always(function() {
		console.log("complete");
	});
});
