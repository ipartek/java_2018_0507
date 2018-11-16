<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>
	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">
				<h1 class="my-4">Lista Reproduccion</h1>
				<div class="list-group">
					<%
						ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");

						Video videoInicio = new Video();
						if (!videos.isEmpty()) {
							videoInicio = videos.get(0);
						}

						for (Video v : videos) {
					%>

					<a href="#"
						onclick="reproducir('<%=v.getCodigo()%>'); return false"
						class="list-group-item"><%=v.getNombre()%></a> <a
						href="?id=<%=v.getId()%>"><i style="color: red;"
						class="float-right fas fa-trash-alt"></i></a> <a
						href="delete?id=<%=v.getId()%>">Borrar</a> <a
						href="update?id=<%=v.getId()%>">Actualizar</a>
						<input type="hidden" value=<%=v.getId() %>/>
					<%
						} //end for
					%>


				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div class="card mt-4">

					<iframe id="iframe" width="823" height="415"
						src="https://www.youtube.com/embed/<%=videoInicio.getCodigo()%>"
						frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>

					<div class="card-body">
						<h3 class="card-title"><%=videoInicio.getNombre()%></h3>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque
							facere, soluta. Totam id dolores, sint aperiam sequi pariatur
							praesentium animi perspiciatis molestias iure, ducimus!</p>
						<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
							&#9734;</span> 4.0 stars
					</div>
				</div>
				<!-- /.card -->

				<div class="card card-outline-secondary my-4">
					<div class="card-header">Comentarios</div>
					<div class="card-body">
						<c:forEach items="${comentarios}" var="comentario">
							<p>${comentario.texto}</p>
							<small class="text-muted">Posted by
								${comentario.usuario_id} on ${comentario.fecha }</small>
							<hr>
						</c:forEach>


					</div>
				</div>
				<!-- /.card -->

			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2017</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script
		src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
	<script
		src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


	<script>
		function reproducir(id) {

			console.info('reproducir video ' + id);
			var iframe = document.getElementById('iframe');
			iframe.src = "https://www.youtube.com/embed/" + id;
			return false;
		}
	</script>

</body>

</html>
