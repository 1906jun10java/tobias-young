let user = {};

window.onload = function(){
   populateEmployee();
    }
}

function populateEmployee(){
	//Send a GET to the SessionServlet
	fetch("http://localhost:8082/Project-1/session").then(function(response){
		return response.json();
	}).then(function(data){
		//check for valid session
		if(data.session === null){
			window.location = "http://localhost:8082/Project-1/login"
		} else {
			user = data;
			document.getElementById("username").innerText() = "username: " + user.username;
		}
	})
}
    
}