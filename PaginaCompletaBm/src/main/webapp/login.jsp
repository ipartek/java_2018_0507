<% Usuario user;
user=(Usuario)request.getSession().getAttribute("usuario");
if(user!=null)
{%><%@include file="cabeceraLogjsp.jsp" %>
<% }else{%> <%@include file="cabeceraNoLog.jsp" %> <%}%>
    </header>
    <jsp:useBean id="error" scope="request"  class="com.ipartek.supermercado.pojo.Errores"/>
    <form class="form-horizontal" action="usuario"   method="post">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-offset-1 col-sm-2 control-label">Email</label>
            <div class="col-sm-8">
                <input type="email" class="form-control" name="mail" id="inputEmail3" placeholder="Email" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-offset-1 col-sm-2 control-label">Password</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="Password" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-8">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" value="login" name="login" class="btn btn-default">login</button>
               <jsp:getProperty property="error" name="error"/>
            </div>
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
    