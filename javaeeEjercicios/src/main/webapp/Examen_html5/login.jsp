<%@ include file="cabecera.jsp" %>

<%@ include file="navbar.jsp" %>

	<div class="row">
		<div class="col-md-9" id="div_contenido">
		  	<div class="col-md-4"></div>
	<div class="col-md-4">
		<jsp:useBean id="login" scope="request" class="com.ipartek.javaeeEjercicios.pojos.Usuario" />
	    <form class="form-horizontal" action="login" method="post">
	        <div class="form-group">
	            <label for="inputEmail" class="col-sm-2 control-label">Email</label>
	            <div class="col-sm-10">
	                <input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email">
	            	<span class="errorTexto">
                    	<jsp:getProperty property="errorEmail" name="login"/>
                    </span>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="inputPassword" class="col-sm-2 control-label">Password</label>
	            <div class="col-sm-10">
	                <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Password">
	            	<span class="errorTexto">
                    	<jsp:getProperty property="errorPassword" name="login"/>
                    </span>
	            </div>
	        </div>
	        <div class="form-group">
	            <div class="col-sm-offset-2 col-sm-10">
	                <div class="checkbox">
	                    <label>
	                        <input type="checkbox" name="checkRemember"> Remember me
	                    </label>
	                </div>
	            </div>
	        </div>
	        <div class="form-group">
	            <div class="col-sm-offset-2 col-sm-10">
	                <button type="submit" class="btn btn-default">Sign in</button>
	            </div>
	        </div>
	    </form>
	</div>
	<div class="col-md-4"></div>
</div>
	
<%@ include file="submenuDer.jsp" %>    

<%@ include file="pie.jsp" %>




