<%--
  Created by IntelliJ IDEA.
  User: maykloff
  Date: 11.03.2018
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Message</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/tweets">Twitter</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/myTweets">My tweets</a></li>
            <li><a href="/addTweet">Add tweet</a></li>
            <li><a href="/tweetSearchForm">Find tweets</a></li>
        </ul>
            <p class="navbar-text">Logged us ${sessionScope.username}</p>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>
<h1>Wtite your message here</h1>
<div class="container">
    <div class="alert alert-success"> ${message}</div>
</div>
</body>
</html>
