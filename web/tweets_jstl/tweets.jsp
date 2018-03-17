<%@ page import="java.util.List" %>
<%@ page import="twitter.dto.TwitterMessageDto" %><%--
  Created by IntelliJ IDEA.
  User: maykloff
  Date: 11.03.2018
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List of tweets</title>
</head>
<body>
<div>List of tweets</div>

${param.test}

<c:if test="${not empty searchTotalCount}">
    <div>Found tweets ${searchTotalCount}</div>
</c:if>

<ul>
    <c:forEach items="${tweetsModel}" var = "tweet">
        <li>
            <div>
                id: ${tweet.id}
                message: ${tweet.message}
                username: ${tweet.username}
            </div>
        </li>
    </c:forEach>
</ul>
</body>
</html>
