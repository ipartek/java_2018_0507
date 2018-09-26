<%@ include file="WEB-INF/includes/cabecera.jsp" %>
<div class="container">
    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <section >
                <form method="post" action="editorPagina">
                    <h2 class="text-center">Escribir pagina</h2>
                    <textarea class="form-control textHeight"  name="texto"></textarea>
                    <input class="form-control"  type="submit" name="guardar" value="Guardar">
                </form>
                ${error}

        </div>
    </div>
</div>


<%@ include file="WEB-INF/includes/pie.jsp" %>