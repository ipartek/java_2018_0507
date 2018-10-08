<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="includes/header.jsp"%>

<!-- Page Content -->
<div class="container">


	<div class="row mt-4">

		<c:forEach items="${perros}" var="perro">
			<div class="card col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<img class="card-img-top" src="imgs/${perro.id}.jpg"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">${perro.nombre}${perro.id}</h5>
					<ul>
						<li class="card-text">Raza: ${perro.raza}</li>
						<li class="card-text">Edad: ${perro.edad} años</li>
						<li class="card-text">Peso: ${perro.peso} kg</li>
					</ul>
					<a href="#" class="btn btn-primary">Adoptar</a>
				</div>
			</div>

		</c:forEach>


	</div>


	<!-- /.container -->

	<%@ include file="includes/footer.jsp"%>