<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<div class="container">
  <div class="row">
    <div class="col-lg-10">
      <table class="table table-striped">
        <thead>
          <th>Nombre</th>
          <th>Apellido</th>
          <th>Direccion</th>
          <th>Numero de direccion</th>
          <th>Email</th>
          <th>Dni</th>
          <th>Puesto</th>
        </thead>
        <tbody>
          <c:forEach items="${personas}" var="persona">
            <tr>
              <td>${persona.nombre}</td>
              <td>${persona.apellido}</td>
              <td>${persona.direccion}</td>
              <td>${persona.numeroD}</td>
              <td>${persona.email}</td>
              <td>${persona.dni}</td>
              <td>${persona.puesto}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
</div>
</body>
</html>
