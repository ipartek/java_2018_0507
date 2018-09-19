<% Usuario user;
user=(Usuario)request.getSession().getAttribute("usuario");
if(user!=null)
{%><%@include file="cabeceraLogjsp.jsp" %>
<% }else{%> <%@include file="cabeceraNoLog.jsp" %> <%}%>
    </header>
    <table class="text-center table table-hover table-condensed table-bordered table-striped table-condensed" border=0>
        <thead>
            <tr>
                <th class="text-center">IDproducto</th>
                <th class="text-center">nombre</th>
                <th class="text-center">descripcion</th>
                <th class="text-center">Precio</th>
                <th class="text-center">PrecioXunidad</th>
                <th class="text-center">descuento</th>
                <th class="text-center">imagen</th>
            </tr>
        </thead>
        <tbody>
        <% 
        for (int i=0;i<ArticuloArrayDao.getInstance().getAll().size();i++){  %>
        
            <tr>
                <th class="text-center">1</th>
                <td><%=ArticuloArrayDao.getInstance().getAll().get(i).getNombre() %></td>
                 <td><%=ArticuloArrayDao.getInstance().getAll().get(i).getDescripcion() %></td>
                  <td><%=ArticuloArrayDao.getInstance().getAll().get(i).getPrecio() %></td>
                
                <td>17.95L</td>
                <td>20%</td>
                <td><img src="imgs/cardhu.jpg" height="50" width="50" alt="">
                </td>
            </tr>
            <%} %>
        </tbody>
        <tfoot>

        </tfoot>
    </table>
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