<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

        <div class="contenido">
        	
			
			<c:forEach items="${paginas}" var = "pagina">
		        <div>

	                    <p>
	                    	${pagina.descripcion;}
	                    </p>
	                    <br>
	                   AUTOR: <h1>${usuario.nombre;}</h1>
						
           		 </div> 
		    </c:forEach>
            
        </div> 

<%@ include file="includes/footer.jsp" %>   