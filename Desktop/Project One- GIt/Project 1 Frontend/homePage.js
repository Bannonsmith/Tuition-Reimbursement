function request() {

    //console.log(sessionStorage.getItem("firstName"));
    window.location = "Form.html";
}

function logout() {
    window.location = "login.html"

}

async function getApprovals() {
    
    const id = sessionStorage.getItem("id");
    const url = `http://localhost:7001/formsall/${id}`;
    const httpResponse = await fetch(url);
    const body = await httpResponse.json();

    console.log(body);



    document.getElementById("here").innerHTML =
    `
    <h3>Welcome Back: ${sessionStorage.getItem("username")}</h3>
    <h4>Awarded Amount: ${sessionStorage.getItem("awardedAmount")}<h4>
    `

    let resultsArray = []
    // resultsArray.push(`<ul id = 'list' `)
    // for(let b of body) {
    //     resultsArray.push(`<div>
    //                     <li>${b.approvalId}</li>
    //                     <li>${b.approvalSupervisor}</li>
    //                     <li>${b.approvalDepartmenthead}</li>
    //                     <li>${b.approvalBenco}</li>
    //                     <li>${b.approvalAmount}</li>
    //                         </div>`)
                      
    // };
    // resultsArray.push(`</ul`);
    resultsArray.push(`<table class="table table-bordered table-striped table-hover" style="width: 50%;">
   
    `)
    for(let b of body) {
 
     
        resultsArray.push(`
            <tr>
                <td>Application Number</td>
                <td id="id">${b.formId}</td>
                <td>Cost</td>
                <td id="id">${b.formCost}</td>
            </tr>
            <tr>
                <td>Event:</td>
                <td id="id">${b.formTypeOfEvent.eventType}</td>
                <td>Coverage Percentage:</td>
                <td id="id">${b.formTypeOfEvent.eventPercentage}</td>
            </tr>
            <tr>
                <td>Event Grade Requirement</td>
                <td id="id">${b.formTypeOfEvent.eventGradeApprovals}</td>
                <td>Grade:</td>
                <td id="id">${b.formGradingFormat.gradeType}</td>

            </tr>
 
            <tr>
                <td>Supervisor Approval</td>
                <td id="id">${b.formApprovals.approvalSupervisor}</td>
                <td id="id">${b.formApprovals.supervisorsDescription}</td>
                <td id="id">Timestamp:${b.formApprovals.supervisorsTime}</td>
            </tr>
            <tr>
                <td>Departmenthead Approval</td>
                <td id="id">${b.formApprovals.approvalDepartmenthead}</td>
                <td id="id">${b.formApprovals.departmentHeadDescription}</td>
                <td id="id">Timestamp:${b.formApprovals.departmentHeadTime}</td>
            </tr>
            <tr>
                <td>Departmenthead Approval</td>
                <td id="id">${b.formApprovals.approvalBenco}</td>
                <td id="id">${b.formApprovals.bencoDescription}</td>
                <td id="id"> Timestamp:${b.formApprovals.BencoTime}</td>
            </tr>
            <tr>
                <td>Presentation/Letter Grade
                <td><input type="file" class="custom-file-input" id="inputGroupFile04"></td>
          
            </tr>
            
            
            <tr>
                <td><br></td>
          
            </tr>
            <br>


        `)
    }
    resultsArray.push(`</table>`);

    document.getElementById("under").innerHTML = resultsArray.join('');


};

function updateApproval(id){

    console.log("Hello");
    console.log(id);

    let svote = document.getElementById("svote").value
    let st = document.getElementById("sTime").value
    let sd = document.getElementById("sDescription").value

    let bvote = document.getElementById("bvote").value
    let bt = document.getElementById("bTime").value
    let bd = document.getElementById("bDescription").value

    let dvote = document.getElementById("dvote").value
    let dd = document.getElementById("dDescription").value
    let dt = document.getElementById("dTime").value

    let ovote = document.getElementById("ovote").value
    let od = document.getElementById("oDescription").value

    let updatedAmount = document.getElementById("amountUpdated").value
    let ad = document.getElementById("aDescription").value


    
    console.log(updatedAmount)
    console.log(st)

    
    console.log("s:", svote, st, sd);
    console.log("b:", bvote, bt, bd);
    console.log("d:", dvote, dt, dd);
    console.log("o:", ovote, od, updatedAmount, ad);

    // const approvalUpdateData = {
    //     approvalSupervisor: svote,
    //     approvalDepartmenthead: dvote,
    //     approvalBenco: bvote,
    //     approvalFinal: ovote,
    //     approvalAmount: ,
    //     approvalEmployeeId: sessionStorage.getItem("id")
        
    // }

}

function supervisorPage() {
    const benco = sessionStorage.getItem("Benco");
    const supervisorId = sessionStorage.getItem("SupervisorId");
    const departmentHeadId = sessionStorage.getItem("DepartmentHeadId");
    const id = sessionStorage.getItem("id");
    console.log(id);
    console.log(benco);
    console.log(supervisorId);
    console.log(departmentHeadId);

    if(id == supervisorId || id == departmentHeadId || benco == true) {

        alert("Welcome: you have acccess to the supervisory portal");
        window.location = "supervisorPage.html"
    } else {
        alert("You don't have clearance to access this section. If you believe this is an error contact your supervisor.") 
  

    }


//     <tr>
//     <td>Supervisor Approval</td>
//     <td id="supervisor">${b.approvalSupervisor}</td>
//     <td id="supervisorDescription"> Message/Justification: ${b.supervisorsDescription}</td>
//     <td id="supervisorTime">TimeStamp: ${b.supervisorsTime}</td> 
// <tr>
//     <td>Departmenthead Approval</td>
//     <td id="departmenthead">${b.approvalDepartmenthead}</td>
//     <td id="departmentheadDescrip">Message/Justification: ${b.departmentHeadDescription}</td>
//     <td id="departmentHeadTime">TimeStamp: ${b.departmentHeadTime}</td>
// </tr>
// <tr>
//     <td>Benco Approval</td>
//     <td id="benco">${b.approvalBenco}</td>
//     <td id="bencoDescrip">Message/Justification: ${b.bencoDescription}</td>
//     <td id="bencoTime">TimeStamp: ${b.bencoTime}</td>
// </tr>


}
