<%--
  Created by IntelliJ IDEA.
  User: sangwoncho
  Date: 2023/06/06
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <style>
        @import url("${pageContext.request.contextPath}/resources/css/global/common.css");
        @import url("${pageContext.request.contextPath}/resources/css/wishlist/wishlist.css");
    </style>
    <script
            src="https://code.jquery.com/jquery-3.6.4.min.js"
            integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
            crossorigin="anonymous"
    ></script>
</head>

<%@ include file="/WEB-INF/views/global/header.jsp" %>

<body>
<div class="wishlist-container">
    <table class="wishlist-table">
        <thead class="top-thead">
        <tr>
            <th colspan="4" class="th-head">제품정보</th>
            <th class="th-head">상품가격</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="product" items="${myWishlistProducts}">

            <tr id="wishlist-tr">
                <td>
                    <div class="wishlist-img-box">
                        <img src="${product.productImagePath}" alt="상품이미지">
                    </div>
                </td>
                <td class="td-product-name">
                        ${product.productName}
                </td>
                <td class="td-product">
                        ${product.productCode}
                </td>
                <td class="td-product">
                        ${product.productBrand}
                </td>
                <td class="td-product">

                    <c:set var="number" value="${product.productPriceWon}"/>

                    <fmt:formatNumber value="${number}" pattern="#,##0" var="formattedNumber"/>

                    ${formattedNumber}<span>원</span>
                </td>


            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="total-container">
        <div class="total-left">
            <h3>총 합계 금액</h3>
        </div>
        <div class="total-right">
            <table class="total-table">
                <tbody>
                    <tr></tr>
                    <tr>
                        <td>최종결제금액</td>

                        <c:set var="total" value="0" />

                        <c:forEach var="product" items="${myWishlistProducts}">
                            <c:set var="total" value="${total + product.productPriceWon}" />
                        </c:forEach>

                        <c:set var="number" value="${total}"/>

                        <fmt:formatNumber value="${total}" pattern="#,##0" var="formattedNumber"/>

                        <td class="total-right-column">
                            ${formattedNumber}<span>원</span>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <button id="share-to-chat">공유하기</button>
</div>
</body>

<%@ include file="/WEB-INF/views/global/footer.jsp" %>

<script src="${pageContext.request.contextPath}/resources/js/wishlist/wishlist.js"></script>

</html>
