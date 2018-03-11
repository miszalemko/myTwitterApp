<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    My Twitter App
  <%
    for(int i = 0; i<10;i++) {
       out.println("<div>Number " + i + "</div>");
    }
  %>
  </body>
</html>