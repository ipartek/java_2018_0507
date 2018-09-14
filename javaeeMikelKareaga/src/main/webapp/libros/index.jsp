<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp" %>
<%
 String[] arrayNombres= {"el principito","bigger better ideas","vision de america","margaret aitwood",
		 				"horros stories","crank","brother and beast","mitos tocados"};
String[] arrayedit= {"anaya","espasa","colorin","panoco"};
String [] arrayPrecios={"10.50€","11.00€","19.95€","23.30€","13.30€","28.30€","23.00€","32.30€"};
%>
<div class="row">
<%for(int i=1;i<5;i++){ %>
	<article class="col-xs-6 col-sm-6 col-md-3 col-lg-3 text-center">
		<img  src="imgs/<%=i%>.jpg" 
		border="2" height="250px" alt="Este es el ejemplo de un texto alternativo">
		<section>
			<p ><%=arrayNombres[i-1]%></p>
			<p><%=arrayedit[i-1]%></p>
			<p><%=arrayNombres[i-1]%></p>
		</section>
	</article>
<%} %>
	
</div>
<div class="row">
	<%for(int o=0,i=5;i<9;i++,o++){ %>
	<article class="col-xs-6 col-sm-6 col-md-3 col-lg-3 text-center">>
		<img  src="imgs/<%=i%>.jpg" 
		border="2" height="250px" alt="Este es el ejemplo de un texto alternativo">
		<section>
			<p><%=arrayNombres[i-1]%></p>
			<p><%=arrayedit[o]%></p>
			<p><%=arrayNombres[i-1]%></p>
		</section>
	</article>
<%} %>
</div>

<%@ include file="includes/pie.jsp" %>
