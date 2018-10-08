<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="WEB-INF/includes/header.jsp"%>
<br />
<div>
	<h1>Alta de animales</h1>
	<form action="perros" method="post" class="form-horizontal">
	  <h4>Datos básicos...</h4>
	  <input type="hidden" name="id" value="3" required="required">
	  
  <div class="form-group">
    <label for="nombre" class="col-sm-2 control-label">Nombre*</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre mascota" required="required">
    </div>
  </div>
  <div class="form-group">
    <label for="edad" class="col-sm-2 control-label">Edad*</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="edad" min="0" max="50" id="edad" placeholder="Números enteros" required="required">
    </div>
  </div>
  <div class="form-group">
    <label for="raza" class="col-sm-2 control-label">Raza</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="raza" id="raza" placeholder="Si lo dejas blanco, lo registraremos como milrazas">
    </div>
  </div>
  <div class="form-group">
    <label for="peso" class="col-sm-2 control-label">Peso*</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="peso" id="peso" min="0" max="100" placeholder="Números enteros" required="required">
    </div>
  </div>
 
 <div class="form-group">
    <label for="apadrinado" class="col-sm-2 control-label">¿Apadrinado?*</label>
    <div class="col-sm-10">
      <input type="radio" name="apadrinado" id="true" value="true" checked> Sí 
      <input type="radio" name="apadrinado" id="false" value="false"> No 
    </div>
  </div>
 <div class="form-group">
    <label for="chip" class="col-sm-2 control-label">Número de identificación*</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" max="10" name="chip" id="chip" pattern="[0-9]{2}[\-]?[0-9]{4}[\-]?[0-9]{4}" placeholder="DD-DDDD-AAAA" required="required">
    </div>
  </div>
  <h4>Última localización...</h4>
 <div class="form-group">
    <label for="latitud" class="col-sm-2 control-label">Latitud*</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" min="100000" max="999999" name="latitud" id="latitud" placeholder="454565" required="required">
    </div>
     <label for="longitud" class="col-sm-2 control-label">Longitud*</label>
    <div class="col-sm-10">
      <input type="number" class="form-control"  min="100000" max="999999" name="longitud" id="longitud" placeholder="875136" required="required">
    </div>
  </div>


 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Continuar</button>
      <a href="select" alt="Volver al listado" class="btn btn-danger">Cancelar</a>
    </div>
  </div>
</form>
</div>

<%@ include file="WEB-INF/includes/footer.jsp"%>
