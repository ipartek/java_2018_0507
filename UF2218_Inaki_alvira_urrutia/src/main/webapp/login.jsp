<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/includes/cabecera.jsp"%>
<header>
	<h1>login</h1>
</header>
<div class="container">
<h1 class="form-heading">Admin login</h1>
<div class="login-form">
<div class="main-div">
    <div class="panel">
   <h2>Admin Login</h2>
   <p>Usuario y contraseña</p>
   </div>
    <form action="login" method="post" >

        <div class="form-group">


            <input type="email" class="form-control" id="inputEmail" name="email" placeholder="Email Address">
		<span>${usuario.errorEmail}</span>
        </div>

        <div class="form-group">

            <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
	<span>${usuario.errorPassword}</span>
        </div>
  
        <button type="submit" class="btn btn-primary">Login</button>

    </form>
    </div>
</div></div>
<%@ include file="WEB-INF/includes/pie.jsp"%>