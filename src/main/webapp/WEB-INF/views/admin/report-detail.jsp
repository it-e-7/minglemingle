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
    <form class="table" action="/chat2mingle/admin/sendReport" method="post">

        <input hidden type="number" name="messageId" value="${reportDetail.messageId}" />
        <input hidden type="number" name="channel" value="${reportDetail.channel}" />
        <input hidden type="text" name="reporteeNickname" value="${reportDetail.reporteeNickname}" />

        <table class="report-table">
            <tr class="table-row">
                <th colspan="4" id="table-head">신고상세내용</th>
            </tr>
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
                <td>${reportDetail.messageSentAt}</td>
                <td></td>
                <td></td>
            </tr>
            <tr class="table-row">
                <td>신고시간</td>
                <td>${reportDetail.reportedAt}</td>
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

        <div class="btn-container">
            <input type="submit" class="report-btn" value="신고처리"/>
            <button class="report-btn">취소</button>
        </div>
    </form>
</div>
<%@ include file="/WEB-INF/views/global/footer.jsp" %>

</body>

<script src="/chat2mingle/resources/js/admin/admin.js" ></script>

</html>
