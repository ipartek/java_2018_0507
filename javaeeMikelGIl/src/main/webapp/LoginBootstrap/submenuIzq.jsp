<jsp:useBean id="datosLogin" scope="request" class="com.ipartek.formacion.javaee.libros.modelos.Login" />

<div class="row">
	<div class="col-md-3">
		<div class="page-header">
			<div class="panel panel-warning">
	          <div class="panel-heading">
	            	<h3 class="panel-title">Bienvenido</h3>
	          </div>
	          <div class="panel-body">
	            	<p><strong>Email: </strong><jsp:getProperty name="datosLogin" property="email" /><br />
	            	<strong>Password: </strong><jsp:getProperty name="datosLogin" property="password" />
	            	</p>
	          </div>
        	</div>
	    </div>
	    
	    <div class="page-header">
	        <h3>Submenu izquierda</h3>
              <div class="alert alert-dismissible alert-warning">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <h4>Warning!</h4>
                <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. 
                Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</p>
              </div>
	    </div>
	</div>

      