<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Formulario</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

        <div class="contenedor">

            <header>
        
                <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                    <a class="navbar-brand" href="index.html"><img src="images/logo.jpg" alt="logotipo-supermercado-el-fuerte" /></a>
                
                    <div class="navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav mr-auto menu">
                
                            <li class="nav-item">
                                <a class="nav-link" href="index.html">Principal <span class="sr-only">(current)</span></a>
                            </li>
                
                            <li class="nav-item">
                                <a class="nav-link" href="login.html">Login</a>
                            </li>
                
                            <li class="nav-item">
                                <a class="nav-link" href="alta-pagina.html">Nueva Pagina</a>
                            </li>
                
                            <li class="nav-item">
                                <a class="nav-link" href="listado.html">Listado</a>
                            </li>
                
                        </ul>
                    </div>
                
                </nav>
                
            </header>

            <main role="main" class="container">

                <h1><i class="fas fa-archive"></i> Alta de pagina</h1>
                
            
                <form method="post" class="form-alta-producto">

                    <div class="form-row">
                            
                        <div class="form-group col">
                            <label for="nom" class="required">Nombre de la pagina:</label>
                            <input type="text" class="form-control" id="nom" name="nombre" minlength="5" maxlength="20" required autofocus placeholder="De 5 a 20 caracteres" />
                        </div>                  
                            
                    <div class="form-group">
                        <label for="desc">Descripción:</label>
                        <textarea id="desc" class="form-control" name="descripcion" placeholder="Inserte aqui el texto a introducir en el libro" rows="3" /></textarea>
                    </div>


                    <button type="submit" class="btn btn-outline-primary btn-block">Escribir pagina en el libro</button>

                </form>
                
            </main>

            <footer>

                <div>
                    <p>&copy; Pablo Martin 2018</p>
                </div>
            
                <nav>
                    <a href="#">Politica de privacidad</a>
                    <a href="#">Contacto</a>
                    <a href="#">Localización</a>
                </nav>
            
                <div class="social">
                    <a href="https://es-es.facebook.com/" id="facebook" target="_blank"><i class="fab fa-facebook-square fa-3x"></i></a>
                    <a href="https://twitter.com/?lang=es" id="twitter" target="_blank"><i class="fab fa-twitter-square fa-3x"></i></a>
                </div>
            
            </footer>

        </div> <!-- ./contenedor -->
    
</body>
</html>