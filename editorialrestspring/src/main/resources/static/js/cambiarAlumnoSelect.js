
$(function() {
	$("#alumno").change(function(event) {
		$.ajax({
			type : "get",
			url : "cambiarAlumno",
			data : "alumno=" + $("#alumno").val(),
			success : function(response) {
				$("#alumno_card_body").empty();
				$("#alumno_card_body").html(response);
			},
			dataType : 'text'
		});
	});
});
