<%--
  Created by IntelliJ IDEA.
  User: maykloff
  Date: 11.03.2018
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
    <%=(String)request.getAttribute("message")%>
</body>
</html>
