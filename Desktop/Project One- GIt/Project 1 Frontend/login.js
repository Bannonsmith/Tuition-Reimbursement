async function getAllEmployees() {

    console.log("Get All Employees!");

    const httpResponse = await fetch("http://localhost:7001/employees");
    const body = await httpResponse.json();
    console.log(body);
}

async function login() {

    console.log("Login!!!!!!");

    const usernameValue = document.getElementById("usernameInput").value;
    const passwordValue = document.getElementById("passwordInput").value;


    const httpResponse = await fetch("http://localhost:7001/employees");
    const body = await httpResponse.json();
    console.log(body);
    const supervisors = [];
    
    for(let b of body) {
        supervisors.push(b.employeeSupervisorId);
    }

  

   
    console.log(supervisors);
    let valid = false;
    let info = null; 

    for(let b of body) {
        if(b.username == usernameValue && b.password == passwordValue) {
            console.log("Sucess");
            info = b; 
            valid = true;
            break;
        } else {
            console.log("Failure");
        }
    };
    console.log(info)
    console.log(supervisors);
    //console.log(info.employeeDepartment.departmentId)
    if(valid) {
        console.log("Logging in ");
        console.log(info);
        sessionStorage.setItem("id", info.employee_id);
        sessionStorage.setItem("firstName", info.firstname);
        sessionStorage.setItem("lastName", info.lastname);
        sessionStorage.setItem("email", info.email);
        sessionStorage.setItem("username", info.username);
        sessionStorage.setItem("password", info.password);
        sessionStorage.setItem("Benco", info.employeeBenco);
        sessionStorage.setItem("Department", info.employeeDepartment.departmentId);
        sessionStorage.setItem("DepartmentHeadId", info.employeeDepartment.departmentHeadEmployeeId);
        sessionStorage.setItem("DepartmentHead", info.employeeDepartment.departmentHead);
        sessionStorage.setItem("DepartmentName", info.employeeDepartment.departmentName);
        sessionStorage.setItem("SupervisorId", info.employeeSupervisorId);
        sessionStorage.setItem("awardedAmount", info.employeeAwardedAmount);
        sessionStorage.setItem("supervisors", JSON.stringify(supervisors))


        
        console.log(sessionStorage.getItem("firstName"));
        console.log(sessionStorage.getItem("lastName"));
        console.log(JSON.parse(sessionStorage.getItem("supervisors")));


        window.location = "homePage.html"
    } else {
        alert("You Login creditionals did not match anything in our database!!!")

    }

    function check(array1, array2) {
        for(let a of array1) {
            console.log(a)
            for(let i = 0; i < array1.length; x++) {
                console.log(array2[i])
                if(a.employeeSupervisorId == b) {
                    console.log("already there")
                } else {
                    array2.push(a.employeeSupervisorId);
                }
            }
        }
    }



}
