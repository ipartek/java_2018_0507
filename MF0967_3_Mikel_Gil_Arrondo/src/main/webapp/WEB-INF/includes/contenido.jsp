<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	<div class="row">
		<div class="col-md-12">
	  		<c:if test="${mensaje!=null}">
				<div class="alert alert-info alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					${mensaje}
				</div>
			</c:if>
			<div class="table-responsive"> 
				<table class="table table-striped table-hover">
					<thead>
						<tr class="success">
							<th>ID</th>
							<th>NOMBRE</th>
							<th>EDAD</th>
							<th>RAZA</th>
							<th>PESO</th>
							<th>APADRINADO</th>
							<th>CHIP</th>
							<th>LONGITUD</th>
							<th>LATITUD</th>
							<th>
								<c:if test="${!empty sessionScope}">
									<a class="btn btn-sm btn-primary" href="perros?accion=insertar">Crear nuevo</a>
								</c:if>
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${perros}" var="perro">
							<tr>
								<td class="text-md-left">${perro.id}</td>
								<td>${perro.nombre}</td>
								<td>${perro.edad}</td>
								<td>${perro.raza}</td>
								<td>${perro.peso}</td>
								<td>${perro.apadrinado}</td>
								<td>${chip.chip}</td>
								<td>${chip.latitud}</td>
								<td>${chip.longitud}</td>
								<td>
									<a class="btn btn-sm btn-info" href="perros?accion=editar&id=${perro.id}">Editar</a>
									<a class="btn btn-sm btn-danger" href="perros?accion=borrar&id=${perro.id}">Borrar</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
  	</div>