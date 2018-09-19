<% Usuario user;
user=(Usuario)request.getSession().getAttribute("usuario");
if(user!=null)
{%><%@include file="cabeceraLogjsp.jsp" %>
<% }else{%> <%@include file="cabeceraNoLog.jsp" %> <%}%>

    </header>
  <%
  for(int i=0;i<15;i++){
	  ArticuloArrayDao.getInstance().insert(new Articulo(i,i+10,"nombre"+i,"descripcion"+i));
  }
  	
    Carrito articulosCarrito;    
    articulosCarrito=(Carrito)request.getSession().getAttribute("carro");
    if(articulosCarrito!=null){
 %>
   <div class="row">
    <div class="col-md-11">
    <% for (int i=0;i<15;i++){%>
        <article class="miProducto">
            <img src="imgs/bef.jpg" height="170" width="165" alt="">
            <section>
                <div class="texto-encima text-center">20%</div>
                <h3 class="text-center"><span class="price--line-through">12.95</span><span class="rojo"><%=ArticuloArrayDao.getInstance().getById(i).getPrecio()%></span> </h3>
                <p class="text-center"><%=ArticuloArrayDao.getInstance().getById(i).getDescripcion()+i%></p>
                <div class="miBotonera">
                    <button class="miBot" type="submit">+</button>
                    <span>1</span>
                    <button class="miBot" type="submit">-</button>
                </div>
            </section>
            <form action="carrito" method="get">
            <button class="btn btn-lg btn-success btn-block" value=<%=i%> name="idBoton" type="submit">añadir al carrito</button>
            </form>
        </article>
   <% }%>
	</div>
	 <div class="col-md-1">
	<%for (int i=0;i<articulosCarrito.obtenerArrayArticu().size();i++){ %>
	 <p><%=articulosCarrito.obtenerArrayArticu().get(i).getNombre() %></p>
	 <%} %>
	 </div>
       

        <a href="#top" class="miTopp btn-danger">top</a>
    </div>
<% } else{%>
<div class="row">
    <% for (int i=0;i<15;i++){%>
        <article class="miProducto">
            <img src="imgs/bef.jpg" height="170" width="165" alt="">
            <section>
                <div class="texto-encima text-center">20%</div>
                <h3 class="text-center"><span class="price--line-through">12.95</span><span class="rojo"><%=ArticuloArrayDao.getInstance().getById(i).getPrecio()%></span> </h3>
                <p class="text-center"><%=ArticuloArrayDao.getInstance().getById(i).getDescripcion()+i%></p>
                <div class="miBotonera">
                    <button class="miBot" type="submit">+</button>
                    <span>1</span>
                    <button class="miBot" type="submit">-</button>
                </div>
            </section>
            <form action="carrito" method="get">
            <button class="btn btn-lg btn-success btn-block" value=<%=i%> name="idBoton" type="submit">añadir al carrito</button>
            </form>
        </article>
   <% }%>
        <a href="#top" class="miTopp btn-danger">top</a>
    </div>
<% } %>

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