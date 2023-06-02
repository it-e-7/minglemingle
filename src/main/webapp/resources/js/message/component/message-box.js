class MessageBox extends HTMLElement {
    constructor() {
        super();
    }

    static get observedAttributes() {
        return ['isMyMessage', 'content', 'nickname', 'sentAt'];
    }

    connectedCallback() {
        this.render();
    }

    attributeChangedCallback(name, oldValue, newValue) {
        this.render();
    }

    render() {
        const isMyMessage = this.getAttribute('isMyMessage') === 'true';
        const messageType = parseInt(this.getAttribute('messageType'));
        const content = this.getAttribute('content') || 'Error';
        const nickname = this.getAttribute('nickname') || 'Error';
        const sentAt = this.getAttribute('sentAt') || '00:00';

        let profileHTML = `<div class="flex-shrink-0 h-8 w-8 rounded-full bg-gray-300 mr-2"></div>`
        let timeHTML = `<span class="text-xxs text-gray-500 leading-none self-end mb-1 whitespace-nowrap">${sentAt}</span>`
        let nicknameHTML = `<p class="text-xs pb-1">${nickname}</p>`

        this.innerHTML = `
                <div class="flex w-full mt-2 max-w-sm mb-3 ${isMyMessage ? 'ml-auto justify-end' : ''}">
                    ${isMyMessage ? timeHTML : profileHTML}
                    <div class="${isMyMessage ? 'ml-1' : 'mr-1'}">
                        ${isMyMessage ? '' : nicknameHTML}
                        <div class="p-2 ${isMyMessage ? 'bg-hyundai-600 text-white rounded-l-lg rounded-br-lg' : 'bg-gray-100 rounded-r-lg rounded-bl-lg'}">
                            <p class="text-sm">${messageType === 50 ? '😮' : ''} ${content}</p>
                        </div>
                    </div>
                    ${isMyMessage ? '' : timeHTML}
                </div>`
    }
}

customElements.define('message-box', MessageBox);
