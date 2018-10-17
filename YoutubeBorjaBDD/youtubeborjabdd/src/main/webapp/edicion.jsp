<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>


	<h1>Edicion</h1>

<div id="row">
<div id="col-xm-6">
<form action="Edicion" method="post">
	<p>
		<label for="text">Id</label>
		<input type="text" name="id"  placeholder="<%=request.getParameter("id")%>" value="<%=request.getParameter("id")%>"/>
	</p>
	<p>
		<label for="nombre">nombre</label>
		<input type="text" name="nombre"  placeholder="<%=request.getParameter("nombre")%>" />
	</p>
	<p>
		<button name="tipo" value="editar">Editar</button>
	</p>
	
</form>
</div>
</div>
<%@ include file="/WEB-INF/includes/pie.jsp" %>