<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="WEB-INF/includes/cabecera.jsp" %>

<div class="center-block" id="container-fluid">
		<div class="row">
		
		
			
			<c:forEach items="${productos}" var="prod">
				<div class="col-md-2" style="margin-left: 30px">
			<!-- START The Product Item -->

				<img src="http://www.jarrow.com/productImg2/KETO.jpg" alt="" />
				<h1 class="product-title">${prod.nombre}</h1>
				<h3 class="product-price"><fmt:formatNumber value="${prod.precio}" type="currency"/></h3>
				<div class="quantity-input">
					<input class="minus btn" type="button" value="-"> <input
						id="text_7_keto_dhea" value="1" class="input-text qty text"
						size="4" /> <input class="plus btn" type="button" value="+">
				</div>
				
				<a class="btn btn-success add-to-cart-button" href="carrito?accion=add&id=${prod.id}">Añadir al
						carrito</a>
						
	

				<!-- END!! The Product Item -->
			</div>
			</c:forEach>
			
				  <div style="clear:both;margin-right:20px">
				  
				   <p>Pagina:${pagina}</p>
				  
        <!--Los if contienen los href para queno funcionen , es decir si estamos en la primera pagina, no dejarle al usuario darle a primera pagina porque ya estamos en ella !!!, lo mismo con el resto-->
        <a class="btn btn-primary" <c:if test="${pagina!=0}" > href="principal?pagina=0" </c:if> >   |<   </a>
        <a class="btn btn-primary"  <c:if test="${pagina!=0}" > href="principal?pagina=${pagina-1}" </c:if>>  <<   </a>
        <a class="btn btn-primary"  <c:if test="${pagina!=total}" >href="principal?pagina=${pagina+1}"</c:if> >  >>  </a>
        <a class="btn btn-primary"  <c:if test="${pagina!=total}" >href="principal?pagina=${total}"</c:if> >    >|   </a>
    </div>
			
			
					</div>
		</div>


	</div>

<%@ include file="WEB-INF/includes/pie.jsp" %>

