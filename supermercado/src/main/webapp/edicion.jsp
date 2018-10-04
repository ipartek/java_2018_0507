<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="cabecera.jsp"%>

<section id="edicion" class="col-12">

			<h2>EdiciÃ³n de registro</h2>

			<form class="form-horizontal" action="listado">
				<div class="form-group">
					<label for="descuento"
						class="col-sm-offset-1 col-sm-2 control-label">Descuento</label>
					<div class="col-sm-8">
						<div class="input-group">
							<input type="number" class="form-control" id="descuento"
								name="descuento" required="required" min="1" max="99" value="1"
								placeholder="Descuento en %">
							<div class="input-group-addon">%</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="producto"
						class="col-sm-offset-1 col-sm-2 control-label">Producto</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="producto"
							name="producto" required="required" maxlength="100"
							pattern="[A-Za-z0-9Ã±ÃÃ¡Ã©Ã­Ã³ÃºÃ§Ã Ã¨Ã¬Ã²Ã¹ ]{3,100}" value="Producto1"
							placeholder="Nombre del producto de mÃ­nimo 3 caracteres y mÃ¡ximo 10">
					</div>
				</div>

				<div class="form-group">
					<label for="exampleInputFile"
						class="col-sm-offset-1 col-sm-2 control-label">Foto</label>
					<div class="col-sm-8">
						<input type="file" id="exampleInputFile" required="required">
						<p class="help-block">Busca la imagen que deseas subir.</p>
					</div>
				</div>
				<div class="form-group">
					<label for="precio" class="col-sm-offset-1 col-sm-2 control-label">Precio</label>
					<div class="col-sm-8">
						<div class="input-group">
							<input type="number" class="form-control" id="precio"
								name="precio" required="required" min="0" step="0.01"
								placeholder="Precio del libro">
							<div class="input-group-addon">â¬</div>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="descripcion"
						class="col-sm-offset-1 col-sm-2 control-label">DescripciÃ³n</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="descripcion"
							name="descripcion" required="required" maxlength="50"
							pattern="\w{3,50}"
							placeholder="DescripciÃ³n de mÃ­nimo 3 caracteres y mÃ¡ximo 50">
					</div>
				</div>
				<div class="form-group">
					<label for="unidad" class="col-sm-offset-1 col-sm-2 control-label">Unidades</label>
					<div class="col-sm-8">
						<input type="number" class="form-control" id="unidad"
							name="unidad" required="required" maxlength="30"
							pattern="\w{1,30}"
							placeholder="Numero de unidades mÃ­nimo 1 y mÃ¡ximo 30">
					</div>
				</div>




				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">Aceptar</button>
						<a class="btn btn-danger" href="listado.html">Cancelar</a>
					</div>
				</div>
			</form>


<%@ include file="pie.jsp"%>

