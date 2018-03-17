<%--
  Created by IntelliJ IDEA.
  User: maykloff
  Date: 11.03.2018
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/tweets">My twitter</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/addTweet">Add tweet</a></li>
            <li><a href="/tweetSearchForm">Find tweets</a></li>
        </ul>
    </div>
</nav>
<h1>Write message and username</h1>
    <div class="container">
        <form class="form-horizontal" action="/tweets/search" method="get">
            <div class="form-group">
                <label class="control-label col-sm-2" for="searchMessage">Message:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="searchMessage" placeholder="Enter message"
                           name="searchMessage" value=""/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="searchUsername">Username:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="searchUsername" placeholder="Enter username"
                                      name="searchUsername" value=""/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Search tweet</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
