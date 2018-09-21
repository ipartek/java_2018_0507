<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${usuario!=null}"><%@include file="cabeceraLogjsp.jsp" %></c:if>
<c:if test="${usuario==null}"><%@include file="cabeceraNoLog.jsp" %></c:if>

    </header>

 <c:if test="${carro.obtenerIntArticu!=0 }">
   <div class="row">
    <div class="col-md-10">
     <c:forEach items="${dao}" var="item" > 
        <article class="miProducto">
            <img src="imgs/bef.jpg" height="170" width="165" alt="">
            <section>
                <div class="texto-encima text-center">20%</div>
                <h3 class="text-center"><span class="price--line-through">12.95</span><span class="rojo">${item.nombre}</span> </h3>
                <p class="text-center">${item.descripcion}</p>
                <div class="miBotonera">
                    <button class="miBot" type="submit">+</button>
                    <span>1</span>
                    <button class="miBot" type="submit">-</button>
                </div>
            </section>
            <form action="carrito" method="get">
            <button class="btn btn-lg btn-success btn-block" value="${item.id}" name="idBoton" type="submit">añadir al carrito</button>
            </form>
        </article>
   </c:forEach>
	</div>
	 <div class="col-md-2">
	 <c:forEach items="${carro.obtenerArrayArticu}" var="item" >        
          <article class="miProducto">
            <section>
              <p>descuento: 20%</p>
            <p> nombre articulo: ${item.nombre}</p>
             <p> precio: ${item.precio}</p>
            <form action="carrito" method="get">
            <button value="${item.id}" name="borrarDelCarro" type="submit">borrar</button>
            </form>
            </section>
        </article>
    </c:forEach>
    <p>precio total:  ${carro.precioTotal} euros</p>
	 </div>
       

        <a href="#top" class="miTopp btn-danger">top</a>
    </div>
</c:if>
<c:if test="${carro.obtenerIntArticu==0 }">
<div class="row">
<div class="col-md-12">
    <c:forEach items="${dao}" var="item" > 
        <article class="miProducto">
            <img src="imgs/bef.jpg" height="170" width="165" alt="">
            <section>
                <div class="texto-encima text-center">20%</div>
                <h3 class="text-center"><span class="price--line-through">12.95</span><span class="rojo">${item.nombre}</span> </h3>
                <p class="text-center">${item.descripcion}</p>
                <div class="miBotonera">
                    <button class="miBot" type="submit">+</button>
                    <span>1</span>
                    <button class="miBot" type="submit">-</button>
                </div>
            </section>
            <form action="carrito" method="get">
            <button class="btn btn-lg btn-success btn-block" value="${item.id}" name="idBoton" type="submit">añadir al carrito</button>
            </form>
        </article>
  </c:forEach>
  </div>
        <a href="#top" class="miTopp btn-danger">top</a>
    </div>
</c:if>

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