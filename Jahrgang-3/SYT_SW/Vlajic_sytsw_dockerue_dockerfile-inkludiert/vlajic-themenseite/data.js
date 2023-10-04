let getDogs = { list: [] };

let dog1 = {
    "name": 'wasserhund',
    "size": 70,
    "weight": 20,
    "maxAge": 13,
    "furrColor": 'brown',
    "price": 1500,
    "imgsrc": "./imgs/franz.jpg"
};
let dog2 = {
    "name": 'löwenhund',
    "size": 69,
    "weight": 50,
    "maxAge": 10,
    "furrColor": 'golden',
    "price": 3500,
    "imgsrc": "./imgs/lowe.jpg"
};
let dog3 = {
    "name": 'shitzu',
    "size": 26,
    "weight": 6,
    "maxAge": 15,
    "furrColor": 'brown',
    "price": 800,
    "imgsrc": "./imgs/shitzu.jpg"
};
let dog4 = {
    "name": 'husky',
    "size": 55,
    "weight": 15,
    "maxAge": 11,
    "furrColor": 'black&White',
    "price": 6500,
    "imgsrc": "./imgs/husky.jpg"
};
let dog5 = {
    "name": 'chihuahua',
    "size": 23,
    "weight": 3,
    "maxAge": 20,
    "furrColor": 'gold&yellow',
    "price": 700,
    "imgsrc": "./imgs/chihuahua.jpg"
};
let dog6 = {
    "name": 'zwetna',
    "size": 26,
    "weight": 4,
    "maxAge": 15,
    "furrColor": 'blackGrey',
    "price": 750,
    "imgsrc": "./imgs/zwetna.jpg"
};
let dog7 = {
    "name": 'mops',
    "size": 32,
    "weight": 7,
    "maxAge": 13,
    "furrColor": 'gold',
    "price": 850,
    "imgsrc": "./imgs/mops.jpg"
};
let dog8 = {
    "name": 'zwerghund',
    "size": 35,
    "weight": 6,
    "maxAge": 16,
    "furrColor": 'gold&white',
    "price": 1500,
    "imgsrc": "./imgs/zwerghund.jpg"
};
let dog9 = {
    "name": 'malteser',
    "size": 23,
    "weight": 4,
    "maxAge": 17,
    "furrColor": 'white',
    "price": 1000,
    "imgsrc": "./imgs/malteser.jpg"
};

getDogs.list.push(dog1);
getDogs.list.push(dog2);
getDogs.list.push(dog3);
getDogs.list.push(dog4);
getDogs.list.push(dog5);
getDogs.list.push(dog6);
getDogs.list.push(dog7);
getDogs.list.push(dog8);
getDogs.list.push(dog9);

// EXPORTIEREN
module.exports.getDogs = getDogs;