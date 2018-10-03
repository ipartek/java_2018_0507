<%@page import="com.ipartek.formacion.youtube.Video"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>

<base href="<%=request.getContextPath()%>/">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<main>
<%
          		ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
          	
          		Video videoInicio = new Video();
          		if ( !videos.isEmpty() ){
          			videoInicio = videos.get(0);
          		}	
    			
          		for( Video v : videos ){
          	%>
<form action="update" method="post" class="form-inline mt-2 mt-md-0">
	<input type="text" placeholder="id" disabled value="<%=v.getId()%>"> <br>
	<input type="text" placeholder="codigo" value="<%=v.getCodigo()%>"> <br>
	<input type="text" placeholder="nombre" value="<%=v.getCodigo()%>"><br>
	<input type="text" placeholder="idusuario" value="<%=v.getCodigo()%>"><br>
	<%
          		} //end for
            %>
	<input type="submit">
</form>
</main>
</html>