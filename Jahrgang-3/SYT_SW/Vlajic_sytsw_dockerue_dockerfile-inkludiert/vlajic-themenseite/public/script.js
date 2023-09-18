let split
let sum=0;
let counter = 0
let c = 0
let erg
let i = 0
let randNumb=0
let xhttp = new XMLHttpRequest();

// define the callback function
more()
function more() {
    document.getElementById('randHead').innerHTML=""
    document.getElementById('rand').innerHTML=""
    document.getElementById('button1').innerHTML='<div id="btn" onclick="more()">Show more!</div>'
    c++;
    console.log(c);
    if (c >= 3) {
        document.getElementById('button').innerHTML = '<div id="btn" onclick="remove()">Show less!</div>'
    }
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            erg = JSON.parse(this.responseText);
            for (i = counter; i < counter + 3; i++) {
                document.getElementById('flex').innerHTML +=
                    `<div id="flex"><div id="container">
        <img src="${erg.list[i].imgsrc}" alt="">
       
        <h3 id="name">${erg.list[i].name.toUpperCase()}</h3>
        <div id="flex2">
        <ul>
        <h5 >Color:           ${erg.list[i].furrColor}</h5>
        <h5 >Weight:          ${erg.list[i].weight}kg</h5>
        <h5 >Size:            ${erg.list[i].size}cm</h5>
        <h5 >Max age:         ${erg.list[i].maxAge}Years</h5>
        <h5 >Price:           ${erg.list[i].price}€</h5>
        </ul>

        <center><div id="box2" onclick="getSum(${erg.list[i].price})"> Purchase</div></center>
        </div>
        </div>
        `
            }
            counter += 3;
        }
    }
    // set the target URL (public server path)
    xhttp.open("GET", "http://localhost:3000/getDogs/", true);
    // start AJAX request
    xhttp.send();
};



function remove() {
    document.getElementById('randHead').innerHTML==""
    document.getElementById('flex').innerHTML = ""
    document.getElementById('button').innerHTML = ""
    counter = 0
    c = 0;
    sum=0;
    document.getElementById('sum').innerHTML=sum+"€"
}

function getSum(price) {
    sum+=price;
    document.getElementById('sum').innerHTML = sum + "€"
}






function getRandomDog() {
    document.getElementById('randHead').innerHTML="<center><h1 id ='rH'>A random dog for you!</h1></center>"
    counter = 0
    c=0
       xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            erg = JSON.parse(this.responseText);
            document.getElementById('flex').innerHTML = ""
            randNumb = Math.floor(Math.random() * 8);
       
        document.getElementById('rand').innerHTML =
        `<div id="flex"><div id="container">
        <img src="${erg.list[randNumb].imgsrc}" alt="">
        
        <h3 id="name">${erg.list[randNumb].name.toUpperCase()}</h3>
        <div id="flex2">
        <ul>
        <h5 >Color:           ${erg.list[randNumb].furrColor}</h5>
        <h5 >Weight:          ${erg.list[randNumb].weight}kg</h5>
        <h5 >Size:            ${erg.list[randNumb].size}cm</h5>
        <h5 >Max age:         ${erg.list[randNumb].maxAge}Years</h5>
        <h5 >Price:           ${erg.list[randNumb].price}€</h5>
        </ul>
        
        <center><div id="box2" onclick="getSum(erg.list[i].price)"> Purchase</div></center>
        </div>
        </div>
        `
        }
    }
    // set the target URL (public server path)
    xhttp.open("GET", "http://localhost:3000/getDogs/", true);
    // start AJAX request
    xhttp.send();
};