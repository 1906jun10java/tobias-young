window.onload = function(){
    document.getElementById("start").onload = function(){
        menuOnLoad();
    }
}

function menuOnLoad(){
    let managerStatus = false;

    let info = document.createElement(li);
    info.id = "employeeInfo";
    info.class = "nav-item";
    let infoLink = document.createElement(a);
    infoLink.id = "infoLink";
    infoLink.class = "nav-link";
    infoLink.innerText = "Your Info";
    let reimbursement = document.createElement(li);
    reimbursement.id = "reimbursment";
    reimbursement.class = "nav-item";
    let reimburseLink = document.createElement(a);
    reimburseLink.id = "reimburseLink";
    reimburseLink.class = "nav-link";
    reimburseLink.innerText = "Reimbursements";
    let logout = document.createElement(li);
    logout.id = "logout";
    logout.class = "nav-item";
    let logoutLink = document.createElement(a);
    logoutLink.id = "logoutLink";
    logoutLink.class = "nav-link";

    info.appendChild(infoLink);
    reimbursement.appendChild(reimburseLink);
    logout.appendChild(logoutLink);

    let elem = document.getElementById("start");
    elem.append(info, reimbursement,logout);

    if(managerStatus === true){
        let reimburseManager = document.createElement(li);
        reimburseManager.id = "reimburseManager";
        reimburseManager.class = "nav-item";
        let managerLink = document.createElement(a);
        managerLink.id =  "managerLink";
        managerLink.class = "nav-link";
        managerLink.innerText = "Reimbursement Management";
        let employeeManager = document.createElement(li);
        employeeManager.id = "employeeManager";
        employeeManager.class = "nav-item";
        let employeeLink = document.createElement(a);
        employeeLink.id = "employeeLink";
        employeeLink.class = "nav-link";
        employeeLink.innerText = "Employee Management";

        reimburseManager.appendChild(managerLink);
        employeeManager.appendChild(employeeLink);

        elem.append(reimburseManager);
        elem.append(employeeManager);
    }
}