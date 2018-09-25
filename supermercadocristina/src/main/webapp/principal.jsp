<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Productos</h1>
</header>

<section id="listado">

	<article>
		<dl>
			<dt>Nombre</dt>
			<dd>
				Mi producto <a href="carrito.jsp?accion=add&id=1">Añadir al
					carrito</a>
			</dd>
			<dt>Precio</dt>
			<dd>12,34€</dd>
		</dl>
	</article>
	<article>
		<dl>
			<dt>Nombre</dt>
			<dd>
				Mi producto <a href="carrito.jsp?accion=add&id=1">Añadir al
					carrito</a>
			</dd>

			</dd>
			<dt>Precio</dt>
			<dd>12,34€</dd>
		</dl>
	</article>

</section>

<%@ include file="/WEB-INF/includes/pie.jsp"%>