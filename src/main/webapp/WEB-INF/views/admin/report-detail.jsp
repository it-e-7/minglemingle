<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-05-29
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>신고상세내용</title>
</head>
<style>
    @import url("${pageContext.request.contextPath}/resources/css/global/common.css");
    @import url("${pageContext.request.contextPath}/resources/css/report/report-detail.css");

</style>
<body>
<%@ include file="/WEB-INF/views/global/adminHeader.jsp" %>
<div id="report-detail">
    <form class="table" action="/admin/sendReport" method="post">
        <input hidden type="text" name="memberId" value="${reportDetail.memberId}"/>
        <input hidden type="number" name="messageId" value="${reportDetail.messageId}" />
        <input hidden type="number" name="channel" value="${reportDetail.channel}" />
        <input hidden type="text" name="reporteeNickname" value="${reportDetail.reporteeNickname}" />

        <div class="report-detail-h2">
            <h2>신고 상세 내용</h2>
        </div>
        <table class="report-table">
            <tr class="table-row">
                <td>메세지를 보낸 아이디</td>
                <td>${reportDetail.reporteeNickname}</td>
                <td class="table-label">정지유형</td>
                <td>
                    <select name="account-punishment" class="dropdown">
                        <option value="no-stop">해당없음</option>
                        <option value="chatting-stop">채팅정지</option>
                        <option value="login-stop">로그인정지</option>
                    </select>
                </td>
            </tr>
            <tr class="table-row">
                <td>메세지</td>
                <td>${reportDetail.messageContent}</td>
                <td class="table-label">메시지 삭제</td>
                <td>
                    <input type="checkbox" name="delete-message" class="checkbox" />
                </td>
            </tr>
            <tr class="table-row">
                <td>메세지 전송시간</td>
                <fmt:formatDate value="${reportDetail.messageSentAt}" pattern="yyyy-MM-dd HH:mm" var="formattedMessageSentAt"/>
                <td>${formattedMessageSentAt}</td>
                <td></td>
                <td></td>
            </tr>
            <tr class="table-row">
                <td>신고시간</td>
                <fmt:formatDate value="${reportDetail.reportedAt}" pattern="yyyy-MM-dd HH:mm" var="formattedReportedAt"/>
                <td>${formattedReportedAt}</td>
                <td></td>
                <td></td>
            </tr>
            <tr class="table-row">
                <td>신고자</td>
                <td>${reportDetail.reporterNickname}</td>
                <td></td>
                <td></td>
            </tr>
        </table>


        <div class="report-detail-h2">
            <h2>메세지 통계</h2>
        </div>
        <table class="report-table">
            <tr class="table-row">
                <td>신고건수</td>
                <td>${reportStatistic.reportCount}</td>
            </tr>
            <tr class="table-row">
                <td>마지막으로 신고된 날짜</td>
                <fmt:formatDate value="${reportStatistic.lastReportedAt}" pattern="yyyy-MM-dd HH:mm" var="formattedLastReportedAt"/>
                <td>${formattedLastReportedAt}</td>
            </tr>
        </table>

        <div class="btn-container">
            <input type="submit" class="report-btn" value="신고처리"/>
        </div>
    </form>
</div>
<%@ include file="/WEB-INF/views/global/footer.jsp" %>

</body>

<script src="${pageContext.request.contextPath}/resources/js/admin/admin.js" ></script>

</html>
