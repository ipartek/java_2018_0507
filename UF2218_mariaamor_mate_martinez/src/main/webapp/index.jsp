<%@ include file="WEB-INF/includes/cabecera.jsp" %>
<div class="container">
    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>
        <div class="col-md-4 bColor" >
            <section>
                <span class="btn btn-info"><i class="fas fa-pen"></i><a href="editorPagina.jsp"> Escribir Pagina</a></span>
                <br>
                <br>
                <form method="get" action="principal">
                    <input class="btn btn-info" type="submit" value="Ir a pagina"> <input type="number" name="pagina"/>
                </form>
                <br>
                <br>
                <span class="btn btn-info"><i class="fas fa-caret-left"></i> <a href="principal?pagina=${paginaMostrada.id-1}"> Anterior</a></span ><span class="btn btn-info fRight" ><i class="fas fa-caret-right"></i> <a href="principal?pagina=${paginaMostrada.id+1}"> Siguiente</a></span>
                <h4 class="text-center">Pagina ${paginaMostrada.id} / ${ultimaPagina}</h4>
                <textarea class="form-control textHeight">${paginaMostrada.texto}</textarea>
                <br>
                Autor: ${paginaMostrada.autor}
                <br>
                <span class="btn btn-info"><i class="fas fa-caret-left"></i> <a href="principal?pagina=${paginaMostrada.id-1}"> Anterior</a></span ><span class="btn btn-info fRight" ><i class="fas fa-caret-right"></i> <a href="principal?pagina=${paginaMostrada.id+1}"> Siguiente</a></span>
                <br>
                <br>
                <form method="post" action="principal">
                    <i class="fas fa-search"></i> <input class="btn btn-info" type="submit" value="Buscar Palabra"> <input type="text" name="texto"/>
                </form>

            </section>
            
        </div>
    </div>
</div>


<%@ include file="WEB-INF/includes/pie.jsp" %>