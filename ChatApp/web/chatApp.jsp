<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 18/02/2019
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Lekker Chatten" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Lekker Chatten" />
</jsp:include>
<main>
    <p>Welcome ${user.getFirstName()}!</p>
    <p id="currentstatus">Current Status: ${user.getStatus()}</p>
        <p>Change Status</p>
        <p>
            <input type="text" id="status" placeholder="Vult iet in">
            <input type="button" id="changeStatus" value="Change">
        </p>
        <br>
            <form method="get" action="Controller?action=LogOut">
                <input type="submit" id="logoutbutton" value="Log Out">
            </form>

    <!-- EPIK JQUERY THING -->
    <!--Creates the popup body-->
    <div class="popup-overlay">
        <!--Creates the popup content-->
        <div class="popup-content">
            <h2>Message Sent</h2>
            <!--popup's close button-->
            <button class="close">Close</button>
        </div>
    </div>

    <div id="lechat">
        <table id="friendlist">
        </table>

        <div id="lechatchat">
            <div id="lechatchatmessages">
                <p id="lechatchatmessagesname">

                </p>
                <input type="hidden" value="${user.getUserId()}"
                       id="from" name="from"/>
                <input type="hidden" id="to" name="to"/>
                <div id="lechatchatmessagesmessages">

                </div>
            </div>
            <div id="lechatchatinput">
                <input type="text" name="message" id="message">
                <button id="sendButton">Send</button>
            </div>
        </div>
    </div>

    <p>
        <input type="text" id="addFriend" name="addFriend">
        <input type="submit" id="addFriendButton"
               value="Add Friend">
    </p>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Lekker Chatten" />
</jsp:include>
<script src="scriptie.js"></script>
<script src="jquery.js"></script>
<script src="LekkerChatten.js"></script>
</body>
</html>
