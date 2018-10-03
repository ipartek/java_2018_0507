<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
 <%@ include file="/WEB-INF/includes/cabecera.jsp"%>
 
 <div class="row">

 	<div class="col-md-8 col-md-offset-2">
		<div class="well">
			<header>
				<h1>Escribe tu nueva página</h1>
			</header>
 			<form action="edicion" method="post" class="form-horizontal">
				 <div class="form-group">
					<label for="autor" class="col-sm-offset-1 col-sm-2 control-label">Autor</label><br />
					<div class="col-sm-7">
						<input type="text" class="form-control" id="autor" name="autor"
							placeholder="Autor" value="${user.nombre}" readonly />
					</div>
				</div> 
				<div class="form-group">
					<label for="texto" class="col-sm-offset-1 col-sm-2 control-label">Texto</label><br />
					<div class="col-sm-7">
						<textarea class="form-control" id="texto" name="texto"
							placeholder="texto" rows="4" cols="20">
					</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-8">
						<button  class="btn btn-primary">Añadir</button>				
						<button class="btn btn-danger">
							<a href="index.jsp" alt="cancelar" class="white">Cancelar</a>
						</button>
						<span class="error">${errores}</span>
					</div>
				</div>
			</form>
		</div>
	</div>
	
 <%@ include file="/WEB-INF/includes/pie.jsp"%>
