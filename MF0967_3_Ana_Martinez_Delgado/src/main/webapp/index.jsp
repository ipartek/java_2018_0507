<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head><link rel="stylesheet" href="css/bootstrap.min.css" /></head>
  <%@ page import="com.ipartek.formacion.MF0967.pojo.Perro" %>
<body>
<%@ include file="contenidos/cab.jsp" %>
 
<a href="login.jsp" class="btn btn-primary" >Login</a>

<center>
<%= request.getAttribute("perros") %>





	<c:forEach items="${perro}" var="current">
        <tr>
          <td><c:out value="${current.nombreperro}" /><td>
       
        </tr>
      </c:forEach>

<div class="container">
  <div class="row">
    <div class="Absolute-Center">

    
        <form action="altaPerro" method="post">
          <div class="form-group input-group inline">
<input class="form-control" type="text" id="nombreperro" name="nombreperro" placeholder="nombreperro"/>
<input class="form-control" type="text" id="edad" name="edad" placeholder="edad" pattern="[1-9]{2}"/> 
<input class="form-control" type="text" id="raza" name="raza" placeholder="raza"/> 
<input class="form-control" type="text" id="peso" name="peso" placeholder="peso"/> 
<input class="form-control" type="text" id="apadrinado" name="apadrinado" placeholder="apadrinado"/> 
<input class="form-control" type="text" id="chip" name="chip" placeholder="chip" />  <!-- DD-DDDD-AAAA ( D: numero del 0 al 9, AAAA año del chip ) -->
  
           
          </div>
         <button class="btn btn-primary">Enviar</button>
        </form>        
     
    </div>    
  </div>
</div>
</div>

</center>
</body>
</html>