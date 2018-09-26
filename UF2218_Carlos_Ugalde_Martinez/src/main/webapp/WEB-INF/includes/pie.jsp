<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
</main>
<footer>

<c:if test="${sessionScope.user != null}">
<button>Buscar palabra</button>
	<input type="text">
</c:if>
	
</footer>
</body>
</html>