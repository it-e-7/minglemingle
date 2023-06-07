<%--
  Created by IntelliJ IDEA.
  User: sangwoncho
  Date: 2023/06/06
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <style type="text/css">
        @import url("${pageContext.request.contextPath}/resources/css/product/product-detail.css");
    </style>
    <script
            src="https://code.jquery.com/jquery-3.6.4.min.js"
            integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
            crossorigin="anonymous"
    ></script>
</head>

<%@ include file="/WEB-INF/views/global/header.jsp" %>

<body>
  <h1>${myWishlistProducts}</h1>
</body>

<%@ include file="/WEB-INF/views/global/footer.jsp" %>


</html>
