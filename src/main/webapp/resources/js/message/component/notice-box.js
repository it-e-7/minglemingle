class NoticeBox extends HTMLElement {
    constructor() {
        super();
    }

    static get observedAttributes() {
        return ['content'];
    }

    connectedCallback() {
        this.render();
    }

    attributeChangedCallback(name, oldValue, newValue) {
        this.render();
    }

    render() {
        const content = this.getAttribute('content') || 'Error';

        this.innerHTML = `
        <div class="mx-4 mt-2 rounded-md bg-amber-300 p-4">
            <button id="remove-notice-btn">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50" width="10px" height="10px">
                    <path d="M 7.71875 6.28125 L 6.28125 7.71875 L 23.5625 25 L 6.28125 42.28125 L 7.71875 43.71875 L 25 26.4375 L 42.28125 43.71875 L 43.71875 42.28125 L 26.4375 25 L 43.71875 7.71875 L 42.28125 6.28125 L 25 23.5625 Z"/>
                </svg>
            </button>
             <p class="text-center font-bold">${content}</p>
            
        </div>`
    }
}

customElements.define('notice-box', NoticeBox);
