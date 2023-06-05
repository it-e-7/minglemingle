
function makeMessageBoxListHTML(myNickName, data) {
    return `<message-box messageid="${data.messageId}"
                messageType=${data.messageType}
                isMyMessage="${(myNickName === data.nickname)}" 
                content="${data.content}"
                nickname="${data.nickname}"
                sentAt="${formatDateForMessage(data.sentAt)}"/>`

}
function makeChatHeaderHTML(title, visitCount) {
    return `<chat-header title="${title}" visit-count="${visitCount}"/>`
}

let sock;
let myname = "${nickname}";

const options = { hour: 'numeric', minute: 'numeric' };

let onRefresh;
let messageInputBox;
let sendBtn;
let chatBox;
let chatBoxWrap;

async function connectSocket(nickname, channel, accountType) {
    sock = new WebSocket("ws://192.168.0.200:8080/ws/chat?channel=" + channel);
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
        assignMessageHandlers(nickname, channel, accountType)

        sock.onmessage = (data => {
            let json = JSON.parse(data.data)
            let wasAtBottom = isChatBoxWrapAtBottom()

            handleMessageReceived(myname, json);

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

async function refreshMessage(myname, messageId, channel) {
    if (messageId === undefined) messageId = 0;
    lockRefresh(true);

    let data = await getMessages(myname, messageId, channel);
    addMessagesOnRefresh(myname, data);

    lockRefresh(false);
}
async function getMessages(nickname, messageId, channel) {
    return await $.ajax({
        type: 'GET',
        url: '/message?messageId='+messageId + '&channel=' + channel,
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

function assignMessageHandlers(nickname, channel, accountType) {
    chatBoxWrap.on('wheel scroll', async function(event) {

        let previousY = $(this).data('previousScrollY') || 0;
        let currentY = $(this).scrollTop()
        $(this).data('previousScrollY', currentY);

        // Do something with deltaY, such as logging it or using it in your application
        let deltaY = event.originalEvent.deltaY || currentY - previousY;

        if (isRefreshAvailable() && hasReachedRefreshThreshold() && deltaY < 0) {
            await refreshMessage(myname, getTopMessageId(), channel);
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
            sendMessage(nickname, channel, accountType);
        }
    });

    sendBtn.click(() => {
        sendMessage(nickname, channel, accountType);
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
function handleMessageReceived(myname, data) {
    if (data.messageType < 10) {
        chatBox.append(
            makeMessageBoxListHTML(myname, data)
        )
    }
    else if (data.messageType < 50) {
        console.log("공지입니다. " + data.content);
    }
    else {
        let systemMsgArray = data.content.split(":");
        if (systemMsgArray[0] === "delete") {
            let messageId = parseInt(systemMsgArray[1]);
            deleteMessage(messageId)
        }
        else {
            console.log("Unknown System Message Command: " + data.content);
        }
    }

}
function sendMessage(nickname, channel, accountType) {
    let content = messageInputBox.val()
    sock.send(
        JSON.stringify({
            content: content,
            nickname: nickname,
            messageType: accountType,
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