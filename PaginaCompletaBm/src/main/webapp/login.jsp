<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/index.css" />
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

<body class="container-fluid">
<jsp:useBean id="error" scope="request"  class="com.ipartek.supermercado.pojo.Errores"/>
    <header>
        <div class="row ">
            <div class="miCab col-md-12 text-center"><img src="imgs/descarga1.png" height="100px" width="200px" alt="Este es el ejemplo de un texto alternativo"></div>
        </div>
        <div class="row">
            <nav class="navbar navbar-inverse">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">BM</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="login.jsp">Login<span class="sr-only">(current)</span></a></li>
                        <li><a href="regProd.html">registrar Producto</a></li>
                        <li><a href="listado.jsp">listado productos</a></li>
                            <li><a href="regUsuarios.jsp">reg usuarios</a></li>
                    </ul>
                    <div class="row">
                        <form class="miCuadro navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="buscar">
                            </div>
                            <button type="submit" class="btn btn-default">Buscar</button>
                            
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    </header>
    <form class="form-horizontal" action="usuario"   method="post">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-offset-1 col-sm-2 control-label">Email</label>
            <div class="col-sm-8">
                <input type="email" class="form-control" name="mail" id="inputEmail3" placeholder="Email" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-offset-1 col-sm-2 control-label">Password</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="Password" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-8">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" value="login" name="login" class="btn btn-default">login</button>
               <jsp:getProperty property="error" name="error"/>
            </div>
        </div>
    </form>
   <footer>
        <div class="row">
            <div class="col-md-2 col-xs-6 text-center"><img src="imgs/fb.png" height="50" width="50" alt="Este es el ejemplo de un texto alternativo"></div>
            <div class="col-md-2 col-xs-6 text-center"><img src="imgs/twitter2.png" height="50" width="50" alt="Este es el ejemplo de un texto alternativo"></div>
            <div class="col-md-2 col-xs-12"><a href="#">Politica de Privacidad</a></div>
            <div class="col-md-2 col-xs-12 "><a href="#">Contacto</a></div>
            <div class="col-md-2 col-xs-12"><a href="#">localicacion</a></div>
            <div class="micop col-md-2 col-xs-12">&copy;2018</div>
        </div>
    </footer>

</body>
</html>
    