<div class="col-md-6" id="contenedorcentral">



<div class="container">
  <h2>Libros disponibles</h2>
  <p>Clasificados</p>
 <table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>ID</th>
			<th>Título</th>
			<th>Editorial</th>
			<th>Precio</th>
			<td></td>
		</tr>
	</thead>
	<tbody>
		
		<% for(int i = 3; i <= 10; i++) { %>
		<tr>
			<th><%=i%></th>
			<td>Título<%=i%></td>
			<td>Editorial<%=i%></td>
			<td><%=i*10%>€</td>
			<td><a class="btn btn-default" href="edicion.jsp">Editar</a> <a
				class="btn btn-danger" href="edicion.jsp">Borrar</a></td>
		</tr>
		<% } %>
	</tbody>
	<tfoot>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td>18,1€</td>
			<td><a class="btn btn-primary" href="edicion.jsp">Añadir</a></td>
		</tr>
	</tfoot>
</table>
</div>

</div>

