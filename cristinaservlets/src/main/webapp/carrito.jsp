<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page import="java.util.*"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Carrito</h1>
</header>

<!-- http://www.javaknowledge.info/jstl-1-1-paginate-table-example-with-next-previous-features/  -->

<!--  inicio paginacion -->
<c:set var="rowsPerPage" value="2" />
<c:set var="pageNumber" value="${param.pageNumber}" />
<c:set var="rowCount" value="${fn:length(carrito)}" /> 

<c:set var="a">
    <fmt:formatNumber value="${rowCount/rowsPerPage}" maxFractionDigits="0"/> 
</c:set>

<c:set var="b" value="${rowCount/rowsPerPage}" />

<c:choose>
    <c:when test="${a==0}">
        <c:set var="numberOfPages" value="1" scope="session"/>   
    </c:when>
 
    <c:when test="${b>a}">
        <c:set var="xxx" value="${b%a}"/>
        <c:if test="${xxx>0}">
            <c:set var="numberOfPages" value="${b-xxx+1}" scope="session"/>   
        </c:if>
    </c:when>
 
    <c:when test="${a>=b}">
        <c:set var="numberOfPages" value="${a}" scope="session"/>    
    </c:when>
</c:choose>

<c:set var="start" value="${pageNumber*rowsPerPage-rowsPerPage}"/>
<c:set var="stop" value="${pageNumber*rowsPerPage-1}"/>
<center>
    <table border="1" width="60%"> 
    
    <thead>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
	</thead>   
	<tbody>                
    
    <c:forEach items="${carrito}" var="producto" begin="${start}" end="${stop}">
			<tr>
				<td>${producto.nombre}</td>
				<td><fmt:formatNumber value="${producto.precio}"
						type="currency" /></td>
				<td><a href="carrito?id=${producto.id}&accion=delete&pageNumber=1">Borrar</a></td>
			</tr>
		</c:forEach>
		
		</tbody>
		
    </table> 
    
    <%--For displaying Previous link --%>
    <c:if test="${pageNumber gt 1}">
        <a href="carrito.jsp?pageNumber=${pageNumber - 1}">Previous</a>
    </c:if>
    <c:forEach begin="1" end="${numberOfPages}" var="i">
        <c:choose>
            <c:when test="${i!=pageNumber}">
                <a href="carrito.jsp?pageNumber=<c:out value="${i}"/>"><c:out value="${i}"/></a>
            </c:when>
            <c:otherwise>
                <c:out value="${i}"/>
            </c:otherwise>        
        </c:choose>       
    </c:forEach>  
    <%--For displaying Next link --%>
    <c:if test="${pageNumber lt numberOfPages}">
        <a href="carrito.jsp?pageNumber=${pageNumber + 1}">Next</a>
    </c:if>
</center>


<%@ include file="/WEB-INF/includes/pie.jsp"%>