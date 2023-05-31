<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.minglemingle.chat2mingle.util.JSPConst" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="logout" method="post">
    <input type="submit" value="로그아웃">
</form>
<h1>product home</h1>
<p>${member}</p>
</body>
</html>
