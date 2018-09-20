<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import="supermercado.pojo.Articulo" %>
<%@ page import="supermercado.accesodatos.ArticuloArrayDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="supermercado.accesodatos.CrudAble" %>
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
  
  
  <table class="table table-striped">
  <tr><th>Nombre</th><th>Precio</th><th>Descuento</th><th>Categoria</th></tr>
  <% CrudAble<Articulo> dao = ArticuloArrayDAO.getInstance();
	
	for(Articulo art: dao.getAll()) {
		//System.out.println("Articulo web: "+art.getCategoria()+" "+art.getDescuento()+" "+art.getId()+" "+art.getNombre()+" "+art.getPrecio());
	
		%>
		<tr>
			<td><%=art.getNombre()%></td>
			<td><%=art.getPrecio()%></td>
			<td><%=art.getDescuento()%></td>
			<td><%=art.getCategoria()%></td></tr>
	
	<%
	}
	 %>

  
  </table>
  
  
  
  
  
  
  
  
  
  
  
  
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

</html>