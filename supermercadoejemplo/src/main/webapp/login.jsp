<%@include file="/WEB-INF/includes/cabecera.jsp"%>

<header>
	<h1>Login</h1>
</header>

<form action="#">
	<p>
		<label for="email">Usuario</label> 
		<input type="email" name="email"id="email" />
	</p>
	<p>
		<label for="password">Contraseña</label> 
		<input type="password" name="password" id="password" />
	</p>
	<p>
		<button>Login</button>
	</p>
</form>

<%@include file="/WEB-INF/includes/pie.jsp"%>