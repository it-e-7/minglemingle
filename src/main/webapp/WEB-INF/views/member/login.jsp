<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>로그인</title>
    <link rel="stylesheet" href="/chat2mingle/resources/css/member/member.css"/>
</head>
<body>
<div class="logo">
    <img src="/chat2mingle/resources/images/logo_thyundai.png"/>
</div>

<div class="member-container">

<form action="processLogin" method="post">
    <h1>로그인</h1>
    <hr/>

    <label class="form-label" for="email">이메일</label>
    <input type="email" id="email" name="email" required />

    <label class="form-label" for="password">비밀번호</label>
    <input type="password" id="password" name="password" required />

    <div class="buttons-list">
					<span><a href="">아이디찾기</a>
						<span class="dot">&nbsp;&#x2022;&nbsp;</span></span>
                        <span><a href="">비밀번호 찾기</a>
                            <span class="dot">&nbsp;&#x2022;&nbsp;</span>
					</span>
        <span><a href="/chat2mingle/member/signup">회원가입</a></span>
    </div>
    <c:choose>
        <c:when test="${loginMessage eq 'notMember'}">
            <div class="message" id="login-message">존재하지 않는 계정입니다</div>
        </c:when>
        <c:when test="${loginMessage eq 'passwordFail'}">
            <div class="message" id="login-message">비밀번호가 올바르지 않습니다</div>
        </c:when>
        <c:when test="${loginMessage eq 'account suspended'}">
            <div class="message" id="login-message">로그인 정지된 계정입니다</div>
        </c:when>
    </c:choose>

    <input type="submit" value="로그인" />

</form>

</div>
</body>
</html>
