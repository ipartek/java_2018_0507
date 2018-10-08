<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
 <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" />
      <link rel="stylesheet" href="css/login.css" />
    <link rel="stylesheet" href="css/index.css" />
    <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

<body class="container-fluid">
    <header>
        <div class="row ">
            <div class="miCab col-md-12 text-center"><img src="imgs/txar.png" height="200px" width="200px" alt="Este es el ejemplo de un texto alternativo"></div>
        </div>
        <div class="row">
            <nav class="navbar navbar-inverse">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">Txarkur-Etxe</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
 
                    <c:if test="${sessionScope.usuario==null}">
                        <li><a href="login.jsp">Login<span class="sr-only">(current)</span></a></li>
                          <li><a href="inicio">inicio<span class="sr-only">(current)</span></a></li>
                     </c:if>
                     <c:if test="${sessionScope.usuario!=null}">
                        <li><a href="edicionPerros.jsp">añade perro<span class="sr-only">(current)</span></a></li>
                         <li><a href="inicio">inicio<span class="sr-only">(current)</span></a></li>
                        <li><a href="login?logout=true">logout<span class="sr-only">(current)</span></a></li>
                     </c:if>
                    </ul>
                    <div class="row">
                        <form action="buscar" method="get" class="miCuadro navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" name="buscar" class="form-control" placeholder="buscar">
                            </div>
                            <button type="submit" class="btn btn-default">Buscar</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
 </header>       