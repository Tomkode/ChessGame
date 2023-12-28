const container = document.querySelector(".container");
const divs = container.querySelectorAll("div")
console.log('a'.charCodeAt(0) + parseInt('8'))
for( let div = 0 ; div < 64 ; div++){
    if((divs[div].id[0].charCodeAt(0) + parseInt(divs[div].id[1] )) % 2 === 0){
        divs[div].classList.add('black');
    }
    else
        divs[div].classList.add('white');
}