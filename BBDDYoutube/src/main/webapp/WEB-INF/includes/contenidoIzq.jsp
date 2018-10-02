<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-4">
		<div class="well">
			<h2 class="text-center">Listado videos</h2>
			<div class="list-group">
			<%
				ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
			%>
         	<%-- <%
          		ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
    			
          		for( Video v : videos ){
          	%>
          	  <a href="#" onclick="reproducir('<%=v.getIdVideo()%>')" class="list-group-item"><%=v.getNombre()%></a>
          	  <a href="?id=<%=v.getIdVideo()%>"><i style="color:red;" class="float-right fas fa-trash-alt"></i></a>
            <%
          		} //end for
            %> --%>
          </div>
		</div>
	</div>
