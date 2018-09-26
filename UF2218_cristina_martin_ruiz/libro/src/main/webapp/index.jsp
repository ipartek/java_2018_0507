<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<header> 
	<h1 class="text-center">LIBRO</h1>
</header>

<c:if test="${not empty user.nombre}">

	<div class="btn btn-default">
		<a href="escribirPagina.jsp">Escribir página</a>
	</div>

</c:if>
</br>

<!-- <div class="row">
	<div class="well col-md-8 col-md-offset-2 ">

		<div class="well">
			<p>Erase una vez...</p>
		</div>

		<div id="pieLibro">Autor: Unkown</div>

	</div>
</div>

 -->
 
 <!--  inicio paginacion -->
<c:set var="rowsPerPage" value="2" />
<c:set var="pageNumber" value="${param.pageNumber}" />
<c:set var="rowCount" value="${fn:length(paginas)}" /> 

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
			<th>texto</th>
			<th>autor</th>
		</tr>
	</thead>
	<tbody>
<!-- begin="${start}" end="${stop} -->
		<c:forEach items="${paginas}" var="pagina"  >
			<tr>
				<td>${pagina.texto}</td>
				<td>${pagina.autor}</td>
			</tr>
		</c:forEach>

	</tbody>

</table>


    <%--For displaying Previous link --%>
    <c:if test="${pageNumber gt 1}">
        <a href="index?pageNumber=${pageNumber - 1}">Previous</a>
    </c:if>
    <c:forEach begin="1" end="${numberOfPages}" var="i">
        <c:choose>
            <c:when test="${i!=pageNumber}">
                <a href="index?pageNumber=<c:out value="${i}"/>"><c:out value="${i}"/></a>
            </c:when>
            <c:otherwise>
                <c:out value="${i}"/>
            </c:otherwise>        
        </c:choose>       
    </c:forEach>  
    <%--For displaying Next link --%>
    <c:if test="${pageNumber lt numberOfPages}">
        <a href="index?pageNumber=${pageNumber + 1}">Next</a>
    </c:if>
</center>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp"%>

