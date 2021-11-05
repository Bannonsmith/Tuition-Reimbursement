function home() {
    window.location = "homePage.html"

}
function logout() {
    window.location = "login.html"

}


async function getApprovals() {
    
    const id = sessionStorage.getItem("id");
    const benco = sessionStorage.getItem("Benco");
    const supervisor = sessionStorage.getItem("SupervisorId");
    const dhead = sessionStorage.getItem("DepartmentHeadId");


    const supervisorUrl = "http://localhost:7001/approvals"
    const httpResponse = await fetch(supervisorUrl);
    const body = await httpResponse.json();
    console.log("id",id);
    console.log("supervisor", supervisor);
    console.log("benco",benco);
    console.log("DH:",dhead);





    document.getElementById("here").innerHTML +=
    `
    <h3>Welcome Back: ${sessionStorage.getItem("username")}</h3>
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
        console.log("inside for loop", b);
        if(benco == true) {
  
            
   
            console.log("inside benco");
            resultsArray.push(`
                <tr>
                    <td>Application Number</td>
                    <td id="id">${b.approvalId}</td>
                    <td>FirstName</td>
                    <td id="id">${b.approvalEmployeeId.firstname}</td>
                    <td>LastName</td>
                    <td id="id">${b.approvalEmployeeId.lastname}</td>
                </tr>
                
                <tr>
                    <td>Supervisor Approval</td>
                    <td id="sa" value="${b.approvalSupervisor}"  >${b.approvalSupervisor}</td>
                    <td id="sd" > Message/Justification: ${b.supervisorsDescription}</td>
                    <td id="st" >TimeStamp: ${b.supervisorsTime}</td>
                    <td>
                        <label for="typeOfVote">Decision:</label>

                            <select name="vote" id="svote">
                                <option value="Pending">Pending</option>
                                <option value="Approve">Approve</option>
                                <option value="Deny">Deny</option>
                            </select>
                    </td>   
                    <td><input type="text" id="sDescription" value="${b.supervisorsDescription}" placeholder="Justification/Message to Employee"></input></td>
                    <td><input type="time" id="sTime" value="${b.supervisorsTime}" placeholder="Time"></input></td>
                    <td><button form="${b.approvalId}" onClick="updateApproval(${b.approvalId})" id="sbutton">Submit</button></td>   
                </tr>   
                <tr>
                    <td>Departmenthead Approval</td>
                    <td id="departmenthead">${b.approvalDepartmenthead}</td>
                    <td id="departmentheadDescrip">Message/Justification: ${b.departmentHeadDescription}</td>
                    <td id="departmentHeadTime">TimeStamp: ${b.departmentHeadTime}</td>
                    <td>
                    <label for="typeOfVote">Decision:</label>

                    <select name="vote" id="dvote" value="${b.approvalDepartmenthead}">
                            <option value="Pending">Pending</option>
                        <option value="Approve">Approve</option>
                        <option value="Deny">Deny</option>
                    </select>
                    </td>   
                    <td><input type="text" id="dDescription" value="${b.departmentHeadDescription}" placeholder="Justification/Message to Employee" disabled></input></td>
                    <td><input type="time" id="dTime" value="${b.departmentHeadTime}" placeholder="Time"></input></td>
                    <td><button form="${b.approvalId}" onClick="updateApproval(${b.approvalId})" id="dbutton">Submit</button></td> 
                    
                </tr>
                <tr>
                    <td>Benco Approval</td>
                    <td id="benco">${b.approvalBenco}</td>
                    <td id="bencoDescrip">Message/Justification: ${b.bencoDescription}</td>
                    <td id="bencoTime">TimeStamp: ${b.bencoTime}</td>


                    <td>
                    <label for="typeOfVote">Decision:</label>

                    <select name="vote" id="bvote">
                            <option value="Pending">Pending</option>
                        <option value="Approve">Approve</option>
                        <option value="Deny">Deny</option>
                    </select>
            </td>   
            <td ><input type="text" id="bDescription" value="${b.bencoDescription}" placeholder="Justification/Message to Employee"></input></td>
            <td ><input type="time" id="bTime" value="${b.bencoTime}" placeholder="Time"></input></td>
            <td><button form="${b.approvalId}" onClick="updateApproval(${b.approvalId})" id="bbutton">Submit</button></td> 
                </tr>
                <tr>
                    <td>Overall Approval</td>
                    <td id="final">${b.approvalFinal}</td>
                    <td id="overallDescrip">Message/Justification: ${b.overallDescription}</td>


                    <td>
                    <label for="typeOfVote">Decision:</label>

                    <select name="vote" id="ovote">
                            <option value="Pending">Pending</option>
                        <option value="Approve">Approve</option>
                        <option value="Deny">Deny</option>
                    </select>
            </td>   
            <td ><input type="text" id="oDescription" value="${b.overallDescription}" placeholder="Justification/Message to Employee"></input></td>
            <td><button form="${b.approvalId}" onClick="updateApproval(${b.approvalId})" id="obutton">Submit</button></td> 
                </tr>
                <tr>
                    <td>Amount</td>
                    <td id="amount">${b.approvalAmount}</td>
                    <td ><input type="number" id="amountUpdated" value="${b.approvalAmount}" placeholder="Change Amount"></input></td>
                    <td ><input type="text" id="aDescription" value="${b.overallDescription}"placeholder="Justification/Message to Employee"></input></td>
                    <td><button form="${b.approvalId}" onClick="updateApproval(${b.approvalId})" id="abutton">Submit</button></td>
                </tr>
                <tr>
                    <td><br></td>
            
                </tr>


            `)
        } else {
      
            console.log("inside else");
            console.log(b.approvalEmployeeId.employeeSupervisorId);
            if(id == b.approvalEmployeeId.employeeSupervisorId || id == b.approvalEmployeeId.employeeDepartment.departmentHeadEmployeeId) {
                console.log("inside else if");
                        console.log(b.approvalEmployeeId.employeeSupervisorId)
                    resultsArray.push(`
                    <tr>
                    <td>Application Number</td>
                    <td id="id">${b.approvalId}</td>
                    <td>FirstName</td>
                    <td id="id">${b.approvalEmployeeId.firstname}</td>
                    <td>LastName</td>
                    <td id="id">${b.approvalEmployeeId.lastname}</td>
                </tr>
                
                <tr>
                    <td>Supervisor Approval</td>
                    <td id="sa" value="${b.approvalSupervisor}"  >${b.approvalSupervisor}</td>
                    <td id="sd" > Message/Justification: ${b.supervisorsDescription}</td>
                    <td id="st" >TimeStamp: ${b.supervisorsTime}</td>
                    <td>
                        <label for="typeOfVote">Decision:</label>

                            <select name="vote" id="svote">
                                <option value="Pending">Pending</option>
                                <option value="Approve">Approve</option>
                                <option value="Deny">Deny</option>
                            </select>
                    </td>   
                    <td><input type="text" id="sDescription" value="${b.supervisorsDescription}" placeholder="Justification/Message to Employee"></input></td>
                    <td><input type="time" id="sTime" value="${b.supervisorsTime}" placeholder="Time"></input></td>
                    <td><button form="${b.approvalId}" onClick="updateApproval(${b.approvalId})" id="sbutton">Submit</button></td>   
                </tr>   
                <tr>
                    <td>Departmenthead Approval</td>
                    <td id="departmenthead">${b.approvalDepartmenthead}</td>
                    <td id="departmentheadDescrip">Message/Justification: ${b.departmentHeadDescription}</td>
                    <td id="departmentHeadTime">TimeStamp: ${b.departmentHeadTime}</td>
                    <td>
                    <label for="typeOfVote">Decision:</label>

                    <select name="vote" id="dvote" value="${b.approvalDepartmenthead}">
                            <option value="Pending">Pending</option>
                        <option value="Approve">Approve</option>
                        <option value="Deny">Deny</option>
                    </select>
                    </td>   
                    <td><input type="text" id="dDescription" value="${b.departmentHeadDescription}" placeholder="Justification/Message to Employee" disabled></input></td>
                    <td><input type="time" id="dTime" value="${b.departmentHeadTime}" placeholder="Time"></input></td>
                    <td><button form="${b.approvalId}" onClick="updateApproval(${b.approvalId})" id="dbutton">Submit</button></td> 
                    
                </tr>
                <tr>
                    <td>Benco Approval</td>
                    <td id="benco">${b.approvalBenco}</td>
                    <td id="bencoDescrip">Message/Justification: ${b.bencoDescription}</td>
                    <td id="bencoTime">TimeStamp: ${b.bencoTime}</td>


                    <td>
                    <label for="typeOfVote">Decision:</label>

                    <select name="vote" id="bvote">
                            <option value="Pending">Pending</option>
                        <option value="Approve">Approve</option>
                        <option value="Deny">Deny</option>
                    </select>
            </td>   
            <td ><input type="text" id="bDescription" value="${b.bencoDescription}" placeholder="Justification/Message to Employee"></input></td>
            <td ><input type="time" id="bTime" value="${b.bencoTime}" placeholder="Time"></input></td>
            <td><button form="${b.approvalId}" onClick="updateApproval(${b.approvalId})" id="bbutton">Submit</button></td> 
                </tr>
                <tr>
                    <td>Overall Approval</td>
                    <td id="final">${b.approvalFinal}</td>
                    <td id="overallDescrip">Message/Justification: ${b.overallDescription}</td>


                    <td>
                    <label for="typeOfVote">Decision:</label>

                    <select name="vote" id="ovote">
                            <option value="Pending">Pending</option>
                        <option value="Approve">Approve</option>
                        <option value="Deny">Deny</option>
                    </select>
            </td>   
            <td ><input type="text" id="oDescription" value="${b.overallDescription}"placeholder="Justification/Message to Employee"></input></td>
            <td><button form="${b.approvalId}" onClick="updateApproval(${b.approvalId})" id="obutton">Submit</button></td> 
                </tr>
                <tr>
                    <td>Amount</td>
                    <td id="amount">${b.approvalAmount}</td>
                    <td ><input type="number" id="amountUpdated" value="${b.approvalAmount}" placeholder="Change Amount"></input></td>
                    <td ><input type="text" id="aDescription" value="${b.overallDescription}"placeholder="Justification/Message to Employee"></input></td>
                    <td><button form="${b.approvalId}" onClick="updateApproval(${b.approvalId})" id="abutton">Submit</button></td>
                </tr>
                <tr>
                    <td><br></td>
            
                </tr>


            `)
                     
            }
        }    

        console.log("inside for loop");
        
    }
    resultsArray.push(`</table>`);

    document.getElementById("under").innerHTML = resultsArray.join('');

    // document.getElementById("dvote").disabled = "disabled";
    // document.getElementById("dDescription").disabled = "disabled";
    // document.getElementById("dTime").disabled = "disabled";
    // document.getElementById("dbutton").disabled = "disabled";
    // document.getElementById("svote").disabled = "disabled";
    // document.getElementById("sDescription").disabled = "disabled";
    // document.getElementById("sTime").disabled = "disabled";
    // document.getElementById("sbutton").disabled = "disabled";
    // document.getElementById("bvote").disabled = "disabled";
    // document.getElementById("bDescription").disabled = "disabled";
    // document.getElementById("bTime").disabled = "disabled";
    // document.getElementById("bbutton").disabled = "disabled";

    // document.getElementById("ovote").disabled = "disabled";
    // document.getElementById("oDescription").disabled = "disabled";
    // document.getElementById("obutton").disabled = "disabled";

    // // document.getElementById("oTime").disabled = "disabled";
    // document.getElementById("amountUpdated").disabled = "disabled";
    // document.getElementById("aDescription").disabled = "disabled";
    // document.getElementById("abutton").disabled = "disabled";





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