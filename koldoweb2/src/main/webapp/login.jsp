<%@ include file="cabecera.jsp" %>
<div class="row">
  <div class="col-md-8">
  <ol class="breadcrumb">
  <li><a href="#">TodoLibros</a></li>
  <li><a href="#">Editar</a></li>
  <li class="active">Inicio de sesión</li>
</ol>
</div>
  <div class="col-md-4">
<button type="button" class="btn btn-default btn-sm">
  <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span> Únase al catálogo de libros más completo de Internet
</button>
</div>

<div class="row">
  <div class="col-md-8">
   <form class="form-signin">
        <h2 class="form-signin-heading">Introduce tus credenciales</h2>
        <label for="inputEmail" class="sr-only">Correo electrónico:</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Introduce tu correo electrónico" required autofocus>
        <label for="inputPassword" class="sr-only">Contraseña: </label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Recuérdame
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar sesión</button>
      </form></div>
  <div class="col-md-4">
  <h1>Inicie sesión para continuar</h1>
  <p>Es necesario que inicie sesión en su cuenta para continuar. En caso de no poder acceder, seleccione el botón de recuperación que se muestra a continuación:</p>

<button type="button" class="btn btn-danger">Recuperación de cuenta</button><br />
</div>
 
<div class="row">
  <div class="col-md-12">
  
      <hr class="featurette-divider"><br />
</div>
    </div>


<%@ include file="footer.jsp" %>