<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

<div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <table class="table table-striped ">
                <thead>
                    <tr>
                        <th scope="col" hidden>id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">edad</th>
                        <th scope="col">Raza</th>
                        <th scope="col">Peso</th>
                        <th scope="col">Apadrinado</th>
                        <th scope="col">Chip</th>
                        <th scope="col">Latitud y Longitud</th>
                        
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${dogs}" var="dog">
				<tr>
						<th scope="row" hidden>${dog.id}</th>
                        <td> ${dog.nombre} </td>
                        <td> ${dog.edad}</td>
                        <td> ${dog.raza}</td>
                        <td> ${dog.peso} kg</td>
                        <c:if test="${dog.apadrinado == 1}">
							<td>Apadrinado</td>
						</c:if>
						<c:if test="${dog.apadrinado != 1}">
							<td>No Apadrinado</td>
						</c:if>
                        <td> ${dog.chip}</td>
                        <td> ${dog.latitud} LA - ${dog.longitud} LO</td>

				</tr>
				</c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-3"></div>
    </div>

<%@ include file="/WEB-INF/includes/pie.jsp" %>