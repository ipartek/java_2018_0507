<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>


	<h1>Login</h1>

<div id="row">
<div id="col-xm-6">
<form action="Edicion?id=<%=request.getParameter("id")%>" method="post">
	
	<H1>SEGURO???</H1>
	
	
<button name="opcion" value="si">si</button>
<button name="opcion" value="no">no</button>

</form>
</div>
</div>
<%@ include file="/WEB-INF/includes/pie.jsp" %>