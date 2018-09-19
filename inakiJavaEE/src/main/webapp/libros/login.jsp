
<%@ include file="cabecera.jsp" %>
<div class="container" id="LoginForm">
<div class="login-form">
<div class="main-div">
    <div class="panel">
   <p>inserte su usuario y contraseña</p>

   </div>

    <form id="Login">
        <div class="form-group">
            <input type="email" class="form-control" id="inputEmail" placeholder="Email o Usuario">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="inputPassword" placeholder="contraseña">
        </div>
        <div class="forgot">
        <a href="reset.html">¿recuperar la contraseña?</a>
</div>

        <button type="submit" class="btn btn-primary">entrar</button>
        <button type="submit" class="btn btn-primary" id="btnReg">Registrarse</button>

    </form>
    </div>

</div></div>
<%@ include file="footer.jsp" %>
