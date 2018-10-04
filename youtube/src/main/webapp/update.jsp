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
<!--  -->
<%
          		//ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
          		//Rellenar el objeto con getAtributes
          		/*if ( !videos.isEmpty() ){
          			v = videos.get(0);
          		}	*/
    			
          	%>
<form action="update" method="post" class="form-inline mt-2 mt-md-0">
	<input type="text" name="id" readOnly placeholder="id"  value="${video.id }"> <br>
	<input type="text" name="codigo" placeholder="codigo" value="${video.codigo }"> <br>
	<input type="text" name="nombre" placeholder="nombre" value="${video.nombre }"><br>
	<input type="text" name="idusuario" placeholder="idusuario" readOnly value="${video.idUsuario }"><br>
	<input type="submit" value="modificar">
	<%
          		 //end for
            %>
</form>
</main>
</html>