<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Youtube PlayList</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
					<form action="" method="post" class="form-inline mt-2 mt-md-0">
						<input name="id" class="form-control mr-sm-2" type="text"
							placeholder="ID 11 caracerteres" title="11 caracteres" required
							pattern=".{11,11}"> <input name="nombre"
							class="form-control mr-sm-2" type="text"
							placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
						<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
					</form>

				</li>
			</ul>
		</div>
	</div>
</nav>