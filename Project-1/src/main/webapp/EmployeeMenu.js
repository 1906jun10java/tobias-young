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
	let xhr = new XMLHttpRequest();
	
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
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			data = xhr.response;
			parse = JSON.parse(data);
			let submitted = document.createElement("h2");
			submitted.innerText = "Submitted Reimbursements"
			let table = document.createElement("table");
			table.id = "table";
			let headerRow = document.createElement("tr");
			let tableHeader1 = document.createElement("th");
			tableHeader1.innerHTML = "Reimbursement ID&nbsp&nbsp&nbsp&nbsp&nbsp";
			let tableHeader2 = document.createElement("th");
			tableHeader2.innerHTML = "Amount&nbsp&nbsp&nbsp&nbsp&nbsp";
			let tableHeader3 = document.createElement("th");
			tableHeader3.innerHTML = "Status&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
			let tableHeader4 = document.createElement("th");
			tableHeader4.innerText = "Reason";
			pageDiv.appendChild(submitted);
			pageDiv.appendChild(table);
			table.append(tableHeader1, tableHeader2, tableHeader3, tableHeader4);
			
			for(let r of parse){
				let row = document.createElement("tr");
				let id = document.createElement("td");
				id.innerText = r.reimbursementID;
				let amount = document.createElement("td");
				amount.innerText = r.reimbursementAmt;
				let status = document.createElement("td");
				status.innerText = r.status;
				let reason = document.createElement("td");
				reason.innerText = r.reason;
				
				row.append(id, amount, status, reason);
				table.append(row);
				
			}
		};
	}
	xhr.open("GET", "http://localhost:8087/Project-1/myReimburse");
	xhr.send();
	
	let addHeader = document.createElement("h2");
	addHeader.innerText = "Submit a new Reimbursement";
	
	let reimbursementForm = document.createElement("form");
	reimbursementForm.id = "reimForm";
	let entries = document.createElement("fieldset");
	let reimAmount = document.createElement("input");
	reimAmount.placeholder = "Reimbursement Amount";
	let reimReason = document.createElement("input");
	reimReason.placeholder = "Reason";
	let reimSubmit = document.createElement("button");
	reimSubmit.formaction = "newReim";
	reimSubmit.innerText = "Submit";
	reimSubmit.type = "button";
	
	entries.append(reimAmount, reimReason, reimSubmit);
	reimbursementForm.appendChild(entries);
	pageDiv.appendChild(addHeader)
	pageDiv.appendChild(reimbursementForm);
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
