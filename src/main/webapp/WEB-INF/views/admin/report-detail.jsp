<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-05-29
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    @import url("/chat2mingle/resources/css/global/common.css");
    @import url("/chat2mingle/resources/css/admin/admin.css");

</style>
<body>
<%@ include file="/WEB-INF/views/global/adminHeader.jsp" %>
<div id="report-detail">
    <form class="table" action="sendReport" method="post">
        <div class="table-row">
            <div class="table-cell" id="table-head">신고상세내용</div>
        </div>
        <div class="table-row">
            <div class="table-cell">보낸아이디</div>
            <div class="table-cell">${reportDetail.nickname}</div>
            <div class="table-cell table-label">정지유형</div>
            <div class="table-cell">
                <select class="dropdown">
                    <option value="chatting-stop">채팅정지</option>
                    <option value="login-stop">로그인정지</option>
                </select>
            </div>
        </div>
        <div class="table-row">
            <div class="table-cell">신고자</div>
            <div class="table-cell">${report.reporterNickname}</div>
            <div class="table-cell"></div>
            <div class="table-cell"></div>
        </div>
        <div class="table-row">
            <div class="table-cell">메시지</div>
            <div class="table-cell">${reportDetail.content}</div>
            <div class="table-cell table-label"><span>메시지 삭제</span></div>
            <div class="table-cell">
                <input type="checkbox" class="checkbox" />
            </div>
        </div>

        <div class="btn-container">
            <input type="submit" class="report-btn" value="신고처리"></input>
            <button class="report-btn">취소</button>
        </div>
    </form>
</div>
<%@ include file="/WEB-INF/views/global/footer.jsp" %>

</body>

<script src="/chat2mingle/resources/js/admin/admin.js" ></script>

</html>
