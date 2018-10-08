<%@ include file="WEB-INF/includes/cabecera.jsp" %>
 <a href="#top" class="miTopp btn-danger">top</a>
<div class="row">
<div class="col-md-12">
 <table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>nombre</th>
			<th>raza</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${perrosCoin}" var="item">
		<tr>
				<th>"${item.id}"</th>
				<td>"${item.nombre}"</td>
				<td>"${item.raza}"</td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>
  </div>
        <a href="#top" class="miTopp btn-danger">top</a>
    </div>
<%@ include file="WEB-INF/includes/pie.jsp" %>
