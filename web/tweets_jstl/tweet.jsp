<%@ page import="twitter.dto.TwitterMessageDto" %><%--
  Created by IntelliJ IDEA.
  User: maykloff
  Date: 11.03.2018
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tweet edit page</title>
</head>
<body>
<h1>Tweet edit page using JSTL</h1>

<c:choose>
    <c:when test="${not empty errorMessage}">
        <div>${errorMessage}</div>
    </c:when>
    <c:otherwise>
        <c:if test="${not empty tweet}">
            <form action="/addTweet" method="POST">
                <div>Message<input type="text" name="message" value="${tweet.message}"/></div>
                <input type="hidden" name="id" value="$tweet.id"/>
                <div>Username<input type="text" name="username" value="${tweet.username}"/></div>
                <div><input type="submit" value="Add Tweet"/></div>
            </form>
        </c:if>
    </c:otherwise>
</c:choose>

</body>
</html>
