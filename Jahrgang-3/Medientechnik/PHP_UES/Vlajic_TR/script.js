let input = ""
let output =""
let regex= /[-+]?[0-9]+[*\/]+[0-9]/g;
let regex2 = /[0-9]+[+-]+[0-9]+/g;
function inputchar(cal_input) {
    if (cal_input != "=") {
        input += cal_input
        document.getElementById('outputDisplay').innerHTML = input
    }else{
        document.getElementById('outputDisplay').innerHTML = output
    }
}

function cleardisplay() {
    input = ""
    document.getElementById('outputDisplay').innerHTML = input
}


function calculate() {
    if(input.match(regex) || input.match(regex2)){
         const xhttp = new XMLHttpRequest()
    // window.location.href = `calculator.php?passedStr=${input}`
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // Typical action to be performed when the document is ready:
                output = this.responseText;
                document.getElementById('outputDisplay').innerHTML = output
           
        }
    }
    xhttp.open("GET", "./calculator.php?data=" + input, true)

    xhttp.send() 
    input = ""
    document.getElementById('errormsg').innerHTML=""
    }else{
        document.getElementById('errormsg').innerHTML="Regex check failed! Try again!"
        input = ""
    }
   
}


