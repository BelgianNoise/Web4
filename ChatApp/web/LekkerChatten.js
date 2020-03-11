var getMessages = new XMLHttpRequest();

$.onload = Setup();

function Setup(){
    PollMessages();
}

function PollMessages(){
    var to = $("#to").val();
    var from = $("#from").val();
    $.get("Controller?action=getMessages&" +
        "from="+from+"&to="+to , function(data){
            var chatvenster = $("#lechatchatmessagesmessages");
            chatvenster.empty();
            console.log(data);

            var coords = 5;
            var vorigeFromMe = false;
            var eerste = true;

            $.each(data,function (i, message) {

                var fromMe = true;
                if(message.from != from){
                    fromMe = false;
                }

                if(!eerste && ((vorigeFromMe && fromMe) ||
                    (!vorigeFromMe && !fromMe))){
                    coords += 22;
                    eerste = false;
                }else{
                    coords = 5;
                }

                var p = $("<p style='margin-top:"+coords
                    +"px'></p>").text(message.message);
                if(fromMe){
                    $(p).addClass("me");
                }else{
                    $(p).addClass("other");
                }
                chatvenster.append(p);

                vorigeFromMe = fromMe;
            });
            setTimeout(PollMessages, 2000);
    })
}
$("#sendButton").click(function send(){
    var message = $("#message").val();
    $("#message").val("");
    var to = $("#to").val();
    var from = $("#from").val();

    $.ajax({
        type: "POST",
        url: "Controller?action=sendMessage",
        data: {
            "from": from,
            "to": to,
            "message": message
        },
        success: function() {
            $(".popup, .popup-content").addClass("active")
        },
        error: function(){alert("failed to send message")}
    });
});

// EPIK JQUERY POPUP
$(".close, .popup").on("click", function(){
    $(".popup, .popup-content").removeClass("active");
});
