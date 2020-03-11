document.getElementById("changeStatus").
    onclick=changeStatus;
document.getElementById("addFriendButton").
    onclick=addFriend;

let setStatusRequest = new XMLHttpRequest();
let getStatusRequest = new XMLHttpRequest();
let getFriendlistRequest = new XMLHttpRequest();
let addFriendRequest = new XMLHttpRequest();

window.onload = DoeAlles;

function DoeAlles(){
    getStatus();
    getFriendlist();
}

function changeStatus(){
    var newStatus = document.getElementById("status").value;
    var information = "status=" +
        encodeURIComponent(newStatus);

    setStatusRequest.open("POST", "Controller?action=" +
        "setStatus",true);
    setStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    setStatusRequest.send(information);
}

function getStatus(){
    getStatusRequest.open("GET", "Controller?action=" +
        "getStatus", true);
    getStatusRequest.onreadystatechange = getData;
    getStatusRequest.send(null);
}

function getData () {
    if (getStatusRequest.readyState == 4) {
        if (getStatusRequest.status == 200) {
            var serverResponse = JSON.parse(getStatusRequest.responseText);
            var status = serverResponse.status;

            var statusfield = document.getElementById("currentstatus");
            var quoteParagraph = statusfield.childNodes[0];

            statusfield.innerText = "Current Status: " + status;

            setTimeout("getStatus()", 1000);
        }
    }
}

function getFriendlist() {
    getFriendlistRequest.open("GET", "Controller?action=" +
        "FriendList", true);
    getFriendlistRequest.onreadystatechange = getDataFriends;
    getFriendlistRequest.send(null);
}
function getDataFriends(){
    if(getFriendlistRequest.readyState == 4){
        if(getFriendlistRequest.status == 200){
            var serverResponse = JSON.parse(getFriendlistRequest.responseText);
            var friends = serverResponse.friends;

            var friendlistdiv = document.getElementById("friendlist");
            friendlistdiv.innerHTML = "";

            var heading = document.createElement("tr");
            var headnameText = document.createTextNode("Name");
            var headStatusText = document.createTextNode("Status");
            var headName = document.createElement("th");
            var headStatus = document.createElement("th");
            headName.appendChild(headnameText);
            headStatus.appendChild(headStatusText);
            heading.appendChild(headName);
            heading.appendChild(headStatus);

            friendlistdiv.appendChild(heading);
            for(var i = 0; i < friends.length; i++){
                var treetjen = document.createElement("tr");
                treetjen.id = friends[i].id;
                var tdken = document.createElement("td");
                var tdken2 = document.createElement("td");
                var naampeken = document.createTextNode(
                    friends[i].name);
                var statusken = document.createTextNode(
                    friends[i].status);
                tdken.appendChild(naampeken);
                tdken2.appendChild(statusken);
                treetjen.appendChild(tdken);
                treetjen.appendChild(tdken2);
                treetjen.setAttribute("id",
                    friends[i].email);
                treetjen.addEventListener("click",
                    openChat);
                friendlistdiv.appendChild(treetjen);
            }

            setTimeout("getFriendlist()", 2000);
        }
    }
}

function addFriend() {
    addFriendRequest.open("POST", "Controller?action=" +
        "addFriend", true);
    var id = document.getElementById("addFriend").value;
    var information = "id=" +
        encodeURIComponent(id);
    addFriendRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    addFriendRequest.send(information);
}

function openChat(){
    var ID = this.id;
    var to = document.getElementById("to");
    to.setAttribute("value",ID.toString());
    var nameplaatjen = document.getElementById
    ("lechatchatmessagesname").innerText = ID.toString();
}