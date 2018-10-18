
<%@page import="com.ipartek.formacion.youtube.Video"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp" %>

<form action="LoginServlet" method="post">

<label>nombre<input type="text" name="nombre"></label>
<label>password<input type="password" name="password"></label>
<label>email<input type="email" name="email"></label>
<label><button value="login" name="login">AAAA</button></label>


</form>

  <%@ include file="/WEB-INF/includes/pie.jsp" %>