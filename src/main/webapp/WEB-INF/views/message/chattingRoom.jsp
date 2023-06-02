<%--
  Created by IntelliJ IDEA.
  User: Daniel Choi
  Date: 2023-05-26 026
  Time: PM 7:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>채팅</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/chat/chat.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
          integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>


<div id="chat-container" class="flex flex-col items-center justify-center w-screen min-h-screen text-gray-800 pb-3 px-1">
    <div class="flex flex-col flex-grow w-full max-w-xl bg-white rounded-b-lg overflow-hidden">
        <div id="chatBox-wrap" class="flex flex-col flex-grow h-0 p-4 overflow-auto">
            <div id="chatBox">

            </div>
        </div>
        <div class="p-1 border-t-1">
            <input id="messageInputBox" class="flex items-center h-10 w-full rounded px-3 text-sm" type="text" placeholder="dan(으)로 메시지 작성">
        </div>
        <div class="p-2 flex">
            <div class="flex ">
                <button class="ml-1"><i class="fa-solid fa-heart fa-lg" style="color: #d61f1f;"></i></button></div>
            <div class="flex ml-auto justify-end">
                <button id="sendBtn" class="bg-hyundai-500 px-4 py-1 text-sm font-bold rounded text-white disabled:bg-gray-300">보내기</button>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.tailwindcss.com"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/chat/component/message-box.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/chat/chat.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/chat/component/chat-header.js"></script>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" >

    let sock;
    let myname = "${nickname}";

    const options = { hour: 'numeric', minute: 'numeric' };

    let onRefresh;
    let messageInputBox;
    let sendBtn;
    let chatBox;
    let chatBoxWrap;



    async function connectSocket() {
        sock = new WebSocket("ws://192.168.0.29:8080/chat2mingle/ws/chat?channel=${channel}");
        sock.onerror = function (e) {
            alert('연결에 실패하였습니다.');
            console.log(e)
        }
        sock.onclose = function () {
            alert('연결을 종료합니다.');
        };
        sock.onopen = async function () {

            await refreshMessage(myname);
            scrollChatBoxWrapToBottom();
            assignMessageHandlers()

            sock.onmessage = (data => {
                let json = JSON.parse(data.data)
                let wasAtBottom = isChatBoxWrapAtBottom()
                addMessageReceived(myname, json);
                if (wasAtBottom || json.nickname === myname) {
                    scrollChatBoxWrapToBottom();
                }
            });

        }
    }

    function isChatBoxWrapAtBottom() {
        return chatBoxWrap.innerHeight() + chatBoxWrap.scrollTop() - (parseFloat(chatBoxWrap.prop("scrollHeight"))) > -5;
    }

    function scrollChatBoxWrapToBottom() {
        chatBoxWrap.scrollTop(chatBoxWrap.prop("scrollHeight"));

    }

    function deleteMessage() {
        console.log()
    }

    function hasReachedRefreshThreshold() {
        return chatBoxWrap.scrollTop() < (chatBoxWrap.prop("scrollHeight") * 0.3);
    }

    async function refreshMessage(myname, messageId) {
        if (messageId === undefined) messageId = 0;
        lockRefresh(true);

        let data = await getMessages(myname, messageId);
        addMessagesOnRefresh(myname, data);

        lockRefresh(false);
    }
    async function getMessages(nickname, messageId) {
        return await $.ajax({
            type: 'GET',
            url: '/chat2mingle/message?messageId='+messageId + '&channel=' + ${channel},
            dataType: "json",
            success: function(data) {
                return data;
            },
            error: function(xhr, status, error) {
                alert('에러')
                console.log(error)
                return error;
            }
        })
    }

    function assignMessageHandlers() {
        chatBoxWrap.on('wheel scroll', async function(event) {

            let previousY = $(this).data('previousScrollY') || 0;
            let currentY = $(this).scrollTop()
            $(this).data('previousScrollY', currentY);

            // Do something with deltaY, such as logging it or using it in your application
            let deltaY = event.originalEvent.deltaY || currentY - previousY;

            if (isRefreshAvailable() && hasReachedRefreshThreshold() && deltaY < 0) {
                await refreshMessage(myname, getTopMessageId());
            }
        });

        messageInputBox.on('input change', function() {
            if ($(this).val() === "") {
                setDisabled(sendBtn, true);
            } else {
                setDisabled(sendBtn, false);
            }
        });
        messageInputBox.keyup(e => {
            if (e.keyCode === 13 && messageInputBox.val() !== "") {
                setDisabled(sendBtn, true);
                sendMessage("${nickname}", ${channel});
            }
        });

        sendBtn.click(() => {
            sendMessage("${nickname}", ${channel});
        });
    }
    function formatDateForMessage(dateString) {
        return (new Date(dateString)).toLocaleTimeString('kr-KR', options);
    }
    function addMessagesOnRefresh(myname, data) {
        let original = chatBoxWrap.prop("scrollHeight");

        Object.values(data).map(item =>
            chatBox.prepend(makeMessageBoxListHTML(myname, item))
        )

        if (chatBoxWrap.scrollTop() === 0) {
            chatBoxWrap.scrollTop(chatBoxWrap.prop("scrollHeight")-original);
        }

    }
    function addMessageReceived(myname, data) {
        chatBox.append(
            makeMessageBoxListHTML(myname, data)
        )
    }
    function sendMessage(nickname, channel) {
        let content = messageInputBox.val()
        sock.send(
            JSON.stringify({
                content: content,
                nickname: nickname,
                messageType: 1,
                channel: channel
            })
        );
        messageInputBox.val("");
    }

    function getTopMessageId() {
        return chatBox.children().first().attr('messageid');
    }

    function isRefreshAvailable() {
        return !onRefresh
    }

    function lockRefresh(state) {
        onRefresh = state;
    }

    function setDisabled(jSelector, state) {
        jSelector.prop("disabled", state);
    }

    $(document).ready(async function() {
        $("#chat-container").prepend(makeChatHeaderHTML("화장품, 요즘은 뭐가 대세야?", "532"));

        chatBox = $('#chatBox')
        messageInputBox = $("#messageInputBox");
        sendBtn = $("#sendBtn")
        chatBoxWrap = $("#chatBox-wrap")

        connectSocket();

    })


</script>

</body>
</html>