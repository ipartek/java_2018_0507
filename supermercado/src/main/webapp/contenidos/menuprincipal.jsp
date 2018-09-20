


	<nav class="menuprincipal">
	
	<div class="UsuarioLoggueado">
		<%String usuarioRecib = (String)session.getAttribute("usuario");%>
		<%=usuarioRecib %>
		<a href="../UserLogout">Desconectar</a>
		
		
	</div>

	
	
        <ul>
           <li><a href="../index.jsp">Inicio</a></li>
            <li><a href="bebidas.jsp">Bebidas</a></li>
            <li><a href="aperitivos.jsp">Aperitivos</a></li>
            <li><a href="contacto.jsp">Contacto</a></li>
            <li><a href="registroprod.jsp">Registro Producto</a></li>
            <li><a href="../ListadoProdServlet">Lista de Productos</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="../VerCarrito">Carrito</a></li>
            
            
           <div class="input-group" >
              <span class="input-group-addon"><img src="../imgs/lupa.png" width="20px"></span>
              <input type="text" class="form-control">
              <span class="input-group-addon">Buscar</span>
            </div> 
        </ul>
    </nav>