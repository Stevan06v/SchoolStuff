
function readAndShowDate() {
    // init the new request object
    const xhttp = new XMLHttpRequest();

    // define callback funtion
    xhttp.onload = function () {  
        // write the answer to the div box
        document.getElementById('output').innerHTML = this.responseText;
        console.log(this.responseText);
    }

    // set target url/path
    xhttp.open("GET", "date.txt?_=" + new Date().getTime(), true)

    // start ajax request 
    xhttp.send()
  }


setInterval(() => {
    readAndShowDate()
}, 2000);