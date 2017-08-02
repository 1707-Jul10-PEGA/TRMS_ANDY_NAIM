/**
 * 
 */

$(document).ready(function(){
    $.post("Approvals",function(data){processForms(JSON.parse(data))});
});

function processForms(forms){
    var formsTable = document.getElementById("formstable");
    console.log(forms);
    for(var form in forms){
        var tr = document.createElement("tr");
        var x = forms[form];
        for(var i in x){
            var td = document.createElement("td");
            td.innerHTML = x[i];
            tr.append(td);
        }
        formsTable.append(tr);
    }
}

window.onload = function(){
    
    document.getElementById("approveforms").addEventListener("click", function(){redirect(this)}, false);
    document.getElementById("reimbursement").addEventListener("click", function(){redirect(this)}, false);
    document.getElementById("logout").addEventListener("click", function(){redirect(this)}, false);
}

function redirect(element){
    event.stopPropagation();
    if(element.id == "approveforms") {
        window.location.href = "/TRMSv1/Approvals.html" + location.search.substring(); //redirects to self
    }else if (element.id == "reimbursement") {
        window.location.href = "/TRMSv1/ReimbursementForm.html" + location.search.substring();
    }else if (element.id == "logout") {
        window.location.href = "/TRMSv1/LoginPage.html" + location.search.substring();
    }
}