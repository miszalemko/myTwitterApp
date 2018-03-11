<%@ page import="twitter.dto.TwitterMessageDto" %><%--
  Created by IntelliJ IDEA.
  User: maykloff
  Date: 11.03.2018
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet with id</title>
</head>
<body>
    <form>
        <div>Message<input type="text" name="message" value="<%=((TwitterMessageDto)request.getAttribute("tweet")).getMessage()%>"/></div>
        <input type="hidden" name="id" value="<%=((TwitterMessageDto)request.getAttribute("tweet")).getId()%>"/>
        <div>Username<input type="text" name="username" value="<%=((TwitterMessageDto)request.getAttribute("tweet")).getUsername()%>"/></div>
    </form>
</body>
</html>
