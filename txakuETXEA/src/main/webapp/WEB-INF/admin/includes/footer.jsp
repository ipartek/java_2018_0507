<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form class="form-inline justify-content-center" action="buscarPalabra"
	method="post">
	<div class="form-group">
		<span class="mr-1"><i class="fa fa-search"></i> Buscar palabra</span> <input type="search"
			class="form-control" name="palabra" />
	</div>
</form>

<div class="text-center mb-5">
	<ul class="list-inline">
		<c:forEach items="${resultadosBusqueda}" var="paginaResultado">
			<li class="list-inline-item"><a
				href="index?pagina=${paginaResultado}">${paginaResultado}</a></li>
		</c:forEach>
	</ul>
</div>
<footer>
	<p>&copy; 2018 Pablo Martin</p>
</footer>

</body>
</html>