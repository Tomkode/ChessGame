let currentPlayer = 1; // white
function main(){
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const player = urlParams.get('name');
    currentPlayer = player === 'Player2' ? 2 : 1;
    if(currentPlayer === 2){
        reverseBoard();
    }
    firstClickEvents();
}

/**
 * This function implements the click events for the cells
 * It assigns click event listeners for each IMG tag of each cell, avoiding the duplicate click event
 * in the case of assigning them to the DIV tags.If the currentplayer is 1(black) it will assign only
 * to the black cells, and only to white cells otherwise
 */
function firstClickEvents(){
    const imgs = document.querySelectorAll("img");
    for(let div = 0 ; div < 64 ; div++){ // there are 64 cells
        let imgSrc = imgs[div].src;
        //console.log(imgSrc)
        let color = ""
        if(imgSrc.search("black") !== -1)
            color = "black";
        else if (imgSrc.search("white") !== -1)
            color = "white";
        if((color === 'white' && currentPlayer === 1) || (color === 'black' && currentPlayer === 2)){
            imgs[div].addEventListener('click', highlightMoves )
        }

    }
}

/**
 * This function implements the click events for the cells
 * It sends a GET request to the server, which returns a list of possible moves for the piece
 * For each possible move, the function adds a click event listener to the cell, which will move the piece
 * @param event
 * @returns {Promise<void>}
 */
async function highlightMoves(event){
    const pieceId = event.target.parentNode.id;
    const response = await fetch("http://localhost:8080/move?position=" + pieceId);
    const moves = await response.json();
    if(moves != null) {
        resetHighlightedMoves();
        for (let indexId = 0; indexId < moves.length; indexId++) {
            const cell = document.getElementById(moves[indexId]);
            cell.classList.add("highlighted");
            cell.sourceCell = pieceId;
            cell.querySelector('img').addEventListener('click', movePiece);
        }
    }
}

/**
 * This function implements the click events for the highlighted cells
 * It sends a POST request to the server, which will move the piece
 * It also changes the current player
 * It also redirects the user to the page of the other player
 * @param event
 * @returns {Promise<void>}
 */
async function movePiece(event)
{
        console.log("The piece was moved!")
        event.target.parentNode.classList.remove("highlighted");
        const sourceCell = event.target.parentNode.sourceCell;
        await fetch("http://localhost:8080/movePiece?start=" + sourceCell + "&end=" + event.target.parentNode.id, {method: 'POST'});
        currentPlayer === 1 ? currentPlayer = 2 : currentPlayer = 1;
        location.assign("http://localhost:8080/hello?name=Player" + currentPlayer);
        event.target.removeEventListener('click', movePiece);
}

/**
 * This function removes the highlighted class from the cells
 */
function resetHighlightedMoves(){
    const highlightedCells = document.querySelectorAll(".highlighted");
    for(let indexId = 0 ; indexId < highlightedCells.length ; indexId++){
        highlightedCells[indexId].classList.remove("highlighted");
        highlightedCells[indexId].querySelector('img').removeEventListener('click', movePiece);
    }
}
function reverseBoard(){

    let divs = document.querySelector('.container').querySelectorAll("div");
    for(let div = 0 ; div < 32; div++){
        let div1 = divs[div];
        let div4 = divs[63 - div];
        let temp = div1.cloneNode(true);

        div1.innerHTML = div4.innerHTML;
        div1.className = div4.className;
        div1.id = div4.id;

        div4.innerHTML = temp.innerHTML;
        div4.className = temp.className;
        div4.id = temp.id;
    }
}
main();