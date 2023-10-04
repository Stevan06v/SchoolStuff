<<<<<<< HEAD
let dataDisplay = document.getElementById('data');
let json = "";
=======
let data ="";

fetch("./home.php?category="+data)
    .then(res=>{
        return res.json();
    })
    .then(data=>{
        console.log(data);
    })
    .catch(err=>{
        console.log(err);
    })


/* 
console.log(document.getElementById('send'));

>>>>>>> c8aa8d30aaa1c93c81e1ba6b50ea2d81d0c07f1f

function getData() {
    fetch(`home.php`)
        .then(res => {
            console.log(res);
            return res.json();
        })

        .then(data => {
            console.log(data);
            json = data;

            console.log(data[0]);
            dataDisplay.innerHTML = data;
        })
        .catch(err => {
            console.log(err);
        })
}


function sendBook(name) {
    dataDisplay.innerHTML = "";
    fetch(`home.php?book=${name}`)
        .then(res => {
            console.log(res);
            return res.json()
        })
        .then(data => {
            console.log(data);
            displayBook(data);
        })
        .catch(err => {
            console.log(err);
        })

}


function displayBook(jsonObj) {
    let html = `        
<div id="book">
    <h2 id="isbn">${jsonObj.isbn}</h2>
    <h2 id="title">${jsonObj.title}</h2>
    <p id="author">${jsonObj.author}</p>
    <img src="${jsonObj.cover}" alt="">
    <p id="year">${jsonObj.year}</p>
</div>
    `;

    dataDisplay.innerHTML+=html;
}




/*
function sendData() {

    var text = document.getElementById('text').value

    console.log(text);

    fetch(`./home.php?data=${text}`,{
        mode: 'cors',
        headers: {
          'Access-Control-Allow-Origin':'*'
        }
    })
        .then(res =>{
            console.log(res);
            return res.text()
        })
        .then(data => {
            console.log(data);
            document.getElementById('data').innerHTML=data
        })
        .catch(err => {
            console.log(err);
            document.getElementById('data').innerHTML=err
        })
}
 */