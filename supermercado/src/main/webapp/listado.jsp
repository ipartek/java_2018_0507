<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="cabecera.jsp"%>

<section id="listado" class="col-12">

			<h2>Listado de productos</h2>
			<div class="table-responsive">
				<table class="table table-bordered text-center ">
					<thead>
						<tr>
							<th>Descuento</th>
							<th>Producto</th>
							<th>Foto</th>
							<th>Precio</th>
							<th>DescripciÃ³n</th>
							<th>Ud</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>20%</td>
							<td>BEEFETER</td>
							<td><img src="imgs/producto.png"></td>
							<td>12,95â¬</td>
							<td>Ginebra inglesa botella 10cl</td>
							<td>1</td>
							<td><a class="btn btn-default" href="edicion.html">Editar</a>
								<a class="btn btn-danger" href="edicion.html">Borrar</a></td>
						</tr>

					</tbody>
					<tfoot>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><a class="btn btn-primary" href="edicion.html">AÃ±adir</a></td>
						</tr>
					</tfoot>
				</table>
			</div>
	

<%@ include file="pie.jsp"%>

