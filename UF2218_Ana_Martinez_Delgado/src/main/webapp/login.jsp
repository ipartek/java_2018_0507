<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp" %>
<center>
<div class="container">
  <div class="row">
    <div class="Absolute-Center is-Responsive">

      <div class="col-sm-4 col-md-4 col-md-offset-1">
        <form action="login" method="post">
          <div class="form-group input-group inline">
           
            <input class="form-control" type="text" name='nick' id="nick" placeholder="nick"/>          
          </div>
          <div class="form-group input-group">
            
            <input class="form-control" type="password" name='password' placeholder="password"/>     
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
<%@ include file="/WEB-INF/includes/pie.jsp" %>