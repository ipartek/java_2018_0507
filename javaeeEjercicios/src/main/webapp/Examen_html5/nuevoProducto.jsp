<div class="col-md-3"></div>
<div class="col-md-6">
	<seccion id="registro">
		<h3>Nuevo producto</h3>
	    <form class="form-horizontal" action="InsertarArticulosServlet" method="post">
	        <div class="form-group">
	            <label for="inputNombre">Nombre producto</label>
	            <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre (Mínimo 2, máximo 20)" minlength=2 maxlength=20 required>
	        </div>
	        <div class="form-group">
	            <label for="inputCategoria">Categoria</label>
	            <select class="form-control" name="inputCategoria">
	              <option value="0" selected>Seleccione una categoría</option>
				  <option value="Bebida">Bebida</option>
				  <option value="Fruta">Fruta</option>
				  <option value="Carne">Carne</option>
				  <option value="Pescado">Pescado</option>
				  <option value="Otros">Otros</option>
				</select>
	        </div>
	        <div class="form-group">
	            <label for="inputDescripcion">Descripción producto</label>
	            <textarea id="textareaNuevoProducto" name="textareaDescripcion" class="form-control" rows="3" placeholder="Descripción producto (Mínimo 5 , máximo 100)" minlength=5 maxlength=100 required></textarea>
	        </div>
	        <div class="form-group">
	        	<label for="exampleInputAmount">Precio</label>
			    <label class="sr-only" for="exampleInputAmount">Precio (en euros)</label>
			    <div class="input-group">
			      	<input type="number" class="form-control" id="exampleInputAmount" name="inputPrecio" placeholder="Cantidad" min="1" max="1000" step="1" required>
			      	<div class="input-group-addon">.</div>
			      	<input type="number" class="form-control" id="exampleInputAmount2" name="inputDecimal" placeholder="Decimal" min="0" max="99" step="1">
			    	<div class="input-group-addon">€</div>
			    </div>
			 </div>
	        
	        <div class="form-group">
	            <label for="inputDescuento">Descuento</label>
	            <div class="input-group">
		            <input type="number" class="form-control" id="inputDescuento" name="inputDescuento" placeholder="Descuento" min="0" max="100" required>
		        	<div class="input-group-addon">%</div>
		        </div>
	        </div>
	        
	        <div class="form-group">
	        	<label for="inputPrecioFinal">Precio Final contando descuento</label>
	        	<div class="input-group">
	        		<input type="number" class="form-control" id="inputPrecioFinal" readonly>
	        		<div class="input-group-addon">€</div>
	        	</div>
	        </div>
	        <div class="form-group text-center">
	            <button type="submit" class="btn btn-primary">Aplicar y aceptar</button>
	            <button class="btn btn-primary"><a href="index.jsp" alt="Cancelar" id="botonCancelarProducto">Cancelar</a></button>
	        </div>
	    </form>
    </seccion>
</div>
<div class="col-md-3"></div>