var eersteKnoppie = document.getElementById("Post1");
eersteKnoppie.onclick = Post1;
var tweedeKnoppie = document.getElementById("Post2");
tweedeKnoppie.onclick = Post2;
var derdeKnoppie = document.getElementById("Post3");
derdeKnoppie.onclick = Post3;
var vierdeKnoppie = document.getElementById("Post4");
vierdeKnoppie.onclick = Post4;
var vijfdeKnoppie = document.getElementById("Post5");
vijfdeKnoppie.onclick = Post5;


var webSocket;
document.onload = openSocket();

function openSocket(){
    webSocket = new WebSocket("ws://localhost:8080/PostController");

    webSocket.onopen = function(event){
        console.log("Connection opened")
    };

    webSocket.onmessage = function(event){
        writeResponse(event.data);
    };

    webSocket.onclose = function(event){
        console.log("Connection closed");
    };
}

function send(getalleken){
    var name = document.getElementById("Name"+getalleken);
    var comment = document.getElementById("Comment"+getalleken);
    var rating = document.getElementById("Rating"+getalleken);
    var text = getalleken + "_" + name.value + "_" + comment.value +
        "_" + rating.value;
    console.log(text);
    name.value = "";
    comment.value = ""; //haha hacked
    rating.value = "";
    webSocket.send(text);
}

function closeSocket(){
    webSocket.close();
}

function writeResponse(text){

    var alleStrings = text.split("_");
    var commentsection = document.getElementById(
        "Comments"+alleStrings[0]);
    commentsection.innerHTML += "<div>";
    commentsection.innerHTML += "<p><b>" + alleStrings[1] + ":</b> "+
        alleStrings[2];
    commentsection.innerHTML += "<b>Rating: </b>" + alleStrings[3];
    commentsection.innerHTML += "</p>";
    commentsection.innerHTML += "</div>";
}

function Post1() {
    send(1);
}
function Post2() {
    send(2);
}
function Post3() {
    send(3);
}
function Post4() {
    send(4);
}
function Post5() {
    send(5);
}
