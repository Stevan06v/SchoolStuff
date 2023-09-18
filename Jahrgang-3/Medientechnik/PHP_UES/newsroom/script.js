fetch('./data/news.json')
    .then((response) => response.json())
    .then((json) => 
    
        console.log(json.science[0]) 
    
    
    );
    
    fetch('./data/test.json')
    .then((response) => response.json())
    .then((json) => 
    
        console.log(json.science[0]) 
    
    
    );
    