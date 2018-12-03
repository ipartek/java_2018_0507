<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<div class="row">
    <div class="col-lg-10">
      <form action="listaPersonas" method="post">
        <legend>Nueva Persona</legend>
        <div class="form-group">
          <input type="hidden" name="accion" value="insert" class="form-control"/>
          <label for="nombre">Nombre:</label>
          <input type="text" name="nombre" id="nombre" class="form-control">
        </div>
        <div class="form group">
          <label for="apellido">Apellido:</label>
          <input type="text" class="form-control" id="apellido" name="apellido"/>
        </div>
        <div class="form group">
            <label for="direccion">Direccion:</label>
            <input type="text" class="form-control" id="direccion" name="direccion"/>
        </div>
        <div class="form group">
            <label for="direccion">Numero de direccion:</label>
            <input type="text" id="numero_direccion" name="numero_direccion" class="form-control"/>
        </div>
        <div class="form group">
            <label for="direccion">Email:</label>
            <input type="text" id="email" name="email" class="form-control"/>
        </div>
        <div class="form group">
            <label for="direccion">Dni:</label>
            <input type="text" id="dni" name="dni" class="form-control"/>
        </div>
        <div class="form group">
            <label for="direccion">Puesto:</label>
            <input type="text" id="puesto" name="puesto" class="form-control"/>
        </div>
        <button class="btn btn-primary">Añadir</button>
      </form>
    </div>
  </div>