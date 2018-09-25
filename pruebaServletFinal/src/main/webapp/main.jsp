<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>Lista productos</header>


<!-- Una seccion donde se explican terminos. 
Aqui se usa a modo de lista -->
<section id="listado">
	<c:forEach items="${productos}" var="producto"> 
	<article>
			<dl>
				<dt>Nombre</dt>
				<dd>
				<!-- carrito es el servlet -->
					${producto.nombre} <a href="carrito?accion=add&id=${producto.id}">Añadir al
						carrito</a>
				</dd>
				<dt>Precio</dt>
				<dd><fmt:formatNumber value="${producto.precio}" type="currency"/></dd>
			</dl>
		</article>
	
	</c:forEach>	
</section>