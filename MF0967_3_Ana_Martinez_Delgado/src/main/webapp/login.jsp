<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <html>
    <head><link rel="stylesheet" href="css/bootstrap.min.css" /></head>
    <body>
      
     
<center>
<%@ include file="contenidos/cab.jsp" %>

<div class="container">
  <div class="row">
    <div class="Absolute-Center">

      <div class="col-sm-4 col-md-4 col-md-offset-1">
        <form action="login" method="post">
          <div class="form-group input-group inline">
           
            <input class="form-control" type="text" name='usuario' id="usuario" placeholder="usuario"/>          
          </div>
          <div class="form-group input-group">
            
            <input class="form-control" type="password" name="password" placeholder="password"/>     
          </div>
         
          <div class="form-group">
           <button class="btn btn-primary">Login</button>
          </div>
         
        </form>        
     
    </div>    
  </div>
</div>
</div>
</center>
</body>
</html>