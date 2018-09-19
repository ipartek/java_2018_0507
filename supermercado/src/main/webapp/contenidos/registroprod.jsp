<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel=stylesheet href="../css/bootstrap.min.css">
    <link rel=stylesheet href="../css/estilos.css">
    <link rel="stylesheet" href="css/fonts.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="shortcut icon" href="../imgs/favicon.ico" />
    <title>Supermercado Ana</title>
</head>

<body>
    <div class="jumbotron">
      <h1>Supermercado Ana</h1> 
    </div>
  
    <jsp:include page="menuprincipal.jsp" />
    
	  <div id="contenedor">
      
     <h1>Registrar producto</h1>
	  <div align="center">
      
      
     
        <form action="../RegistroProdServlet" method="post" name="formularioReg"> 
            <label for="nombre">Nombre del producto</label> 
                <input id="nombre" type="text" name="nombre" pattern="[A-Za-zñÑáéíóúÁÉÍÓÚ ]{2,20}"  placeholder="Entre 2 y 20 caracteres"/><br>
            
            <br><label for="precio">Precio</label> 
                <input id="precio" type="number" name="precio"/>
             
             <br><label for="descuento">Descuento</label> 
                <input id="descuento" type="number" name="descuento"/>
               
                <button type="button" class="btn btn-default" aria-label="Left Align">
			  	<span class="glyphicon glyphicon-euro" aria-hidden="true"></span>
				</button>
                
                <br>
            <br><label for="categoria">Categoria</label> 
                <input  id="categoria" type="text" name="categoria" pattern="[A-Za-zñÑáéíóúÁÉÍÓÚ ]{2,20}"  placeholder="Entre 2 y 20 caracteres"/><br>
            <br><input class="btn btn-primary" type="submit" value="Submit">            
        
        </form> 
        
    </div>
      
    </div>
</body>

<footer>
  <div id="pie">
       <i class="fas fa-envelope"></i>
        <p>Mail <a href="mailto:mail@mail.com"> mail@mail.com</a>.</p>
       <div id="iconredsocial">
           <img class="redsocial" src="../imgs/facebook.png" width="30px">
           <img class="redsocial" src="../imgs/twiter.png" width="30px">
           <img class="redsocial" src="../imgs/insta.jpg" width="30px">
       </div>
       <div >&copy;</div>
       <a href="politicapriva.html">Politica de privacidad - </a>
       <a href="contacto.html">Contacto - </a>
       <a href="localizacion.html">Localizacion</a>
   
   </div>
</footer>

</html>