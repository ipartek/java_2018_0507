<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="java.util.*" %>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Carrito</h1>
</header>

<table id="carritolistado">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<td>${producto.nombre}</td>
				<td><fmt:formatNumber value="${producto.precio}" type="currency"/></td>
				<td><a href="carrito?id=${producto.id}&accion=delete">Borrar</a></td>
			</tr>

		</c:forEach>
		

<c:set var="totalCount" scope="session" value="${fn:length(carrito)}"/>
<c:set var="perPage" scope="session"  value="${5}"/>
<c:set var="pageStart" value="1"/>
<c:if test="${pageStart == null || pageStart < 0}">
       <c:set var="pageStart" value="0"/>
</c:if>
<c:if test="${totalCount < pageStart}">
       <c:set var="pageStart" value="${pageStart - perPage}"/>
</c:if>
    <a href="?start=${pageStart - perPage}"><<</a>${pageStart + 1} - ${pageStart + perPage} 
    <a href="?start=${pageStart + perPage}">>></a>                                               
<h1>Letters</h1>
   <c:forEach var="letter" items="${letters}" 
                        begin="${pageStart}" end="${pageStart + perPage - 1}">
              ${letter}
   </c:forEach>
		
		<span>${fn:length(carrito)}</span>
		
	</tbody>
</table>

<%@ include file="/WEB-INF/includes/pie.jsp"%>