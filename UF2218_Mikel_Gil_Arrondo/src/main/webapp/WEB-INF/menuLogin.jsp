<div class="col-md-3">
<c:if test="${not empty sessionScope.user}">
    <p>Bienvenido ${sessionScope.user.nombre}</p>
</c:if>
<p><a href="login">Login</a></p>
<p><a href="logout">Logout</a></p>
</div>
</div> <!-- Cierre row -->