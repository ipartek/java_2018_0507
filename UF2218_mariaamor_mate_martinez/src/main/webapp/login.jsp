<%@ include file="WEB-INF/includes/cabecera.jsp" %>
<div class="container">

    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>

        <div class="col-md-4">
            <section class="login-form">
                <form method="post" action="login" role="login">

                    <input type="text" name="nombre" placeholder="nombre"
                           required class="form-control input-lg"/> <input type="password"
                                                                           name="pass" class="form-control input-lg" id="password"
                                                                           placeholder="Password" required=""/>


                    <div class="pwstrength_viewport_progress"></div>


                    <button type="submit" name="login" value="login" class="btn btn-lg btn-primary btn-block" id="botonsub">Iniciar sesión</button>


                </form>
                <p>${error}</p>
                
                <div class="form-links">
                    <a href="#">www.website.com</a>
                </div>
            </section>
        </div>

        <div class="col-md-4"></div>


    </div>


</div>

<%@ include file="WEB-INF/includes/pie.jsp" %>