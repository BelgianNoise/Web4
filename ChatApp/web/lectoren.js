document.getElementById("addRegi").
    onclick=addRegi;

window.onload = startPoll;
let getRegisRequest = new XMLHttpRequest();
let addRegiRequest = new XMLHttpRequest();

function addRegi(){
    addRegiRequest.open("POST", "Controller?action=" +
        "addRegistration", true);
    var naam = document.getElementById("naam").value;
    var vak = document.getElementById("vak").value;
    var aca = document.getElementById("aca").value;
    var info = "naam="+ encodeURIComponent(naam) +
    "&vak=" + encodeURIComponent(vak)+ "&aca="+
        encodeURIComponent(aca);

    addRegiRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    addRegiRequest.send(info);
}





function startPoll(){
    getRegisRequest.open("GET", "Controller?action=" +
        "getRegistraties", true);
    getRegisRequest.onreadystatechange = getData;
    getRegisRequest.send(null);
}

function getData () {
    if (getRegisRequest.readyState == 4) {
        if (getRegisRequest.status == 200) {
            var serverResponse = JSON.parse(getRegisRequest.responseText);
            var regis = serverResponse.regis;
            var registable = document.getElementById("lectoren");
            registable.innerHTML = "";


            for(var i = 0; i < regis.length; i++){
                var treetjen = document.createElement("tr");
                var tdken = document.createElement("td");
                var tdken2 = document.createElement("td");
                var tdken3 = document.createElement("td");
                var naam = document.createTextNode(
                    regis[i].naam);
                var vak = document.createTextNode(
                    regis[i].vak);
                var aca = document.createTextNode(
                    regis[i].academiejaar);
                tdken.appendChild(naam);
                tdken2.appendChild(vak);
                tdken3.appendChild(aca);
                treetjen.appendChild(tdken);
                treetjen.appendChild(tdken2);
                treetjen.appendChild(tdken3);
                registable.appendChild(treetjen);
            }


            setTimeout("startPoll()", 1000);
        }
    }
}