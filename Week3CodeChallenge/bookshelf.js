window.onload = function(){
    document.getElementById('addBook').onclick = function(){
        addBook(document.getElementById("title"), document.getElementById("author"),document.getElementById("genre"), document.getElementById("descrip"))
    }
}

function addBook(title, author, genre, description){
    let newLi = document.createElement("li", {class:"media"});
    let newA = document.createElement("a", {class:"d-flex", href:"#"});
    let newDiv = document.createElement("div", {class:"media-body"});
    let newTitle = document.createElement("h5", {innerText:title});
    let newAuthor = document.createElement("h5", {innerText:author});
    let newGenre = document.createElement("h5", {innerText:genre});
    let newDesc = document.createElement("h5", {innerText:description});
    let elem = document.getElementById("bookList");
    newDiv.appendChild(newTitle);
    newDiv.appendChild(newAuthor);
    newDiv.appendChild(newGenre);
    newDiv.appendChild(newDesc);
    newLi.appendChild(newA);
    newLi.appendChild(newDiv);
    elem.appendChild(newLi);
}