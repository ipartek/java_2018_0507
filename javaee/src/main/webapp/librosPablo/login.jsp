<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/cabecera.jsp" %>
	
	 <form>
    <h2>Contact Us</h2>
    <div class="row">
      <div class="col-md-6">
        <div class="form-group">
          <label for="first">Nombre</label>
          <input type="text" class="form-control" placeholder="nombre" id="first">
        </div>
      </div>
      <!--  col-md-6   -->

      <div class="col-md-6">
        <div class="form-group">
          <label for="last">Apellido</label>
          <input type="text" class="form-control" placeholder="apellido" id="last">
        </div>
      </div>
      <!--  col-md-6   -->
    </div>


    <div class="row">
      <div class="col-md-6">
        <div class="form-group">
          <label for="company">Contraseña</label>
          <input type="password" class="form-control" placeholder="password" id="company">
        </div>


      </div>
      <!--  col-md-6   -->

      <div class="col-md-6">

        <div class="form-group">
          <label for="phone">Numero de telefono</label>
          <input type="tel" class="form-control" id="phone" placeholder="Telefono">
        </div>
      </div>
      <!--  col-md-6   -->
    </div>
    <!--  row   -->


    <div class="row">
      <div class="col-md-6">

        <div class="form-group">
          <label for="email">Direccion Email</label>
          <input type="email" class="form-control" id="email" placeholder="email">
        </div>
      </div>
      <!--  col-md-6   -->

      <!--  col-md-6   -->
    </div>
    <!--  row   -->


    <label for="contact-preference">When is the best time of day to reach you?</label>
    <div class="radio">
      <label>
        <input type="radio" name="contact-preference" id="contact-preference" value="am" checked>Morning
      </label>
    </div>
    <div class="radio">
      <label>
        <input type="radio" name="contact-preference" id="contact-preference" value="pm" checked>Evening
      </label>
    </div>

    <label for="newsletter">Would you like to recieve our email newsletter?</label>
    <div class="checkbox">

      <label>
        <input type="checkbox" value="Sure!" id="newsletter"> Sure!
      </label>
    </div>


    <button type="submit" class="btn btn-primary">Submit</button>
  </form>





<%@include file="includes/pie.jsp"%>