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
    
	  <form>
        <fieldset>
            <legend>Login de usuario</legend>
           
            <label for="usuario">Usuario: </label>
               <input type="text" id="usuario" name="usuario" placeholder="usuario"
                min="3" />

            <label for="contraseña">Contraseña: </label>
               <input type="text" id="contrasena" name="contrasena" placeholder="contrasena"
                min="3" />
                <br>
            <button type="button" class="btn btn-success">Aceptar</button>
            
        </fieldset>
    </form>
		
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