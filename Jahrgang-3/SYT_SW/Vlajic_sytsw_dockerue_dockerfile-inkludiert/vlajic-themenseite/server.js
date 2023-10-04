// MODUL EINBETTEN & STARTEN
const express = require('express');
const app = express();

// SERVER KONFIGURIEREN
const port = 3000


// DATEN IMPORTIEREN aus data.js
const Data = require('./data');

console.log(Data.getDogs);


/* API Pokemon Liste */
app.get('/getDogs', (req, res) => {

    let answer = JSON.stringify(Data.getDogs);

    res.send(answer);

})

// STATIC MIDDLEWARE (FILES SERVIEREN)
let options = {
    extensions: ['html']
}
app.use(express.static('public', options))

// SERVER STARTEN
app.listen(port, () => {
    console.log('Server gestartet');
    console.log(`Erreichbar unter http://localhost:${port}`);
})