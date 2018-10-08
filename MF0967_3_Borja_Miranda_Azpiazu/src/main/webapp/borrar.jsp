<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>


	
<div class="col-sm-3"></div>

<div class="col-sm-6">
<h1>Borrar perro</h1>

<form action="Edicion?id=<%=request.getParameter("id")%>" method="post">
	
	<H1>SEGURO???</H1>
	
	
<button name="opcion" value="si">si</button>
<button name="opcion" value="no">no</button>

</form>
</div>
<div class="col-sm-3"></div>
<%@ include file="/WEB-INF/includes/pie.jsp" %>