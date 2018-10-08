<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>


<h1 align="center">Añadir Perrete</h1>
<div class="col-sm-3"></div>
<div class="col-sm-6" style="padding:50px 0">
	<div class="logo"></div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="login-form" class="text-left" action="Edicion">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group"><div align="center">Nombre</div>
						<label for="lg_username" class="sr-only">nombre</label>
						<input type="text" class="form-control" id="lg_username" name="nombre" placeholder="nombre" required min="1" max="10">
					</div>
					<div class="form-group"><div align="center">Edad</div>
						<label for="lg_password" class="sr-only">edad</label>
						<input type="number" class="form-control" id="lg_password" name="edad" placeholder="edad"  min="1" required>
					</div>
					<div class="form-group"><div align="center">Raza</div>
						<label for="lg_password" class="sr-only">raza</label>
						<input type="text" class="form-control" id="lg_password" name="raza" placeholder="raza" min="1" required>
					</div>
					<div class="form-group"><div align="center">Peso</div>
						<label for="lg_password" class="sr-only">Peso</label>
						<input type="number" class="form-control" id="lg_password" name="kg" placeholder="kg" min="1" required>
					</div>
					
					<div class="form-group" align="center"><div align="center">Adoptado?</div>
					<label>si</label>
						<input type="radio" id="lg_password" name="apadrinado" value="true">
					</div>
					<div class="form-group" align="center">
					<label>no</label>
						<input type="radio"  id="lg_password" name="apadrinado" value="false"  checked="checked">
					</div>
					<div class="form-group"><div align="center">nidentificacion</div>
						<label for="lg_password" class="sr-only">nidentificacion</label>
						<input type="number" class="form-control" id="lg_password" name="nidentificacion" placeholder="nidentificacion" min="1"  pattern="{1-9}{2}-[1-9]{4}-[1-9]{4}" required>
					</div>
					
					<div class="form-group"><div align="center">latitud</div>
						<label for="lg_password" class="sr-only">latitud</label>
						<input type="number" class="form-control" id="lg_password" name="latitud" placeholder="latitud" min="1" required>
					</div>
					<div class="form-group"><div align="center">Longitud</div>
						<label for="lg_password" class="sr-only">longitud</label>
						<input type="number" class="form-control" id="lg_password" name="longitud" placeholder="longitud"  min="1" required>
					</div>
				</div>
				<button type="submit" name="tipo" value="anadir" >añadir</button>
			</div>
			<div class="col-sm-3"></div>
			
		</form>
	</div>
	<!-- end:Main Form -->
</div>
<%@ include file="/WEB-INF/includes/pie.jsp" %> 