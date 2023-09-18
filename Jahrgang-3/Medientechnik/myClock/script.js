
// HTML TEMPLATE
const myClockTemplate = document.createElement('template');

//<template>
myClockTemplate.innerHTML = `
  <style>
    
    #clock {
        width:min-width;
        font-family:digital;
        font-size: 15rem;
  
        border: .2em solid #242323;
        border-radius:.2em;

        margin:5vw;

        text-align: center;
        background-color: black;
        color: rgba(172, 255, 47, 0.647);
        text-shadow: 0 0 2px #FFF, 0 0 5px #49ff18, 0 0 5px #49FF18, 0 0 4px #49FF18, 0 0 5px #49FF18, 0 0 12px #49ff18, 2px 0px 0px rgba(206,89,55,0);
   
    }  
    @font-face {
        font-family: 'digital';
        src: url(':/DS-DIGIT.TTF');
    }
    #city{
        text-algin: center;
        font-size: 5rem;
        font-family: Arial, Helvetica, sans-serif;
        font-weight: 900;
        text-align: center; 
    }
  </style>  

        <div>
            <div id="city"></div>
            <div id="clock"></div>
        </div>
`;



// Define ES6 class
class MyClock extends HTMLElement {
    constructor() {
        let self = super();
        console.log(self);
        // SHADOW DOM
        this.attachShadow({ mode: 'open' });
        this.shadowRoot.appendChild(myClockTemplate.content.cloneNode(true));
    }

    static get observedAttributes() {
        return ['time-zone', 'city-name'];
    }

    // customize template with attributes
    attributeChangedCallback(attrName, oldValue, newValue) {
        console.log(attrName);
        if (attrName == 'city-name') {
            this.shadowRoot.getElementById('city').innerHTML = newValue
        }
            if (attrName == 'time-zone') {
                if (newValue != null) {
                    setInterval(() => {
                        this.showTime(newValue)
                    }, 1000);
                } else {
                    setInterval(() => {
                        this.showTime(0)
                    }, 1000);
                }
            }
    }
    showTime(tmz) {
        /*  this.generateBackground() */
        let self = this;
        let parsed_tmz = parseInt(tmz)
        console.log(tmz);
        console.log(parsed_tmz);

        let time = new Date();

        let hour = time.getHours() + (parsed_tmz); // [-/+]

        let min = time.getMinutes();
        let sec = time.getSeconds();

        let am_pm = "AM";

        if (hour > 12) {
            hour -= 12;
            am_pm = "PM";
        }

        if (hour <= 0) {
            hour = 12;
            am_pm = "AM";
        }

        // if hour < 10 --> 0 + hour else hour 
        hour = hour < 10 ? "0" + hour : hour;

        min = min < 10 ? "0" + min : min;

        sec = sec < 10 ? "0" + sec : sec;

        let currentTime = hour + ":" + min + ":" + sec + am_pm;

        self.shadowRoot.getElementById("clock").innerHTML = currentTime;
    }

}
// CUSTOM ELEMENT
window.customElements.define('my-clock', MyClock); //<my-clock>