<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <%-- 헤더 포함 --%>
 <%@ include file="/WEB-INF/views/global/header.jsp" %>
  <!-- 다른 내용 -->

<div class="allign-slide">
<div class="slide slide_wrap">
      <div class="slide_item item1"></div>
      <div class="slide_item item2"></div>
      <div class="slide_item item3"></div>
      <div class="slide_item item4"></div>
      <div class="slide_item item5"></div>
      <div class="slide_prev_button slide_button">◀</div>
      <div class="slide_next_button slide_button">▶</div>
      <ul class="slide_pagination"></ul>
    </div>
    </div>
	<script src="/chat2mingle/resources/js/home/home-script.js"></script>

<div class="body-wrapper section">
<div class="inner" id="home">
      <div class="title-box">
      <h2 class="summer-shopping">쇼핑하계</h2>
      </div>
      <div class="image-box">
        <div class="left-image-box"></div>
        <div class="right-image-box"></div>
        </div>
</div>
</div>
  <%-- 푸터 포함 --%>
<%@ include file="/WEB-INF/views/global/footer.jsp" %>
</body>