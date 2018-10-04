<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
</main>
<footer>

<c:if test="${sessionScope.user != null}">
<form action="buscador" method="post">
		<button>Buscar palabra</button> <input type="text" name="palabra">
	</form>
</c:if>
	<c:forEach items="${resultadosBusqueda}" var="paginaResultado">
		<li><a href="index?pagina=${paginaResultado}">${paginaResultado}</a>
	</c:forEach>
	
</footer>
</body>
</html>