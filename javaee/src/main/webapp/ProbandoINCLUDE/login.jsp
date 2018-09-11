<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="container">
	<div class="col-sm-2">
    <nav class="nav-sidebar">
		<ul class="nav tabs">
          <li class="active"><a href="#tab1" data-toggle="tab">Login</a></li>
          <li class=""><a href="listado.jsp" data-toggle="tab">Listado de Libros</a></li>
          <li class=""><a href="edicion.jsp" data-toggle="tab">Añadir y Editar</a></li>                               
		</ul>
	</nav>
		<div><h2 class="add">Coloque aqui su anuncio!!!!!</h2></div>
</div>
</div>

<div class="tab-content">
<div class="tab-pane active text-style" id="tab1">
  <h2>Login</h2>
       <p>
    <div class="container">	
	<div class="row">

		<div class="col-xs-12 col-sm-7 col-md-7 col-lg-3">
                    <form action="listado.jsp">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Nombre de Usuario</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nombre Usuario">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                      </div>
                      <div class="form-check"> 
                        <button type="submit" class="btn btn-primary">Aceptar</button>
                      </div>
                      
                    </form>
		</div>		
	</div>
	</div>
</div>    
</div>