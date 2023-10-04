

/* 
function read_from_FETCH() {

    fetch("/PHP_UES/Vlajic_Ajax/Vlajic_Ajax_v2/date.php")
    
        .then((data) => {
            document.getElementById('output').innerHTML = ""+data

        }).catch(err => {
            console.log(err)
        })
}


 */
function get_Date_Out_Of_PHP() {

    const xhttp = new XMLHttpRequest();

    // define callback funtion
    xhttp.onload = function () {
        // write the answer to the div box
        document.getElementById('output').innerHTML = this.responseText;
        console.log(this.responseText);
    }


    xhttp.open("GET", "date.php", true)
    xhttp.send()

}

setInterval(() => {
    get_Date_Out_Of_PHP()
}, 2000)