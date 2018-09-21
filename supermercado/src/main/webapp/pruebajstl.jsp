<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:if test="${true}">
	nologeado
</c:if>

<c:forEach var="index" begin="0" end="4">
      # ${index}:
      <c:choose>
        <c:when test="${index == 1}">
          One!<br/>
        </c:when>
        <c:when test="${index == 4}">
          Four!<br/>
        </c:when>
        <c:when test="${index == 3}">
          Three!<br/>
        </c:when>
        <c:otherwise>
          Huh?<br/>
        </c:otherwise>
      </c:choose>
    </c:forEach>
    
</body>
</html>