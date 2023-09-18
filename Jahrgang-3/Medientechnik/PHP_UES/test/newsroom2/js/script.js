let articles = document.getElementById('articles')


getAll()


function getCategory(category) {
    
    fetch(`./data/news-api.php?category=${category}`)
        .then(res => {
            return res.json();
        })
        .then(data => {
            if (category == "all") {
                getAll();
            } else {
                console.log(data);
                articles.innerHTML = generateArticle(data);
            }

        })
        .catch(err => {
            console.log(err);
        })
}




function getAll() {
    fetch(`./data/news-api.php?category=all`)
        .then(res => {
            return res.json();
        })
        .then(data => {

            for (let i = 0; i < data.sport.length; i++) {
                articles.innerHTML += generateArticle(data.sport);
            }

            for (let i = 0; i < data.science.length; i++) {
                articles.innerHTML += generateArticle(data.science);
            }

        })
        .catch(err => {
            console.log(err);
        })

}



function generateArticle(data) {

    let html = "";
    for (let i = 0; i < data.length; i++) {

        html += `
        <div class="article">
        <div class="title">${data[i].title}</div>
        <img src="${data[i].img}" alt="">
        <div class="message">${data[i].message}</div>
        <div class="date">${data[i].date}</div>
        <div class="author">${data[i].author}</div>
    </div>
        `;
    }

    return html;


}