<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Productos</h1>
</header>

<div id="container-fluid">
	<div class="row" id="contenido">

	<c:forEach items="${paginas}" var="pagina">
	
		<div class="col-md-2"	>
			<dl>
			<dd><img src="imgs/${pagina.id}.jpg" id="minisss"></dd>
				<dt>Nombre</dt>
				${pagina.id}
				<dd>
					${pagina.texto} <a href="carrito?accion=add&id=${pagina.id}">Añadir al
						carrito</a>
				</dd>
				<dt>Precio</dt>
				<dd>${pagina.nick}</dd>
				
			</dl>
		</div>
		
	</c:forEach>	
	

	</div>
	</div>
<%@ include file="/WEB-INF/includes/pie.jsp"%>