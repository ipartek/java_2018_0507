<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/includes/cabecera.jsp"%>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>edicion del libro</title>
</head>
<body>
	<c:if test="${usuario !=null}">
		<a href="admin/nuevoArticulo.jsp">escribir pagina</a>
	</c:if>
	<div>
		<a href="edicion?move=anterior&fromJsp=true&page=${pagina}">anterior</a>
		<c:forEach begin="0" end="${tamanoLibro}" var="item">
			<a href="edicion?move=barra&fromJsp=true&page=${item}"> ${item} </a>
		</c:forEach>
		<a href="edicion?move=siguiente&fromJsp=true&page=${pagina}">siguiente</a>
	</div>
	<div>
		<textarea cols="40" rows="5" name="sugerencias">${pagAct}</textarea>
		${autor}
		<c:if test="${usuario !=null}">
			<p>
				<a href="login?logout=true">logout</a>
		</c:if>
		</p>
		<c:if test="${usuario ==null}">
			<p>
				<a href="login.jsp">login</a>
			</p>
		</c:if>
	</div>
	<div>
		<a href="edicion?move=anterior&fromJsp=true&page=${pagina}">anterior</a>
		<c:forEach begin="0" end="${tamanoLibro}" var="item">
			<a href="edicion?move=barra&fromJsp=true&page=${item}"> ${item} </a>
		</c:forEach>
		<a href="edicion?move=siguiente&fromJsp=true&page=${pagina}">siguiente</a>

	</div>
	<form action="buscarPalabra" method="get">
	<p>
		<label for="palabra">palabra</label>
		<input type="palabra" name="palabra" id="email">
	</p>
	<button type="submit"> Buscar Palabra</button>
	</p>
	<div>
	<c:forEach items="${coincidencias}" var="item">
		<p><a href="edicion?move=barra&fromJsp=true&${item}"> ${item} </a></p>
	</c:forEach>
	</div>
</form>
</body>
</html>