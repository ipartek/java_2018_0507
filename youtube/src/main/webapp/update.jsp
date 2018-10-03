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
				Video v = new Video(Integer.parseInt(request.getParameter("id")), request.getParameter("codigo"), 
						request.getParameter("nombre"), Integer.parseInt(request.getParameter("idusuario")));
          		
          		
          		/*if ( !videos.isEmpty() ){
          			v = videos.get(0);
          		}	*/
    			
          	%>
<form action="update" method="post" class="form-inline mt-2 mt-md-0">
	<input type="text" placeholder="id" disabled value="<%=v.getId()%>"> <br>
	<input type="text" placeholder="codigo" value="<%=v.getCodigo()%>"> <br>
	<input type="text" placeholder="nombre" value="<%=v.getNombre()%>"><br>
	<input type="text" placeholder="idusuario" disabled value="<%=v.getIdUsuario()%>"><br>
	<%
          		 //end for
            %>
</form>
</main>
</html>