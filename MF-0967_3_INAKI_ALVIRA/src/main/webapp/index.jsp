<%@ include file="WEB-INF/includes/cabecera.jsp" %>
 <a href="#top" class="miTopp btn-danger">top</a>
<div class="row">
<div class="col-md-12">
<c:forEach items="${perros}" var="perro">
        <article class="miProducto">
            <img id="perro" src="${perro.foto}" height="170" width="168" alt="">
            <section>
                <h4 class="text-center">Nombre:${perro.nombre}</h4>
                <p class="text-center">Edad:${perro.edad} Raza:${perro.raza} Peso:${perro.peso} Datos Chip: 
                id:${perro.miChip.id} lat:${perro.miChip.latitud} long:${perro.miChip.longitud} 
                <c:if test="${perro.apadrinado==true}"> apadrinado si</c:if> <c:if test="${perro.apadrinado==false}"> apadrinado no</c:if></p>
            </section>
        </article>
      </c:forEach>
  </div>
        <a href="#top" class="miTopp btn-danger">top</a>
    </div>
<%@ include file="WEB-INF/includes/pie.jsp" %>
