<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    
    <%@ include file="cabecera.jsp"%>
    <%@ include file="nav.jsp"%>
        <h1>Login</h1>
    
    <div class="row">
  <div class="col-xs-1 col-md-2"></div>
  <div class="col-xs-10 col-md-8">
  	<form class="form-horizontal" action="login" method="get">
  <div class="form-group">
    <label for="usuario" class="col-sm-2 control-label">Usuario</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="usuario" placeholder="Usuario" name="usuario">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
</form>
  </div>
  <div class="col-xs-1 col-md-2"></div>
</div>
    

    <%@ include file="footer.jsp"%>
