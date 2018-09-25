<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Productos</h1>
</header>

<div id="container-fluid">
	<div class="row" id="contenido">

	<c:forEach items="${productos}" var="producto">
	
		<div class="col-md-2"	>
			<dl>
			<dd><img src="imgs/${producto.id}.jpg" id="minisss"></dd>
				<dt>Nombre</dt>
				<dd>
					${producto.nombre} <a href="carrito?accion=add&id=${producto.id}">Añadir al
						carrito</a>
				</dd>
				<dt>Precio</dt>
				<dd><fmt:formatNumber value="${producto.precio}" type="currency"/></dd>
				
			</dl>
		</div>
		<c:if test="${producto.id%5==0 }">
			</div>
			<div class="row" id="contenido">
		
		</c:if>
	</c:forEach>	
	

	</div>
<%@ include file="/WEB-INF/includes/pie.jsp"%>