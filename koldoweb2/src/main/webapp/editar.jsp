<%@ include file="cabecera.jsp" %>
<div class="row">
  <div class="col-md-8">
  <ol class="breadcrumb">
  <li><a href="#">TodoLibros</a></li>
  <li class="active">Editar</li>
</ol>
</div>
  <div class="col-md-4">

</div>

<div class="row">
    <div class="col-md-8">
    <h1>Lista de libros nuevos destacados</h1>
    <h4>Actualice la información</h4>
    <form>
  <div class="form-group">
    <label for="nombrelibro">Nombre del Libro</label>
    <input type="text" class="form-control" id="nombrelibro" placeholder="Ej: Los pilares de la tierra.">
  </div>
  <div class="form-group">
    <label for="autorlibro">Autor del libro</label>
    <input type="text" class="form-control" id="autorlibro" placeholder="Ej: José Saramago">
  </div>
  <div class="form-group">
    <label for="fecha">Fecha de lanzamiento</label>
    <input type="date" class="form-control" id="fecha">
  </div>
  <div class="form-group">
    <label for="isbn">ISBN</label>
    <input type="number" class="form-control" id="number">
  </div>
  <button type="submit" class="btn btn-default">Actualizar</button>
</form>
    </div>
  <div class="col-md-4">
  <h1>Disfrute de las últimas novedades</h1>
  <p>Todo este contenido y mucho más está disponible para suscriptores con cuenta premium. ¡Únete a Premium!</p>
<img src="logopremium.png" class="img-responsive" alt="Responsive image"><button type="button" class="btn btn-danger">Suscríbete</button><br />
</div>
 
<div class="row">
  <div class="col-md-12">
  
      <hr class="featurette-divider"><br />
</div>
    </div>


<%@ include file="footer.jsp" %>