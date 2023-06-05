<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.minglemingle.chat2mingle.util.JSPConst" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>신고</title>
</head>
<style>
    @import url("${pageContext.request.contextPath}/resources/css/global/common.css");
    @import url("${pageContext.request.contextPath}/resources/css/report/report-list.css");
</style>
<body>
<%@ include file="/WEB-INF/views/global/adminHeader.jsp" %>

<%--<div id="myModal" class="modal">--%>
<%--    <div class="modal-content">--%>
<%--        <p>정말 신고하시겠습니까?</p>--%>
<%--        <div class="modal-buttons">--%>
<%--            <button class="modal-button" id="confirmButton">확인</button>--%>
<%--            <button class="modal-button cancel" id="cancelButton">취소</button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<div class="report-list-wrap" id="report-list">
    <div class="report-list-content">
        <div class="report-h3">
            <h2>신고자 내역</h2>
        </div>

        <table class="report-container">
            <thead class="top-thead">
            <tr>
                <th>신고자 이름</th>
                <th>피신고자 이름</th>
                <th>신고된 메세지 내역</th>
                <th>메세지 보낸 시간</th>
<%--                <th></th>--%>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="report" items="${reportList}">
                <fmt:formatDate value="${report.reportedAt}" pattern="yyyy-MM-dd HH:mm" var="formattedDateTime"/>

                <tr id="report-tr">
                    <td class="reporter-nickname">${report.reporterNickname}</td>
                    <td class="reportee-nickname">${report.reporteeNickname}</td>
                    <td class="message-content"><a class="report-anchor"
                                                   href="reportdetail?messageId=${report.messageId}&memberId=${report.memberId}">${report.messageContent}</a>
                    </td>
                    <td class="reported-at">${formattedDateTime}</td>
                        <%--        <td class="report-button-td">--%>
                        <%--        <button class="report-button"onclick="openModal('${report.reporterNickname}', '${report.reporteeNickname}')">신고</button></td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
</body>

<%@ include file="/WEB-INF/views/global/footer.jsp" %>


</body>
<script src="${pageContext.request.contextPath}/resources/js/report/report-list.js"></script>

</html>
