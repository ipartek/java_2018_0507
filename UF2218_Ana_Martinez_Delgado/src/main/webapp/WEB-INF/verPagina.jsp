<%@ page import="com.ipartek.formacion.ejemplos.librocompartido.pojos.ConnectLibrosBD" %>
<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

<main>
<br><br> Numero pagina a mostrar:  
<%=request.getAttribute("numero") %>
<br>
<%=request.getAttribute("pagina") %>

<br><br><br><br>
<a href="javascript:history.back(-1);" title="Ir la página anterior">Volver</a>
</main>
</html>