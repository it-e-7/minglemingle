const options = {hour: 'numeric', minute: 'numeric'};

let sock;
let onRefresh;
let messageInputBox;
let sendBtn;
let chatBox;
let chatBoxWrap;
let nickname;
let channel;
let accountType;
let noticeContainer;
let removeNoticeBtn;

async function connectSocket(nickname_param, channel_param, accountType_param) {
    // Socket 연결

    nickname = nickname_param;
    channel = channel_param;
    accountType = accountType_param;

    sock = new WebSocket("ws://192.168.0.200:8080/ws/chat?channel=" + channel);
    sock.onerror = function (e) {
        alert('연결에 실패하였습니다.');
        console.log(e)
    }
    sock.onclose = function () {
        alert('연결을 종료합니다.');
    };
    sock.onopen = async function () {
        // Socket이 연결되면
        await refreshMessage(); // 처음에 메시지 불러오기
        scrollChatBoxWrapToBottom(); // 불러온 다음 아래로 스크롤
        assignMessageHandlers() //

        sock.onmessage = (datastr => {
            let data = JSON.parse(datastr.data)
            let wasAtBottom = isChatBoxWrapAtBottom()

            handleMessageReceived(data);

            if (wasAtBottom || data.nickname === nickname) {
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

function deleteMessage(messageId) {
    console.log("deleting: " + messageId)
}

function hasReachedRefreshThreshold() {
    return chatBoxWrap.scrollTop() < (chatBoxWrap.prop("scrollHeight") * 0.3);
}

async function refreshMessage(messageId) {
    if (messageId === undefined) messageId = 0;
    lockRefresh(true);

    let data = await getMessages(messageId);
    addMessagesOnRefresh(data);

    lockRefresh(false);
}

async function getMessages(messageId) {
    return await $.ajax({
        type: 'GET',
        url: '/message?messageId=' + messageId + '&channel=' + channel,
        dataType: "json",
        success: function (data) {
            console.log(data)
            return data;
        },
        error: function (xhr, status, error) {
            alert('에러')
            console.log(error)
            return error;
        }
    })
}

function assignMessageHandlers() {
    // 마우스 휠을 움직이거나, 스크롤을 움직일 경우 메시지를 불러오고 위치조정
    chatBoxWrap.on('wheel scroll', async function (event) {
        let previousY = $(this).data('previousScrollY') || 0;
        let currentY = $(this).scrollTop()
        $(this).data('previousScrollY', currentY);

        let deltaY = event.originalEvent.deltaY || currentY - previousY;

        if (isRefreshAvailable() && hasReachedRefreshThreshold() && deltaY < 0) {
            await refreshMessage(getTopMessageId());
        }
    });

    // 메시지 inputBox 활성화, 비활성화
    messageInputBox.on('input change', function () {
        if ($(this).val() === "") {
            setDisabled(sendBtn, true);
        } else {
            setDisabled(sendBtn, false);
        }
    });
    // Message Input 엔터 눌렀을 때
    messageInputBox.keyup(e => {
        if (e.keyCode === 13 && messageInputBox.val() !== "") {
            setDisabled(sendBtn, true);
            sendMessage();
        }
    });

    sendBtn.click(() => {
        setDisabled(sendBtn, true);
        sendMessage();
    });
}

// Option에 기반해서 message 시간 포멧팅
function formatDateForMessage(dateString) {
    return (new Date(dateString)).toLocaleTimeString('kr-KR', options);
}

// Refresh 되었을 때, 메시지 추가
function addMessagesOnRefresh(data) {
    let original = chatBoxWrap.prop("scrollHeight");

    Object.values(data).map(item =>
        chatBox.prepend(makeMessageBoxListHTML(item))
    )

    if (chatBoxWrap.scrollTop() === 0) {
        chatBoxWrap.scrollTop(chatBoxWrap.prop("scrollHeight") - original);
    }

}

// 메시지를 받았을 때 취할 행동
function handleMessageReceived(data) {
    // messageType이 10보다 아래면 일반 메시지
    if (data.messageType < 10) {
        chatBox.append(
            makeMessageBoxListHTML(data)
        )
    }
    // 10이면 공지
    else if (data.messageType === 10) {
        console.log("공지입니다. " + data.content);
        noticeContainer.empty()
        noticeContainer.append(makeNoticeBox(data))
        $('#remove-notice-btn').click(() => {
            noticeContainer.empty();
        })
    } else if (data.messageType === 99) {
        // 99이면 시스템 메시지
        let [command, messageId] = parseSystemMessage(data.content);
        runSystemCommand(command, messageId);
    }
}

function parseSystemMessage(content) {
    let systemMsgArray = content.split(":");
    return [systemMsgArray[0], parseInt(systemMsgArray[1])]
}

function runSystemCommand(command, messageId) {
    if (command === "delete") {
        deleteMessage(messageId)
    } else {
        console.log("Unknown System Message Command: " + command + ", messageId: " + messageId);
    }
}

// 메시지 전송 함수
function sendMessage() {
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

// 가장 위에 있는 메시지ID 반환
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


function makeMessageBoxListHTML(data) {
    return `<message-box messageid="${data.messageId}"
                messageType=${data.messageType}
                isMyMessage="${(nickname === data.nickname)}" 
                content="${data.content}"
                nickname="${data.nickname}"
                sentAt="${formatDateForMessage(data.sentAt)}"/>`

}

function makeChatHeaderHTML(title, visitCount) {
    return `<chat-header title="${title}" visit-count="${visitCount}"/>`
}

function makeNoticeBox(data) {
    return `<notice-box content="${data.content}"/>`
}



