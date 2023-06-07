class ChatHeader extends HTMLElement {
    constructor() {
        super();
    }

    static get observedAttributes() {
        return ['title', 'visit_count'];
    }

    connectedCallback() {
        this.render();
    }

    attributeChangedCallback(name, oldValue, newValue) {
        this.render();
    }

    render() {
        const title = this.getAttribute('title');
        const visit_count = this.getAttribute('visit-count');

        this.innerHTML = `
          <header>
            <nav class="bg-white border-gray-200 px-4 lg:px-6 py-2.5 dark:bg-gray-800 w-screen w-full max-w-xl">
              <div class="flex flex-wrap justify-between items-center mx-auto max-w-xl">
                <div>
                  <div class="text-xl font-bold">
                    ${title}
                  </div>
                  <div class="text-xs">
                    최근 ${visit_count}명 방문
                  </div>
                </div>
                <div class="flex items-center lg:order-2">
                <a href="/chat">
                  <button class="inline-flex items-center p-2 ml-1 text-sm text-gray-500 rounded-lg hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" >
                    <svg class="w-6 h-6" fill="currentColor" viewB:ox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                      <path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd"/>
                    </svg>
                  </button>
                 <a>
                </div>
              </div>
            </nav>
          </header>`

    }
}

customElements.define('chat-header', ChatHeader);
