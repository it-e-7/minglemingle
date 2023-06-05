<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.minglemingle.chat2mingle.util.JSPConst" %>

<style type="text/css">
@import url("${pageContext.request.contextPath}/resources/css/global/footer.css");
@import url("${pageContext.request.contextPath}/resources/css/global/common.css");
</style>
<html>
<head>
	<title>Chatting List Room</title>
</head>
<body>
<div>
        <nav class="border-gray-200 px-4 lg:px-6 py-2.5 dark:bg-gray-800 w-screen w-full max-w-xl">
              <div class="flex flex-wrap justify-between items-center mx-auto max-w-xl">
                <div>
                  <div class="text-xl font-bold">
                    Hyundai Chatting
                  </div>
                  <div class="text-xs text-gray-600">
                    아래 채팅방을 눌러 원하는 카테고리에 접속하여 사람들과 소통하세요!
                  </div>
                </div>
                <div class="flex items-center lg:order-2">
                </div>
              </div>
        </nav>
        <br>

<c:forEach var="category" items="${JSPConst.CATEGORY_TITLES}" varStatus="status">
    <a href="/chat?channel=${status.index+1}&nickname=${member.nickname}&accountType=${member.accountType}">
            <div class="${status.index % 2 != 1 ? 'even-class' : 'bg-white'} bg-stone-100 border-gray-200 px-4 lg:px-6 py-2.5 dark:bg-gray-800 w-screen w-full max-w-xl">
                  <div class="flex flex-wrap items-center mx-auto max-w-xl">
                    <div>
                      <div class="text-xl font-bold">
                      <div>${category.key}</div>
                      </div>
                      <div class="text-xs text-gray-600">
                        ${category.value}
                      </div>
                    </div>
                    <div class="flex items-center lg:order-2">
                    </div>
                  </div>
            </div>
            </a>
</c:forEach>

</div>
        <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>