function home() {
    window.location = "homePage.html"

}

function convert() {
    let costValue = parseInt(document.getElementById("costInput").value);
    const eventId = document.getElementById("event").value;
   ///console.log(eventId)
    ///console.log(typeof costValue)


    if(Number.isFinite(costValue)) {
        ///console.log(costValue)
        
  
        if(eventId == 1) {
            costValue = (80 / 100) * costValue;
            return alert(Math.round(costValue));
        } else if(eventId == 2) {
            costValue = (60 / 100) * costValue;
            return alert(Math.round(costValue));
        } else if(eventId == 3) {
            costValue = (75 / 100) * costValue;
            return alert(Math.round(costValue));
        } else if(eventId == 4) {
            //just return cost value but its symmetrical 
            costValue = (100 / 100) * costValue;
            return alert(Math.round(costValue));
        } else if(eventId == 5) {
            costValue = (90 / 100) * costValue;
            return alert(Math.round(costValue));
        } else if(eventId == 6) {
            costValue = (30 / 100) * costValue;
            return alert(Math.round(costValue));
        }

        
    } else {
        document.getElementById("showConvert").innerHTML = alert("You didn't put anyting into the cost value")
    }

    
}

async function addApproval() {
    const firstnameValue = document.getElementById("firstnameInput").value;
    const lastnameValue = document.getElementById("lastnameInput").value;
    const emailValue = document.getElementById("emailInput").value;
    const dateValue = document.getElementById("dateInput").value;
    const timeValue = document.getElementById("timeInput").value;
    const locationValue = document.getElementById("locationInput").value;
    const descriptionValue = document.getElementById("descriptionInput").value;
    let costValue = document.getElementById("costInput").value;
    const gradingFormatValue = document.getElementById("gradingFormatInput").value;
    const typeOfEvent = document.getElementById("event").value;




    const httpResponse = await fetch("http://localhost:7001/events");
    const eventBody = await httpResponse.json();
    //console.log(eventBody);

    let percent = null;
    let type = null;
    let eventGrade = null;
    let date = null;
    let eventId = null;

     for(event of eventBody) {
        if(event.eventId == typeOfEvent) {
            percent = event.eventPercentage;
            type = event.eventType;
            eventGrade = event.eventGradeApproval;
            date = event.eventStartDate; 
            eventId = event.eventId

        }
     }
  

    function convert(num) {
        if(eventId == 1) {
            num = (80 / 100) * num;
            return Math.round(num);
        } else if(eventId == 2) {
            num = (60 / 100) * num;
            return Math.round(num);
        } else if(eventId == 3) {
            num = (75 / 100) * num;
            return Math.round(num);
        } else if(eventId == 4) {
            //just return cost value but its symmetrical 
            num = (100 / 100) * num;
            return Math.round(num);
        } else if(eventId == 5) {
            num = (90 / 100) * num;
            return Math.round(num);
        } else if(eventId == 6) {
            num = (30 / 100) * num;
            return Math.round(num);
        }
   }
    costValue = convert(costValue);
    //console.log(costValue);
     //console.log(percent);
     //AvailableReimburstment = TotalReimburstment ($1000) � PendingReimburstments � AwardedReimburstments
    //console.log("Add approval!!!!!!!!!!")


    const ghttpResponse = await fetch("http://localhost:7001/grades");
    const gradeBody = await ghttpResponse.json();
    ///console.log(gradeBody)

    let gradeId = null;
    let gradeType = null;

    for(grade of gradeBody) {
        if(grade.gradeId == gradingFormatValue) {
            //console.log(grade);
           // console.log(gradingFormatValue);
            gradeId = grade.gradeId;
            gradeType = grade.gradeType;
        }
    }

    console.log(gradeId);
    console.log(gradeType);
 
    //.log(firstnameValue);
    //console.log(typeOfEvent);
   

    const approvalData = {
        approvalSupervisor: "pending",
        approvalDepartmenthead: "pending",
        approvalBenco: "pending",
        approvalFinal: "pending",
        approvalAmount: costValue,
        supervisorsDescription: "No comments at this time",
        supervisorsTime: "",
        departmentHeadDescription: "No comments at this time",
        departmentHeadTime: "",
        bencoDescription: "No comments at this time",
        bencoTime: "",
        approvalEmployeeId: {
            employee_id: sessionStorage.getItem("id"),
            firstnam: sessionStorage.getItem("firstName"),
            lastname: sessionStorage.getItem("lastName"),
            email: sessionStorage.getItem("email"),
            username: sessionStorage.getItem("username"),
            password: sessionStorage.getItem("password"),
            employeeSupervisorId: sessionStorage.getItem("SupervisorId"),
            employeeBenco: sessionStorage.getItem("Benco"),
            employeeDepartment: {
                departmentId: sessionStorage.getItem("Department"),
                departmentName: sessionStorage.getItem("DepartmentName"),
                departmentHead: sessionStorage.getItem("DepartmentHead")
            }, 
            employeeAwardedAmount: sessionStorage.getItem("awardedAmount")
        }
    }

   
    const approvalURL = "http://localhost:7001/approval";

    const approvalHttpResponse = await fetch(approvalURL, {
       method: "POST",
       body: JSON.stringify(approvalData)
   });

   const approvalBody = await approvalHttpResponse.json();

   //console.log(approvalBody);
   const generatedApprovalId = approvalBody.approvalId;
   const generatedApprovalAmount = approvalBody.approvalAmount;
   console.log(grade)


        const data = {
            formFirstname: firstnameValue,
            formLastname: lastnameValue,
            formEmail: emailValue,
            formDate: dateValue,
            formTime: timeValue,
            formLocation: locationValue,
            formDescription: descriptionValue,
            formCost: costValue,
            formGradingFormat: {
                gradeId: gradeId,
                gradeType: gradeType
            },
            formTypeOfEvent: {
                eventId: eventId,
                eventType: type,
                eventPercentage: percent,
                eventGradeApprovals: eventGrade,
                eventStartDate: date
            },
            formApprovals: {
                approvalId: generatedApprovalId,
                approvalSupervisor: "pending",
                approvalDepartmenthead: "pending",
                approvalBenco: "pending",
                approvalFinal: "pending",
                approvalAmount: generatedApprovalAmount,
                supervisorsDescription: "No comments at this time",
                supervisorsTime: "",
                departmentHeadDescription: "No comments at this time",
                departmentHeadTime: "",
                bencoDescription: "No comments at this time",
                bencoTime: "",
                approvalEmployeeId: {
                    employee_id: sessionStorage.getItem("id"),
                    firstnam: sessionStorage.getItem("firstName"),
                    lastname: sessionStorage.getItem("lastName"),
                    email: sessionStorage.getItem("email"),
                    username: sessionStorage.getItem("username"),
                    password: sessionStorage.getItem("password"),
                    employeeSupervisorId: sessionStorage.getItem("SupervisorId"),
                    employeeBenco: sessionStorage.getItem("Benco"),
                    employeeDepartment: {
                        departmentId: sessionStorage.getItem("Department"),
                        departmentName: sessionStorage.getItem("DepartmentName"),
                        departmentHead: sessionStorage.getItem("DepartmentHead")
                    }, 
                    employeeAwardedAmount: sessionStorage.getItem("awardedAmount")
                }
            },
            formEmployeeId: sessionStorage.getItem("id")

            
        
        }
        console.log(data);
        const url = "http://localhost:7001/form";

        const httpsResponse = await fetch(url, {
        method: "POST",
        body: JSON.stringify(data)
        });

        const formBody = await httpsResponse.json();

        //console.log(formBody);

        document.getElementById("response").innerHTML = (formBody && formBody != {}) ? alert("Successfully Added!") : alert("Ooops something went wrong please resubmit!");

        window.location = "homePage.html"






}

