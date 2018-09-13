<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp" %>

<jsp:useBean id="descripciones" scope="request" class="com.ipartek.formacion.javaee.libros.modelos.Descripciones" />

<div class="jumbotron">
  <h1><jsp:getProperty property="titulo" name="cabecera"/></h1>
</div>
<div>
  <jsp:getProperty property="datos" name="descripciones"/>
	
</div>
<%@ include file="includes/pie.jsp" %>