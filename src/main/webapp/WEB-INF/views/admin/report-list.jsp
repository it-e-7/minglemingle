<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-05-29
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>신고</title>
</head>
<style>
    @import url("/chat2mingle/resources/css/global/common.css");
    @import url("/chat2mingle/resources/css/admin/admin.css");

</style>
<body>
<%@ include file="/WEB-INF/views/global/adminHeader.jsp" %>

<div id="report-list">
    <h3 id="test">신고 리스트</h3>
    <div id="report-container">
        <div class="report-list-item title-container">
            <div class="column title">신고자 닉네임</div>
            <div class="column title">메세지를 보낸 닉네임</div>
            <div class="column title">메세지 내용</div>
            <div class="column title">메세지 전송 시간</div>
        </div>
        <c:forEach items="${reportList}" var="report">
            <div class="report-list-item">
                <div class="column">${report.reporterNickname}</div>
                <div class="column">${report.reporteeNickname}</div>
                <div class="column"><a href="reporthistory/${report.messageId}">${report.messageContent}</a></div>

                <div class="column">${report.reportedAt}</div>
<%--                <div class="column">${report.memberId}</div>--%>
<%--                <div class="column>${report.messageId}</div>--%>
                <div class="column">${report.messageSentAt}</div>

            </div>

        </c:forEach>
    </div>


<%@ include file="/WEB-INF/views/global/footer.jsp" %>


</body>
<script src="/chat2mingle/resources/js/admin/admin.js"></script>

</html>
