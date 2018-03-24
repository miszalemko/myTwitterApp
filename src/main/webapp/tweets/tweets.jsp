<%@ page import="java.util.List" %>
<%@ page import="twitter.dto.TwitterMessageDto" %><%--
  Created by IntelliJ IDEA.
  User: maykloff
  Date: 11.03.2018
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of tweets</title>
</head>
<body>
<div>List of tweets</div>

<%
    if(request.getAttribute("searchTotalCount")!=null) {
%>
<div>Found tweets <%=request.getAttribute("searchTotalCount").toString()%></div>
<%
    }
%>
<ul>
    <%
        List<TwitterMessageDto> tweets = (List<TwitterMessageDto>)request.getAttribute("tweetsModel");
        for (TwitterMessageDto twitterMessageDto : tweets) {
    %>
    <li>
        <div>
            id: <%=twitterMessageDto.getId()%>
            message: <%=twitterMessageDto.getMessage()%>
            username: <%=twitterMessageDto.getUsername()%>
        </div>
    </li>
    <%
        }
    %>
</ul>
</body>
</html>
