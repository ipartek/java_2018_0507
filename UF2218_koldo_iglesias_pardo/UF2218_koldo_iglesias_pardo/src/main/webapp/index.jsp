<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ include file="WEB-INF/includes/header.jsp" %>
<div>
<h3>Bienvenido a la plataforma</h3>
<a href="insertar.jsp" id="escribiropt">Escribir página ✒ </a>
<form action="selectpagina" id="selectpagina" method="POST">
<p>
      <label for="pagina">Mover a página...</label><br />
      <input type="number" name="pagina" id="pagina" />
      <input type="submit" value="Ir" />
    </p>
</form>
<div id="navegacion">
<a href="#">◀ Anterior</a>
<a href="#">Siguiente ▶</a>
</div><br />
<div id="contenido">
<form action="pagina" id="pagina">
<textarea name="pagina" rows="10" cols="30">Enter text here...</textarea><br />
<input type="text" name="autor" id="autor" placeholder="Autor: desconocido" readonly="readonly" /><br />
</form>
</div>
<div id="navegacion">
<a href="#">◀ Anterior</a>
<a href="#">Siguiente ▶</a>
</div><br />
<form action="buscarpagina" id="buscarpagina" method="POST">
<p>
      <label for="pagina">Buscar 🔎</label><br />
      <input type="text" name="idpalabra" id="idpalabra" />
      <input type="submit" value="Buscar" />
    </p>
</form>
</div>
<%@ include file="WEB-INF/includes/footer.jsp" %>