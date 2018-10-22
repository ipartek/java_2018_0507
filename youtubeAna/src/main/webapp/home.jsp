<%@page import="com.ipartek.formacion.youtube.Video"%>
<%@page import="com.ipartek.formacion.youtube.Comentario"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="en">

  <head>

	<base href="<%=request.getContextPath()%>/">
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Youtube Video Play List</title>

	<link rel="stylesheet" href="css/all.css">
	
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
      <!--  link href="css/bootstrap.min.css" rel="stylesheet"-->
    <link href="css/shop-item.css" rel="stylesheet">
   

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Youtube PlayList</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <form action="anadir" method="post" class="form-inline mt-2 mt-md-0">
	            <input name="id" class="form-control mr-sm-2" type="text" placeholder="ID 11 caracerteres" title="11 caracteres" required pattern=".{11}">
	            <input name="nombre" class="form-control mr-sm-2" type="text" placeholder="Nombre minimo 2 letras" required pattern=".{2,125}">
	            <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Añadir</button>
	            <!--  a class="btn btn-outline-info my-2 my-sm-0" href="?&action=insert">Insertar</a-->
	          </form>
			        
		     </li>  
		     <li class="nav-item active">
		     <font color="white">
			     <form class="form-inline" action="logout" method="post">
	  					 Bienvenido usuario <%=session.getAttribute("email") %>
	  					  <button type="submit" class="btn btn-default">Logout</button>
	  			 </form>
  			</font>
			 <form class="form-inline" action="login" method="post">
		         <input name="email" id="email" class="form-control mr-sm-2" type="text" placeholder="email" >
	             <input name="pass" id="pass" class="form-control mr-sm-2" type="text" placeholder="contrasena" >
	          
				  <button type="submit" class="btn btn-default">Login</button>
				</form>
		     
		     </li>          
          </ul>
          
         
		          
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">



        <div class="col-lg-3">        	
          <h1 class="my-4">Lista Reproduccion</h1>
          <div class="list-group">
          	<%
          		ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
          	
          		Video videoInicio = new Video();
          		if ( !videos.isEmpty() ){
          			videoInicio = videos.get(0);
          		}	
    			
          		for( Video v : videos ){
          	%>
                   
          	  <a href="#" onclick="reproducir('<%=v.getIdVideo()%>');return false;" class="list-group-item"><%=v.getNombre()%></a>
          	     <form action="" method="post" class="form-inline mt-2 mt-md-0">
          	  		<a href="?id=<%=v.getId()%>&action=delete"><span class="glyphicon glyphicon-remove">Borrar</span></a>	
          	  	</form>
            
            <%
          		} //end for
            %>
            
            
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
          
          
          <div class="card-body">
          
          
		  <form action="comentario" method="post" >
			  <div class="form-group">
			    <label for="formGroupExampleInput">Enviar Comentario</label>
			    <input type="text" class="form-control" name="inputcomentario" id="inputcomentario" placeholder="Comentarios">
			    <button>Enviar commentario</button>
			  </div>
		</form>
          </div>
            <div class="card-header">
              Comentarios
            </div>
            <div class="card-body">
          	<%
          		ArrayList<Comentario> comentarios = (ArrayList<Comentario>) request.getAttribute("comentarios");
          	
          		Comentario comentariosInicio = new Comentario();
          		if ( !comentarios.isEmpty() ){
          			comentariosInicio = comentarios.get(0);
          		}	
    			
          		for( Comentario c : comentarios ){
          	 	%>
                   <small class="text-muted">Posted by <%=c.getUsuario()%> on 3/1/17</small>
                  	<p><%=c.getComentario()%>	</p>
                  
          		
          			  <hr>
          	 	 <%
          		} //end for
            %>
          	
          
             
            </div>
          </div>
          <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


	<script>
		function reproducir(id) {
			
			console.info('reproducir video ' + id);
			var iframe = document.getElementById('iframe');
			iframe.src = "https://www.youtube.com/embed/" + id;
			
		}	
	
	</script>

  </body>

</html>
