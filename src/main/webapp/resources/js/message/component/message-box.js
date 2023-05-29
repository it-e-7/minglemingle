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
        const content = this.getAttribute('content') || 'Error';
        const nickname = this.getAttribute('nickname') || 'Error';
        const sentAt = this.getAttribute('sentAt') || '00:00';

        this.innerHTML = `
            <div class="flex w-full mt-2 space-x-3 max-w-xs ${!isMyMessage ? '' : 'ml-auto justify-end'}">
                ${!isMyMessage ? '<div class="flex-shrink-0 h-10 w-10 rounded-full bg-gray-300"></div>' : ''}
                <div> 
                    ${!isMyMessage ? '<p class="text-xs pb-1">' + nickname + '</p>' : ''}
                    <div class="p-3 ${isMyMessage ? 'bg-blue-600 text-white rounded-l-lg rounded-br-lg' : 'bg-gray-300 rounded-r-lg rounded-bl-lg'}">
                        <p class="text-sm">${content}</p>
                    </div>
                    <span class="text-xs text-gray-500 leading-none">${sentAt}</span>
                </div>
            </div>`;
    }
}

customElements.define('message-box', MessageBox);
