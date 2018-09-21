<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="WEB-INF/includes/cabecera.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<jsp:useBean id="login" scope="request" class="libros.modelos.LoginForm" />
   
    
    <div class="col-md-8">

<div class="jumbotron">
  <form action="login" method="post">
        <fieldset>
            <legend>Login</legend>
            <p>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre" 
                	value='<jsp:getProperty property="nombre" name="login"/>' />
                
                <span class="errorTexto">
                	<jsp:getProperty property="errorNombre" name="login"/>
                </span>
            </p>
            <p>
                <label for="password">Contraseña</label>
                <input type="password" name="password" id="password" />
                
                <span class="errorTexto">
                	<jsp:getProperty property="errorPassword" name="login"/>
                </span>
                <%-- <jsp:getProperty property="password" name="login"/> --%>
            </p>
            <p>
                <button>Login</button>
                <span class="errorTexto">
                	<jsp:getProperty property="mensajeError" name="login"/>
                </span>
            </p>
        </fieldset>
    </form>
    
</div>
</div>
    
<%@ include file="WEB-INF/includes/anuncios.jsp" %>
<%@ include file="WEB-INF/includes/pie.jsp" %>


