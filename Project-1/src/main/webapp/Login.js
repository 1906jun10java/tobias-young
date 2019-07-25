window.onload = function(){
	document.getElementById("submit").addEventListener("click", fetchUser);
}

function fetchUser(){
	fetch("http://localhost:8087/Project-1/login").then(data => console.log(JSON.stringify(data)))
	.catch(error => console.error(error));
}