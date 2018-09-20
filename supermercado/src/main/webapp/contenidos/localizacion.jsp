<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
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
    
    <br><br>
     <div id="mapa">
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2905.762267202258!2d-2.9135920000000017!3d43.25640399999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd4e4fb46238d865%3A0xb671edfb1120ab06!2sIpartek+Servicios+Inform%C3%A1ticos!5e0!3m2!1ses!2ses!4v1536925453902" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
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
       <a href="politicapriva.jsp">Politica de privacidad - </a>
      <a href="contacto.jsp">Contacto - </a>
       <a href="localizacion.jsp">Localizacion</a>
   
   </div>
</footer>

      
  
  
 
</body>

</html>