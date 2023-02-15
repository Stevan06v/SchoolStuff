
// daten an server senden
let data = "bliblablub";

fetch(`home.php?data=${data}`)
    .then(res => {
        return res.text();
    })
    .then(data => {
        console.log(data);
    })
    .catch(err => {
        console.log(err);
    })


// daten vom server holen
fetch('home.php')
    .then(res => {
        return res.json();
    })
    .then(data => {
        console.log(data);
    })
    .catch(err => {
        console.log(err);
    })