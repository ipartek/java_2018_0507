<%@page import = "com.ipartek.javaeeEjercicios.accesodatos.ProductosArrayDAO" %>
<div>
<section id="seccionPrincipal">
	<h3>Sección principal</h3>
	
		<div class="input-group" id="capaBuscador">
	     <input type="text" class="form-control" placeholder="Buscar...">
	     <span class="input-group-btn">
	       <button class="btn btn-primary" type="button">Buscar</button>
	     </span>
	   </div>
	<table class="table table-condensed table-bordered table-striped table-hover table-primary">
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>NOMBRE</th>
	            <th>CATEGORIA</th>
	            <th>DESCRIPCION</th>
	            <th>PRECIO BASE</th>
	            <th>DESCUENTO</th>
	            <th>PRECIO FINAL</th>
				<th></th>
	        </tr>
	    </thead>
	    <tbody>
	    <% 
        for (int i = 0; i < ProductosArrayDAO.getInstance().getAll().size(); i++){  %>
        
            <tr>
                <td class="text-center"><%= i + 1 %></td>
                <td><%=ProductosArrayDAO.getInstance().getAll().get(i).getNombre() %></td>
                <td><%=ProductosArrayDAO.getInstance().getAll().get(i).getCategoria() %></td>
                <td><%=ProductosArrayDAO.getInstance().getAll().get(i).getDescripcion() %></td>
                <td><%=ProductosArrayDAO.getInstance().getAll().get(i).getPrecio() %>.
                <%=ProductosArrayDAO.getInstance().getAll().get(i).getDecimal() %></td>
                <td><%=ProductosArrayDAO.getInstance().getAll().get(i).getDescuento() %> %</td>
                <td><%=ProductosArrayDAO.getInstance().getAll().get(i).getPrecioTotal() %> %</td>
                <td>
	            	<div class="btn-group  btn-group-sm" role="group" aria-label="...">
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Borrar</button>
					</div>
				</td>
            </tr>
            <%} %>
	        <!-- <tr>
	            <td>1</td>
	            <td>Vodka Beefeater</td>
	            <td>Bebidas</td>
	            <td>BEEFEATER ginebra inglesa botella 70cl</td>
	            <td>13.35</td>
	            <td>20</td>
	            <td>12.95</td>
	            <td>
	            	<div class="btn-group  btn-group-sm" role="group" aria-label="...">
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Borrar</button>
					</div>
				</td>
	        </tr>
	        <tr class="success">
	            <td>2</td>
	            <td>Vodka Beefeater</td>
	            <td>Bebidas</td>
	            <td>BEEFEATER ginebra inglesa botella 70cl</td>
	            <td>13.35</td>
	            <td>20</td>
	            <td>12.95</td>
	            <td>
	            	<div class="btn-group  btn-group-sm" role="group" aria-label="...">
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Borrar</button>
					</div>
				</td>
	        </tr>
	        <tr>
	            <td>3</td>
	            <td>Vodka Beefeater</td>
	            <td>Bebidas</td>
	            <td>BEEFEATER ginebra inglesa botella 70cl</td>
	            <td>13.35</td>
	            <td>20</td>
	            <td>12.95</td>
	            <td>
	            	<div class="btn-group  btn-group-sm" role="group" aria-label="...">
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Borrar</button>
					</div>
				</td>
	        </tr> 
	        <tr class="success">
	            <td>4</td>
	            <td>Vodka Beefeater</td>
	            <td>Bebidas</td>
	            <td>BEEFEATER ginebra inglesa botella 70cl</td>
	            <td>13.35</td>
	            <td>20</td>
	            <td>12.95</td>
	            <td>
	            	<div class="btn-group  btn-group-sm" role="group" aria-label="...">
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Borrar</button>
					</div>
				</td>
	        </tr>
	        <tr>
	            <td>5</td>
	            <td>Vodka Beefeater</td>
	            <td>Bebidas</td>
	            <td>BEEFEATER ginebra inglesa botella 70cl</td>
	            <td>13.35</td>
	            <td>20</td>
	            <td>12.95</td>
	            <td>
	            	<div class="btn-group  btn-group-sm" role="group" aria-label="...">
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Borrar</button>
					</div>
				</td>
	        </tr>
	        <tr class="success">
	            <td>6</td>
	            <td>Vodka Beefeater</td>
	            <td>Bebidas</td>
	            <td>BEEFEATER ginebra inglesa botella 70cl</td>
	            <td>13.35</td>
	            <td>20</td>
	            <td>12.95</td>
	            <td>
	            	<div class="btn-group  btn-group-sm" role="group" aria-label="...">
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Borrar</button>
					</div>
				</td>
	        </tr>
	        <tr>
	            <td>7</td>
	            <td>Vodka Beefeater</td>
	            <td>Bebidas</td>
	            <td>BEEFEATER ginebra inglesa botella 70cl</td>
	            <td>13.35</td>
	            <td>20</td>
	            <td>12.95</td>
	            <td>
	            	<div class="btn-group  btn-group-sm" role="group" aria-label="...">
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Borrar</button>
					</div>
				</td>
	        </tr>
	        <tr class="success">
	            <td>8</td>
	            <td>Vodka Beefeater</td>
	            <td>Bebidas</td>
	            <td>BEEFEATER ginebra inglesa botella 70cl</td>
	            <td>13.35</td>
	            <td>20</td>
	            <td>12.95</td>
	            <td>
	            	<div class="btn-group  btn-group-sm" role="group" aria-label="...">
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Borrar</button>
					</div>
				</td>
	        </tr> -->
	    </tbody>
	</table>
		<nav aria-label="Productos" class="text-center">
		    <ul class="pagination pagination-sm">
		        <li>
		            <a href="#" aria-label="Previous">
		                <span aria-hidden="true">&laquo;</span>
		            </a>
		        </li>
		        <li class="active">
		            <a href="#">1 <span class="sr-only">(current)</span></a>
		        </li>
		        <li><a href="#">2</a></li>
		        <li><a href="#">3</a></li>
		        <li><a href="#">4</a></li>
		        <li>
		            <a href="#" aria-label="Next">
		                <span aria-hidden="true">&raquo;</span>
		            </a>
		        </li>
		    </ul>
		</nav>
	</section>
</div>
