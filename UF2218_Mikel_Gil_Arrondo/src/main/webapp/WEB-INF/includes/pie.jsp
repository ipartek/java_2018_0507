<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
</div>
<footer>
	<form action="buscar" method="post">
	<span>Buscar palabra</span>
		<input type="text" placeholder="Buscar en el libro..." name="buscador" id="buscador"/>
		<button type="submit" class="btn btn-default" >Buscar</button>
	</form>
	
	<ul>
		<c:forEach items="${resultadosBusqueda}" var="paginaResultado">
			<li><a href="index?page=${paginaResultado}">${paginaResultado}</a>
		</c:forEach>
	</ul>
</footer>
</body>
</html>