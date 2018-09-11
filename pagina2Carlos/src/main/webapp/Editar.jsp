<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, user-scalable=no" />
<title>Editar</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/estiloEditar.css" />
	<script src="js/jquery-1.12.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<header><h1>LIBROS</h1></header>
</head>
<body>
    <div class="container-fluid">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-12" >
								<p class="text-center">Modificar/Añadir</p>
							</div>
						</div>
						<hr>
					</div>
               <div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<form id="login-form" action="#" method="post" role="form" style="display: block;">
								<div class="row  editar"    ></div>
									<div class="form-group">
									<div class="col-md-2 etiquetas">Id</div>
									<div class="col-md-9">
										<input type="text" name="ID" id="id" tabindex="1" class="form-control" placeholder="Introduzca Id..." value="">
                                        </div>
                                    </div>
                                    <div class="row editar"></div>
									<div class="form-group">
									<div class="col-md-2 etiquetas">Titulo</div>
									<div class="col-md-9">
										<input type="text" name="Titulo" id="titulo" tabindex="2" class="form-control" placeholder="Introduzca titulo..." value="">
                                        </div>
                                    </div>
                                    <div class="row  editar"></div>
									<div class="form-group">
									<div class="col-md-2 etiquetas">Autor</div>
									<div class="col-md-9">
										<input type="text" name="Autor" id="autor" tabindex="2" class="form-control" placeholder="Introduzca autor..." value="">
                                        </div>
                                    </div>
                                    <div class="row editar"></div>
									<div class="form-group">
									<div class="col-md-2 etiquetas">Editorial</div>
									<div class="col-md-9">
										<input type="text" name="Editorial" id="editorial" tabindex="3" class="form-control" placeholder="Introduzca editorial..." value="">
                                        </div>
                                    </div>
                                    <div class="row editar"></div>
									<div class="form-group">
									<div class="col-md-2 etiquetas">Precio</div>
									<div class="col-md-9">
										<input type="text" name="Precio" id="precio" tabindex="4" class="form-control" placeholder="Introduzca precio..." value="">
                                        </div>
                                    </div>
                                    <div class="form-group">
										<div class="row">
											<div class="col-md-6 etiquetas">
												<input type="submit" name="Aceptar-submit" id="aceptar-submit" tabindex="4" class="form-control btn btn-primary" value="Aceptar">
											</div>
											<div class="col-md-6 etiquetas boton">
												<input type="submit" name="Cancelar-submit" id="cancelar-submit" tabindex="4" class="form-control btn btn-primary" value="Cancelar">
											</div>
										</div>
                                    </div>
								</form>
							</div>
						</div>
					</div>
                </div>
            </div>
            
        </div>
    </div>
</body>
</html>