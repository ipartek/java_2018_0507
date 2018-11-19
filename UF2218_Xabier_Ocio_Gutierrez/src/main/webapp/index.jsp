<html lang="es">
<%@page import="clases.Pagina" %>
<%@page import="clases.Libro" %>
<%@page import="java.util.ArrayList" %>

<head>
    <meta charset="UTF-8">
    <title>LibroWeb</title>
    <!--bootstrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <!--mis ficheros css js -->
    <link rel="stylesheet" href="css/estilos.css" />
    <script src="js/index.js"></script>
    <link rel="icon" href="img/favicon.png" type="image/x-icon" />
    <link href="https://fonts.googleapis.com/css?family=Play" rel="stylesheet">

</head>

<body>
    <div class="pos-f-t">
        <div class="collapse" id="navbarToggleExternalContent">
            <div class="bg-dark p-4">
                <a href="login.jsp">
                    <h4 class="text-white">Logearte</h4>
                </a>
            </div>
        </div>
        <nav class="navbar navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>
    </div>
    <form action="mostrar" method="get">
        <input name="numero" type="number">
        <input type="submit"></form>

    <div>
        <div>
            <h1 id="titulo">LibroWeb</h1>
        </div>
    </div>
    <% for(Pagina a:Libro.getLibro()){ %>
    <%= a.getTexto() %>
    <br>
    <%= a.getAutor() %>
    </br>
    <%} %>
    Pagina:
    <% for(int i=0; i<Libro.getLibro().size();i++){ %><a href="mostrar?numero=<%=i%>">
        <%=i %></a>
    <%} %>
    <footer>
    </footer>
</body>

</html>
