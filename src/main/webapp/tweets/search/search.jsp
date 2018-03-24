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
</head>
<body>
    <form action ="tweets/search">
        <div>Username <input type="text" name="searchUsername" value = ""></div>
        <div>Message <input type="text" name="searchMessage" value = ""></div>
        <div><input type="submit" value="Search"/></div>
    </form>
</body>
</html>
