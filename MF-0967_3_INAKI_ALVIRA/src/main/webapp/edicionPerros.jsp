<%@include file="WEB-INF/includes/cabecera.jsp"%>
<form class="form-horizontal" action='edicion' method="POST">
	<fieldset>
		<div id="legend">
			<legend class="text-center">Registra un perro</legend>
		</div>
		<div class="control-group text-center">
			<!-- Username -->
			<label class="control-label" for="username">nombre</label>
			<div class="controls">
				<input type="text" id="nombre" name="nombre" placeholder="nombre"
					class="input-xlarge">

			</div>
		</div>

		<div class="control-group text-center">

			<label class="control-label" for="email">peso</label>
			<div class="controls">
				<input type="number" max="100" id="peso" name="peso" placeholder="Kg."
					class="input-xlarge">
			</div>
		</div>
		<div class="control-group text-center">
			<label class="control-label" for="edad">edad</label>
			<div class="controls">
				<input type="number" id="edad" name="edad" placeholder="edad"
					max="20" class="input-xlarge">

			</div>
		</div>

		<div class="control-group text-center">
			<label class="control-label" for="raza">raza</label>
			<div class="controls">
				<input type="text" id="raza" name="raza" placeholder="raza"
					class="input-xlarge">
			</div>
		</div>
		<div class="control-group text-center">
			<label class="control-label" for="codigo">codigo chip</label>
			<div class="controls">
				<input type="text" id="codigo"
					pattern="\d\d+-+\d\d\d\d+-+[2][0][0-2][0-9]" name="codigo"
					placeholder="codigo" class="input-xlarge">
				<p class="help-block">DD-DD-2018</p>
			</div>
		</div>
		<div class="form-group">
			<label for="recuerdame" class="text-info"><span>Apadrinado?<input
					id="apadri" name="apadri" type="checkbox"></span></label><br>
			
		</div>

		<div class="control-group text-center">
			<!-- Button -->
			<div class="controls">
				<button class="btn btn-success">anadir perro</button>
			</div>
		</div>
	</fieldset>
</form>
<%@include file="WEB-INF/includes/pie.jsp"%>