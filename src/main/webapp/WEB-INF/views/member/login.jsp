<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.minglemingle.chat2mingle.util.JSPConst" %>
<html>
<head>
    <title>로그인</title>
</head>
<style>
    @import url("${pageContext.request.contextPath}/resources/css/global/common.css");
    @import url("${pageContext.request.contextPath}/resources/css/member/member.css");

</style>
<body>

<div class="member">

    <div class="logo">
        <a href="/">
        <img src="${pageContext.request.contextPath}/resources/images/logo_thyundai.png"/>
        </a>
    </div>

    <div class="member-container">

        <form class="member-form" action="processLogin" method="post">
            <h1>로그인</h1>
            <hr class="member-hr"/>

            <label class="form-label" for="email">이메일</label>
            <input class="member-input" type="email" id="email" name="email" required/>

            <label class="form-label" for="password">비밀번호</label>
            <input class="member-input" type="password" id="password" name="password" required/>

            <div class="buttons-list">
					<span><a class="login-anchor" href="">아이디찾기</a>
						<span class="dot">&nbsp;&#x2022;&nbsp;</span></span>
                <span><a  class="login-anchor" href="">비밀번호 찾기</a>
                            <span class="dot">&nbsp;&#x2022;&nbsp;</span>
					</span>
                <span><a class="login-anchor" href="/member/signup">회원가입</a></span>
            </div>
            <c:choose>
                <c:when test="${loginMessage eq 'notMember'}">
                    <div class="message" id="login-message">존재하지 않는 계정입니다</div>
                </c:when>
                <c:when test="${loginMessage eq 'passwordFail'}">
                    <div class="message" id="login-message">비밀번호가 올바르지 않습니다</div>
                </c:when>
                <c:when test="${loginMessage eq 'accountSuspended'}">
                    <div class="message" id="login-message">로그인 정지된 계정입니다</div>
                </c:when>
                <c:when test="${loginMessage eq 'signUpComplete'}">
                    <div class="message"></div>
                </c:when>
                <c:otherwise>
                    <div class="message"></div>
                </c:otherwise>
            </c:choose>

            <input class="member-submit" type="submit" value="로그인"/>

        </form>

    </div>
</div>

</body>
<script src="${pageContext.request.contextPath}/resources/js/member/login.js" async defer></script>
<%@ include file="/WEB-INF/views/global/footer.jsp" %>
</html>
