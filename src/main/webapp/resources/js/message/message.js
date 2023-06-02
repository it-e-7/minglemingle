
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