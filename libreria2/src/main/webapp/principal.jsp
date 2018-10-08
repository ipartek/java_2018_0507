<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Paginas</h1>
</header>

<div id="container-fluid">
	<form action="PaginacionServlet?${paginaF}" method="post" align="center">
		<br>
		<br>Introduce Numero de pagina<input type="number" name="numero" />
		<input type="submit">

	</form>
		<form action="PaginacionServlet?${paginaF+1}" method="post" align="center">
				<input type="submit" value="sigiente">
		
	</form>
	<br>
	<br>
	<div class="row" id="contenido">



		<c:if test="${paginaF<=1||paginaF==null}">


<h1>pagina ${paginaF}</h1>


			<c:forEach items="${paginas}" var="pagina" begin="0" end="0">

				<div class="col-md-8">

					${pagina.texto}
					<dd>
						<br>
						<br>
						<small><bold>${pagina.nick}</bold></small>
					</dd>

					</dl>
				</div>
	<button>anterior</button>
			</c:forEach>



		</c:if>

		<c:if test="${paginaF>1}">
			<h1>pagina ${paginaF}</h1>

			<c:forEach items="${paginas}" var="pagina" begin="${paginaF}"
				end="${paginaF}">

				<div class="col-md-8">

					${pagina.texto}
					<dd>
						<br>
						<br>
						<small><bold>${pagina.nick}</bold></small>
					</dd>

					</dl>
				</div>
<a href="principal?paginaF=${paginaF+1}"><button>sigiente</button></a>
	<button>anterior</button>
			</c:forEach>
		</c:if>
	
	</div>


</div>



<%@ include file="/WEB-INF/includes/pie.jsp"%>