<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.minglemingle.chat2mingle.util.JSPConst" %>
<html>
<head>
    <title>회원가입</title>

</head>
<style>
    @import url("${pageContext.request.contextPath}/resources/css/global/common.css");
    @import url("${pageContext.request.contextPath}/resources/css/member/member.css");
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/global/jquery-3.6.4.min.js"></script>
<body>
<div class="member">
    <div class="logo">
        <a href="/">
        <img src="${pageContext.request.contextPath}/resources/images/logo_thyundai.png"/>
        </a>
    </div>
    <div class="member-container">

        <form class="member-form" action="/member/signup" method="post">
            <h1>회원가입</h1>
            <hr class="member-hr"/>

            <label class="form-label" for="nickname">아이디</label>
            <input class="member-input" type="text" id="nickname" name="nickname" required/>

            <div class="message" id="nickname-message"></div>

            <label class="form-label" for="email">이메일</label>

            <input class="member-input" type="email" id="email" name="email" required/>
            <div class="message" id="email-message"></div>

            <label class="form-label" for="password">비밀번호</label>
            <input class="member-input" type="password" id="password" name="password" required/>

            <label class="form-label" for="password-check">비밀번호 확인</label>
            <input
                    class="member-input"
                    type="password"
                    id="password-check"
                    name="password-check"
                    required
            />
            <div class="message" id="password-message"></div>
            <input class="member-submit" type="submit" value="회원가입"/>

            <div class="message" id="submit-message"></div>
        </form>

    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/member/signup.js" async defer></script>
<%@ include file="/WEB-INF/views/global/footer.jsp" %>

</html>
