

<%@ include file="includes/header.jsp" %>	
<%@ include file="includes/nav.jsp" %>	
   

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3">        	
          <h1 class="my-4">Lista Reproduccion</h1>
          <ul class="list-group">
          	<%
          		ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
          	
          		Video videoInicio = new Video();
          		if ( !videos.isEmpty() ){
          			videoInicio = videos.get(0);
          		}	
    			
          		for( Video v : videos ){
          	%>      	  
          	  
          	  <li class="list-group-item mb-1">
						<a href="#" onclick="reproducir('<%=v.getIdVideo()%>')"><%=v.getNombre()%></a>
						<a href="?id=<%=v.getId()%>" style="color: red;" class="float-right fas fa-trash-alt"></a>
						<a href="" style="color: grey;" class="float-right fas fa-pencil-alt mr-3"></a>
						<a onclick="showModalModificar('<%=v.getId()%>' , '<%=v.getNombre()%>')" style="color:blue;" class="float-right fas fa-pencil-alt"></a>
						
				</li>
            
            <%
          		} //end for
            %>
            
            
          </ul>
          
         <!-- modalModificar -->
			<div class="modal fade" id="modalModificar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Modificar Nombre Video</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        
			      </div>
			      <div class="modal-footer">
			      
			      	<form action=" ???? " method="post">			      		
			      		<input type="text" id="nombre" name="nombre" required >
			      		<input type="hidden" name="id" id="id" value="-1">
			      		<input type="hidden" name="op" value=" ???? ">
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
          
            <iframe id="iframe" width="823" height="415" src="https://www.youtube.com/embed/<%=videoInicio.getIdVideo()%>" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
            
            <div class="card-body">
              <h3 class="card-title"><%=videoInicio.getNombre()%></h3>              
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
    

