<%@page import="com.ipartek.formacion.youtube.pojo.controladores.HomeController"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="includes/header.jsp" %>	
<%@ include file="includes/nav.jsp" %>	
   

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3">        	
          <h1 class="my-4">Lista Reproduccion</h1>
          <ul class="list-group">	  
          	                 	
          	 <c:forEach items="${videos}" var="v">
          	    <li class="list-group-item mb-1">
						<a href="#" onclick="reproducir('${v.idVideo}')">${v.nombre}</a>
						<a href="?id=${v.id}" style="color: red;" class="float-right fas fa-trash-alt"></a>
						<a onclick="showModalModificar('${v.idVideo}' , '${v.nombre}')" style="color:grey;" class="float-right fas fa-pencil-alt mr-2"></a>	
				</li>
              </c:forEach>        
            
          </ul>
          
         <!-- modalModificar -->
			<div class="modal fade" id="modalModificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Modificar Video</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        
			      </div>
			      <div class="modal-footer">			  
			      
			      	<form action="inicio" method="post">			      		
			      		<input type="text" id="nombre" name="nombre" required >
			      		<input type="text" name="idVideo" id="idVideo" required >
			      		<input type="hidden" name="id" id="id" value="-1">
			      		<input type="submit" value="Modificar">
			      	</form>
			      
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			        			        
			      </div>
			    </div>
			  </div>
			</div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div class="card mt-4">
          <!-- =videoInicio.getIdVideo() -->
            <iframe id="iframe" width="823" height="415" src="https://www.youtube.com/embed/${v[0].id}" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
                        
            <div class="card-body">
              <h3 class="card-title">${v[0].nombre}</h3>              
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>
          <!-- /.card -->

          <div class="card card-outline-secondary my-4">
            <div class="card-header">
              Comentarios
            </div>
            <div class="card-body">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              <hr>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              <hr>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              
            </div>
          </div>
          <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->
    
    <%@ include file="includes/footer.jsp" %>	
    

