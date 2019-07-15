window.onload = function(){
    document.getElementById("apiSubmit").onclick = function(){
        AjaxSendAndreceive('https://api.nasa.gov/planetary/apod?api_key=BTJVB7Ba6bQ0baVnsS2ic2JHyhxhjwhAbxnMNryn', space);
    }
}

function AjaxSendAndreceive(url, func){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status ==200){
            func(this);
        }
    }
    xhr.open("GET", url, true);
    xhr.send();
}

function space(xhr){
    let spaceObject = JSON.parse(xhr.responseText);
    console.log(spaceObject);
    document.getElementById("explanation").innerText = spaceObject.explanation;
    document.getElementById("image").src = spaceObject.hdurl;
}