<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-05-25
  Time: 오후 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <form action="/chat2mingle/processlogin" method="post" enctype="application/x-www-form-urlencoded">
    id: <input name="memberId" type="text">
    pw: <input name="memberPw" type="pw">
    <input type="submit">
  </form>
</body>
</html>
