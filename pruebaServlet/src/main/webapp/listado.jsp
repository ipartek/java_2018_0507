<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ include file="WEB-INF/includes/cabecera.jsp"%>
<div class="container">

	<h2>Listado de productos</h2>
	<p class="lead">Su compra</p>

	<hr />

	

	<table class="table table-striped table-bordered table-hover">

		<thead>
			<tr>
				<th>ID</th>
				<th>Título</th>
				<th>Editorial</th>
				<th>Precio</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>1</th>
				<td>La Historia Interminable</td>
				<td>Bruguera</td>
				<td>12,5€</td>
			</tr>
			<tr>
				<th>2</th>
				<td>El Principito</td>
				<td>Anaya</td>
				<td>5,6€</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>18,1€</td>
			</tr>
		</tfoot>
	</table>


	<%@ include file="WEB-INF/includes/pie.jsp"%>