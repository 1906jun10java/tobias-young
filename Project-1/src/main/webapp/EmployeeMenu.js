window.onload = function(){
	
	let managerStatus = true;
        menuOnLoad(managerStatus);
        document.getElementById("infoLink").addEventListener("click", ClickInfo);
        document.getElementById("reimburseLink").addEventListener("click", ClickReimbursement);
        if (managerStatus == true){
        	document.getElementById("managerLink").addEventListener("click", ClickManager);
        	
        	document.getElementById("employeeLink").addEventListener("click", ClickEmployee);
        }
        document.getElementById("logoutLink").addEventListener("click", ClickLogout);        
}

function removeElement(elementId) {
    // Removes an element from the document
    let element = document.getElementById(elementId);
    element.parentNode.removeChild(element);
}

function menuOnLoad(managerStatus){
	
    let info = document.createElement("li");
    info.id = "employeeInfo";
    info.class = "nav-item";
    let infoLink = document.createElement("a");
    infoLink.id = "infoLink";
    infoLink.class = "nav-link";
    infoLink.innerHTML = "<span>Your Info&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>";
    
    let reimbursement = document.createElement("li");
    reimbursement.id = "reimbursment";
    reimbursement.class = "nav-item";
    let reimburseLink = document.createElement("a");
    reimburseLink.id = "reimburseLink";
    reimburseLink.class = "nav-link";
    reimburseLink.innerHTML = "<p>Reimbursements&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</p>";
    
    let logout = document.createElement("li");
    logout.id = "logout";
    logout.class = "nav-item";
    let logoutLink = document.createElement("form");
    logoutLink.id = "logoutLink";
    logoutLink.class = "nav-link";
    logoutLink.action = "logout";
    let logoutButton = document.createElement("input");
    logoutButton.type = "submit";
    logoutButton.value = "Logout";

    info.appendChild(infoLink);
    reimbursement.appendChild(reimburseLink);
    logout.appendChild(logoutLink);

    let elem = document.getElementById("start");
    elem.append(info, reimbursement);

    if(managerStatus == true){
        let reimburseManager = document.createElement("li");
        reimburseManager.id = "reimburseManager";
        reimburseManager.class = "nav-item";
        let managerLink = document.createElement("a");
        managerLink.id =  "managerLink";
        managerLink.class = "nav-link";
        managerLink.innerHTML = "<p>Reimbursement Management&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</p>";
        
        let employeeManager = document.createElement("li");
        employeeManager.id = "employeeManager";
        employeeManager.class = "nav-item";
        let employeeLink = document.createElement("a");
        employeeLink.id = "employeeLink";
        employeeLink.class = "nav-link";
        employeeLink.innerHTML = "<p>Employee Management&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</p>";

        reimburseManager.appendChild(managerLink);
        employeeManager.appendChild(employeeLink);

        elem.append(reimburseManager);
        elem.append(employeeManager);
    }
    elem.append(logout);
    logout.append(logoutLink);
    logoutLink.append(logoutButton);
}

function ClickInfo(){
	//get info from database
	let dataJson;
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			data = xhr.response;	
			
			if(document.getElementById("pageDiv")){
				removeElement("pageDiv");
			}
			let pageDiv = document.createElement("div");
			pageDiv.id = "pageDiv";
			
			let employeeHeader = document.createElement("h1");
			employeeHeader.innerText = "Your Employee Information!";
			
			let editButton = document.createElement("button");
			editButton.id = "editButton";
			editButton.innerText = "Change Info";
			editButton.type="button";
			
			let elem = document.getElementById("display");
			elem.append(pageDiv);
			pageDiv.appendChild(employeeHeader);
			
			let infoForm = document.createElement("form");
			infoForm.id = "infoForm";
			
			let employeeName = document.createElement("input");
			employeeName.id = "employeeName";
			employeeName.name = "Name";
			employeeName.value = data.emp_name;
			
			let username = document.createElement("input");
			username.id = "employeeUsername";
			username.value = data.username;
			username.name = "Username";
			username.innerText = username.name;
			
			pageDiv.appendChild(infoForm);
			infoForm.append(employeeName, username, editButton);
			
			document.getElementById("editButton").addEventListener("click", updateUser);
		}
	};
	xhr.open("GET", "http://localhost:8087/Project-1/info");
	xhr.responseType = "json";
	xhr.send();
}

function updateUser(empId, username, name){
	empId = data.emp_id;
	username = employeeUsername.value;
	name = employeeName.value;
	let send = {"id":empId, "name":name, "username":username};
	let xhr = new XMLHttpRequest();
	xhr.open('GET', "http://localhost:8087/Project-1/updateInfo");
	xhr.setRequestHeader("Data", send);
	xhr.send();
	console.log(send);
}

function ClickReimbursement(){
	if(document.getElementById("pageDiv")){
		removeElement("pageDiv");
	}
	let pageDiv = document.createElement("div");
	pageDiv.id = "pageDiv";
	
	let reimbursementHeader = document.createElement("h1");
	reimbursementHeader.innerText = "Your Reimbursements";
	
	let elem = document.getElementById("display");
	elem.append(pageDiv);
	pageDiv.appendChild(reimbursementHeader);
}

function ClickManager(){
	if(document.getElementById("pageDiv")){
		removeElement("pageDiv");
	}
	let pageDiv = document.createElement("div");
	pageDiv.id = "pageDiv";
	
	let managerHeader = document.createElement("h1");
	managerHeader.innerText = "Manager Console";
	
	let elem = document.getElementById("display");
	elem.append(pageDiv);
	pageDiv.appendChild(managerHeader);
}

function ClickEmployee(){
	if(document.getElementById("pageDiv")){
		removeElement("pageDiv");
	}
	let pageDiv = document.createElement("div");
	pageDiv.id = "pageDiv";
	
	let employeeHeader = document.createElement("h1");
	employeeHeader.innerText = "Manage Employees";
	
	let elem = document.getElementById("display");
	elem.append(pageDiv);
	pageDiv.appendChild(employeeHeader);
}

function ClickLogout(){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200){
			console.log("Logout Successful");
		}
	};
	xhr.open("GET", "http://localhost:8087/Project-1/logout", true);
	xhr.send();
}
