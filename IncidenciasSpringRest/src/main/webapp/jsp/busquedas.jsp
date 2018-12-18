		<div class="col-sm-3">
  
		  <form action="/buscarIncidencia">
				&nbsp;Buscar ID incidencia :  <br>
				&nbsp;<input name="id_buscar" type="number"  class="input-sm"> 
				<button class="btn btn-default">Buscar</button>
			</form>
		  
  		</div>
  		<div class="col-sm-3" >
		  <div class="row">
			  <form action="/buscarIncidenciaxEquipo">
					Buscar incidencia por equipo:  <br>
					<select name="equipo" id="equipo"  class="input-sm">
						 <c:forEach var = "equipo" items="${listaequipos}">
							 <option value="${equipo.nombre}">${equipo.nombre}</option>
				 		</c:forEach>
				 	</select>
					<button class="btn btn-default">Buscar</button>
				</form>
		  </div>
	  </div>
	   <div class="col-sm-3" >
		  <div class="row">
			  <form action="/buscarIncidenciaxUsuario">
					Buscar incidencia por usuario:  <br>
					<select name="usuario" id="usuario" class="input-sm">
						 <c:forEach var = "usuario" items="${listausuarios}">
							 <option value="${usuario.email}">${usuario.email}</option>
				 		</c:forEach>
				 	</select>
					<button class="btn btn-default">Buscar</button>
				</form>
		  </div>
		</div>
		 <div class="col-sm-3" >
		  <div class="row">
			  <form action="/buscarIncidenciaxEstado">
					Buscar incidencia por estado:  <br>
					<select name="estado" id="estado"  class="input-sm">
						 <c:forEach var = "estado" items="${listaestados}">
							 <option value="${estado.estado}">${estado.estado}</option>
				 		</c:forEach>
				 	</select>
					<button class="btn btn-default">Buscar</button>
				</form>
		  </div>
		 </div>
		  