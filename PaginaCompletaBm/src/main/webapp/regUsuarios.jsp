<!DOCTYPE html>
<% Usuario user;
user=(Usuario)request.getSession().getAttribute("usuario");
if(user!=null)
{%><%@include file="cabeceraLogjsp.jsp" %>
<% }else{%> <%@include file="cabeceraNoLog.jsp" %> <%}%>
    </header>
     <form class="form-horizontal" action="usuario" method="post">
        <div class="form-group">
            <label for="id" class="col-sm-offset-1 col-sm-2 control-label">email</label>
            <div class="col-sm-8">
                <input type="email" class="form-control" id="id" name="mail" required="required" min="1" placeholder="Id numérico">
            </div>
        </div>
          <div class="form-group">
            <label for="id" class="col-sm-offset-1 col-sm-2 control-label">email</label>
            <div class="col-sm-8">
                <input type="email" class="form-control" id="id" name="nombre" required="required" min="1" placeholder="Id numérico">
            </div>
        </div>
        <div class="form-group">
            <label for="titulo" class="col-sm-offset-1 col-sm-2 control-label">password</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="nombre" name="password" required="required" maxlength="100" pattern="[A-Za-z0-9ñÑáéíóúçàèìòù ]{3,50}" placeholder="nombre del articulo  mínimo 3 caracteres y máximo 50">
            </div>
        </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button name="login" value="registro" class="btn btn-primary">Aceptar</button>
                <a class="btn btn-danger" href="#">Cancelar</a>
        
        </div>
    </form>
  

    <footer>
        <div class="row">
            <div class="col-md-2 col-xs-6 text-center"><img src="imgs/fb.png" height="50" width="50" alt="Este es el ejemplo de un texto alternativo"></div>
            <div class="col-md-2 col-xs-6 text-center"><img src="imgs/twitter2.png" height="50" width="50" alt="Este es el ejemplo de un texto alternativo"></div>
            <div class="col-md-2 col-xs-12"><a href="#">Politica de Privacidad</a></div>
            <div class="col-md-2 col-xs-12 "><a href="#">Contacto</a></div>
            <div class="col-md-2 col-xs-12"><a href="#">localicacion</a></div>
            <div class="micop col-md-2 col-xs-12">&copy;2018</div>
        </div>
    </footer>

</body>
</html>