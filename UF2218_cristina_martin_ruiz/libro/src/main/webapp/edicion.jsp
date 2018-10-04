<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
 <%@ include file="/WEB-INF/includes/cabecera.jsp"%>
 
 <div class="row">

	<section class="box justify-content-center col-md-5 col-sm-7 col-xs-12">
	
	<h1 class="text-center">Escribe tu nueva página</h1>

 			<form action="edicion" method="post" class="form-horizontal">
				 <div class="form-group">
					<label for="autor" class="control-label">Autor</label><br />
					
						<input type="text" class="form-control" id="autor" name="autor"
							placeholder="Autor" value="${user.nombre}" readonly />
					
				</div> 
				<div class="form-group">
					<label for="texto" class="control-label">Texto</label><br />
<textarea class="form-control" id="texto" name="texto" placeholder="texto" rows="4" cols="20"></textarea>				
				</div>
				<div class="form-group">
					
						<button  class="btn btn-primary">Añadir</button>				
						<a href="index" class="btn btn-danger">Cancelar</a>
						<span class="error">${errores}</span>
					
				</div>
			</form>
		
		</section>
	</div>
	
	</br>
	</br>
	
 <%@ include file="/WEB-INF/includes/pie.jsp"%>
