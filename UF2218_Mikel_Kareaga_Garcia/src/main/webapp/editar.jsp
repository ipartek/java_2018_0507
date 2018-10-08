<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp" %>
    <form action="editar" method="post">
    	<textarea rows="30" cols="50" name="escrito"></textarea>
    	<button>Guardar</button>
    	<span class="error">${error}</span>
    </form>
    
    <%@ include file="/WEB-INF/includes/pie.jsp" %>