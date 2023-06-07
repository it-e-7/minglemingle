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
        <button class="flex">
            <div class="pr-5">
                신고하기
            </div>
            <div>
                icon
            </div>
        </button>
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
      
        $("#chatContainer").prepend(makeChatHeaderHTML("${categorySubtitle}", "532"));
        addChatWindowMessageEventListener();
        await connectSocket("${nickname}", ${channel}, ${accountType});
    })

    const addChatWindowMessageEventListener = () => {
        console.log("adding the eventListner");
        window.addEventListener('message', function(event) {
            if (event.data?.sharedMessage) {
                console.log("data: " + event.data.sharedMessage);
                setInputVal(messageInputBox, event.data.sharedMessage);
            }
        });
    }
</script>
</body>
</html>
