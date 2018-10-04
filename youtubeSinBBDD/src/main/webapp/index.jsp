
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="includes/header.jsp"%>
<%@ include file="includes/nav.jsp"%>


<!-- Page Content -->
<div class="container">

	<div class="row">

		<div class="col-lg-3">
			<h1 class="my-4">Lista Reproduccion</h1>
			<ul class="list-group">

				<c:forEach items="" var="v">
					<li class="list-group-item mb-1"><a href="#"
						onclick="reproducir('')"></a></li>
				</c:forEach>

			</ul>


		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">

			<div class="card mt-4">
				<!-- =videoInicio.getIdVideo() -->
				<iframe id="iframe" width="823" height="415"
					src="https://www.youtube.com/embed/${v[0].id}" frameborder="0"
					allow="autoplay; encrypted-media" allowfullscreen></iframe>

				<div class="card-body">
					<h3 class="card-title"></h3>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque
						facere, soluta. Totam id dolores, sint aperiam sequi pariatur
						praesentium animi perspiciatis molestias iure, ducimus!</p>
					<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
						&#9734;</span> 4.0 stars
				</div>
			</div>

		</div>
		<!-- /.col-lg-9 -->

	</div>

</div>
<!-- /.container -->

<%@ include file="includes/footer.jsp"%>


