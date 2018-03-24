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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/tweets_jstl/login/logged.jsp"></jsp:include>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/tweets">My twitter</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/addTweet">Add tweet</a></li>
            <li><a href="/tweetSearchForm">Find tweets</a></li>
            <li>
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Language
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="/language?lang=PL">Polski</a></li>
                        <li><a href="/language?lang=EN">English</a></li>
                        <li><a href="/language?lang=UA">Українська</a></li>
                    </ul>
                </div>
            </li>

        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>
<h1>List of tweets<h1>

    ${param.test}

    <c:if test="${not empty searchTotalCount}">
    <div>Found tweets ${searchTotalCount}</div>
    </c:if>

    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${myTweets}" var = "tweet">
                <tr>
                    <td>${tweet.id}</td>
                    <td>${tweet.title}</td>
                    <td><a href ="/tweet?tweetId=${tweet.id}">Preview</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
