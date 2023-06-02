<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.minglemingle.chat2mingle.util.JSPConst" %>

<html>
<head>
    <title>신고</title>
</head>
<style>
    @import url("/chat2mingle/resources/css/global/common.css");
    @import url("/chat2mingle/resources/css/report/report-list.css");
</style>
<body>
<%@ include file="/WEB-INF/views/global/adminHeader.jsp" %>

<body>
    <div class="report-list-wrap" id="report-list">
    <div class="report-list-content">
  <h2>신고자 내역</h2>
  <table>
    <thead class="top-thead">
      <tr>
        <th>신고자 이름</th>
        <th>피신고자 이름</th>
        <th>신고된 메세지 내역</th>
        <th>메세지 보낸 시간</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="report" items="${reportList}">
      <tr id="report-tr">
        <td class="reporter-nickname">${report.reporterNickname}</td>
        <td class="reportee-nickname">${report.reporteeNickname}</td>
        <td class="message-content">${report.messageContent}</td>
        <td class="reported-at">${report.reportedAt}</td>
        <td class="report-button-td"><button class="report-button"onclick="location.href='reporthistory/${report.messageId}'">신고</button></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

      </div>
      </div>
</body>

<%@ include file="/WEB-INF/views/global/footer.jsp" %>


</body>
<script src="/chat2mingle/resources/js/admin/admin.js"></script>

</html>
