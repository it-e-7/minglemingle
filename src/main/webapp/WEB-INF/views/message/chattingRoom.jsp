<%--
  Created by IntelliJ IDEA.
  User: Daniel Choi
  Date: 2023-05-26 026
  Time: PM 7:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>채팅</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/message/message.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>


<div id="chatContainer" class="flex flex-col items-center justify-center w-screen min-h-screen text-gray-800 pb-3 px-1">
    <div id="noticeBoxContainer" class="w-screen">
    </div>
    <div class="flex flex-col flex-grow w-full max-w-xl bg-white rounded-b-lg overflow-hidden">
        <div id="chatBoxWrap" class="flex flex-col flex-grow h-0 p-4 overflow-auto">
            <div id="chatBox">

            </div>
        </div>
        <div class="p-1 border-t-1">
            <input id="messageInputBox" class="flex items-center h-10 w-full rounded px-3 text-sm" type="text"
                   placeholder="${nickname}(으)로 메시지 작성">
        </div>
        <div class="p-2 flex">
            <div class="flex ">
                <button class="ml-1"><i class="fa-solid fa-heart fa-lg" style="color: #d61f1f;"></i></button>
            </div>
            <div class="flex ml-auto justify-end">
                <button id="sendBtn" disabled class="bg-hyundai-500 px-4 py-1 text-sm font-bold rounded text-white disabled:bg-gray-300">보내기</button>
            </div>
        </div>
    </div>
    <div id="seeMoreModal" class="message-modal rounded-md p-4 bg-white">
        <div class="flex">
            <div class="mt-1 mr-1">
                <?xml version="1.0" ?><!DOCTYPE svg  PUBLIC '-//W3C//DTD SVG 1.1//EN'  'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'><svg height="20px" id="Layer_1" style="enable-background:new 0 0 512 512;" version="1.1" viewBox="0 0 512 512" width="20px" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><g><path d="M381.7,225.9c0-97.6-52.5-130.8-101.6-138.2c0-0.5,0.1-1,0.1-1.6c0-12.3-10.9-22.1-24.2-22.1c-13.3,0-23.8,9.8-23.8,22.1   c0,0.6,0,1.1,0.1,1.6c-49.2,7.5-102,40.8-102,138.4c0,113.8-28.3,126-66.3,158h384C410.2,352,381.7,339.7,381.7,225.9z"/><path d="M256.2,448c26.8,0,48.8-19.9,51.7-43H204.5C207.3,428.1,229.4,448,256.2,448z"/></g></svg>
            </div>

            <button value="신고하기" messageId="" memberId="${member.memberId}" id="report-message-btn" onclick="reportMessage()" class="pr-5">신고하기</button>

        </div>
    </div>

    <!-- Semi-transparent background -->
    <div id="chatModalBackdrop"></div>
</div>

<script src="https://cdn.tailwindcss.com"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/js/message/component/message-box.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/js/message/component/notice-box.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/message/message.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/js/message/component/chat-header.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

    $(document).ready(async function() {
        documentSelector = $(document);
        chatBox = $('#chatBox')
        chatBoxWrap = $("#chatBoxWrap")
        messageInputBox = $("#messageInputBox");
        noticeBoxContainer = $('#noticeBoxContainer');
        sendBtn = $("#sendBtn")
        seeMoreModal = $("#seeMoreModal")
        chatModalBackdrop = $("#chatModalBackdrop")
        reportBtn = $("#report-message-btn")
      
        $("#chatContainer").prepend(makeChatHeaderHTML("${categorySubtitle}", "532"));
        await connectSocket("${nickname}", ${channel}, ${accountType});
    })

</script>
</body>
</html>
