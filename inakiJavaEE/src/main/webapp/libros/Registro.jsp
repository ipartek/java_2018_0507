<%@ include file="cabecera.jsp" %>
		<div class="container">		
	            <div class="col-md-6">
				<div class="main-login">
					<form class="form-horizontal" method="post" action="#">
						
						<div class="form-group">
							<label for="name" class="col-md-4 control-label">Nombre</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name"  placeholder="introduce tu nombre"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-4 control-label">Email</label>
							<div class="col-sm-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email"  placeholder="introduce tu mail"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="col-sm-4 control-label">Nombre de usuario</label>
							<div class="col-sm-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="introduce tu usuario"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="direccion" class="col-sm-4 control-label">Direccion</label>
							<div class="col-sm-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-home" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="introduce tu direccion"/>
								</div>
							</div>
						</div>


						<div class="form-group">
							<label for="password" class="col-sm-4 control-label">contraseña</label>
							<div class="col-sm-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-asterisk" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="mete tu contraseña"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="col-sm-4 control-label">Confirma la contraseña</label>
							<div class="col-sm-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-asterisk" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Repite la contraseña"/>
								</div>
							</div>
						</div>

						<div class="form-group ">
						<div class="row">
                       <div class="col-sm-3"></div>
                       <div class="col-sm-6"><button type="button" class="btn btn-primary btn-lg btn-block login-button">Registrarse</button></div>
                       <div class="col-sm-3"></div>
                        </div>
							
						</div>
						<div class="login-register text-center">
				            <a href="index.php">Login</a>
				         </div>
					    </form>
				    </div>
				</div>
				  <div class="col-sm-3"></div>
			</div>
		</div>

		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
	<%@ include file="footer.jsp" %>