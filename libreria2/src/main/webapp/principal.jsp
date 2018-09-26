<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Paginas</h1>
</header>

<div id="container-fluid">
<form action="PaginacionServlet" method="post" align="center">
	Introduce Numero de pagina<input type="number" name="numero"/>
	<input type="submit">
	
	</form>
	<div class="row" id="contenido">




<c:if test="${paginaF<=1||paginaF==null}">


<c:forEach items="${paginas}" var="pagina" begin="0" end="0">
	
		<div class="col-md-8"	>
			
					${pagina.texto} 
				<dd><br><br><small><bold>${pagina.nick}</bold></small></dd>
				
			</dl>
		</div>
		
	</c:forEach>	



</c:if>

<c:if test="${paginaF>1}">
	<c:forEach items="${paginas}" var="pagina" begin="${paginaF}" end="${paginaF}">
	
		<div class="col-md-8"	>
			
					${pagina.texto} 
				<dd><br><br><small><bold>${pagina.nick}</bold></small></dd>
				
			</dl>
		</div>
		
	</c:forEach>	
	</c:if>

	</div>
	
	
	</div>
		
	<form action="PaginacionServlet" name="siguiente" value="next" method="post">
	<button value="next" name="siguiente" align="center">sigiente</button>
		
	
	</form>
<%@ include file="/WEB-INF/includes/pie.jsp"%>