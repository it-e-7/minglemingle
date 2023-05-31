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
  <h1>본문 내용</h1>

  <%-- 푸터 포함 --%>
<%@ include file="/WEB-INF/views/global/footer.jsp" %>
</body>