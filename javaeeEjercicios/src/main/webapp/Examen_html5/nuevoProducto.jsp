<div class="col-md-3"></div>
<div class="col-md-6">
	<seccion id="registro">
		<h3>Nuevo producto</h3>
	    <form class="form-horizontal" action="InsertarArticulosServlet">
	        <div class="form-group">
	            <label for="inputNombre">Nombre producto</label>
	            <input type="text" class="form-control" id="inputNombre" placeholder="Nombre (Mínimo 2, máximo 20)" minlength=2 maxlength=20 required>
	        </div>
	        <div class="form-group">
	            <label for="inputCategoria">Categoria</label>
	            <select class="form-control">
	              <option value="0" selected>Seleccione una categoría</option>
				  <option value="1">Bebida</option>
				  <option value="2">Fruta</option>
				  <option value="3">Carne</option>
				  <option value="4">Pescado</option>
				  <option value="5">Otros</option>
				</select>
	        </div>
	        <div class="form-group">
	            <label for="inputDescripcion">Descripción producto</label>
	            <textarea id="textareaNuevoProducto" class="form-control" rows="3" placeholder="Descripción producto (Mínimo 5 , máximo 100)" minlength=5 maxlength=100 required></textarea>
	        </div>
	        <div class="form-group">
	        	<label for="exampleInputAmount">Precio</label>
			    <label class="sr-only" for="exampleInputAmount">Precio (en euros)</label>
			    <div class="input-group">
			      	<input type="number" class="form-control" id="exampleInputAmount" placeholder="Cantidad" min="1" max="1000" step="1" required>
			      	<div class="input-group-addon">.</div>
			      	<input type="number" class="form-control" id="exampleInputAmount2" placeholder="Decimal" min="0" max="99" step="1">
			    	<div class="input-group-addon">€</div>
			    </div>
			 </div>
	        
	        <div class="form-group">
	            <label for="inputDescuento">Descuento</label>
	            <div class="input-group">
		            <input type="number" class="form-control" id="inputDescuento" placeholder="Descuento" min="0" max="100" required>
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