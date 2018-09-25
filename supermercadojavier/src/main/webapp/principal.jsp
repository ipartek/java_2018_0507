<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Productos</h1>
</header>

<section id="listado">

	<c:forEach items="${articulos}" var="articulo">
		<article>
			<dl>
				<dt>Nombre</dt>
				<dd>
					${articulo.nombre} <a href="carrito?accion=add&id=${articulo.id}">Añadir al
						carrito</a>
				</dd>
				<dt>Precio</dt>
				<dd><fmt:formatNumber value="${articulo.precio}" type="currency"/></dd>
			</dl>
		</article>
	</c:forEach>
	
</section>

<%@ include file="/WEB-INF/includes/pie.jsp"%>