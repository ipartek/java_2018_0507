<div class="col-md-3">
<c:if test="${not empty user.nombre}">
    <p>Bienvenido ${user.nombre}</p>
</c:if>
<p><a href="login.jsp">Login</a></p>
<p><a href="logout">Logout</a></p>
</div>
</div> <!-- Cierre row -->