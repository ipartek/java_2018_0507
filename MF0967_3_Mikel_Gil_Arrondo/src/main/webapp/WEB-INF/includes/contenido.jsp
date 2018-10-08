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
				<form class="form-inline" action="buscador?type=nombre" method="post">
					  <div class="form-group">
					    <label for="buscarNombre">Buscar por nombre</label>
					    <input type="text" class="form-control" id="buscarNombre" name="buscarNombre" placeholder="Nombre perro">
					  </div>
					  <button type="submit" class="btn btn-default">Buscar</button>
				</form><br />
				<form class="form-inline" action="buscador?type=chip" method="post">
					  <div class="form-group">
					    <label for="buscarChip">Buscar por nº chip</label>
					    <input type="text" class="form-control" id="buscarChip" name="buscarChip" placeholder="DD-DDDD-AAAA">
					  </div>
					  <button type="submit" class="btn btn-default">Buscar</button>
				</form>
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
								<td>
									<c:choose>
										<c:when test ="${perro.apadrinado == 0}">
											NO apadrinado
										</c:when>
										<c:when test ="${perro.apadrinado == 1 }">
											Apadrinado
										</c:when>
									</c:choose>
								</td>
								<td>${perro.chip.chip}</td>
								<td>${perro.chip.latitud}</td>
								<td>${perro.chip.longitud}</td>
								<td>
									<c:if test="${!empty sessionScope}">
										<a class="btn btn-sm btn-info" href="perros?accion=editar&id=${perro.id}">Editar</a>
										<a class="btn btn-sm btn-danger" href="perros?accion=borrar&id=${perro.id}">Borrar</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
  	</div>