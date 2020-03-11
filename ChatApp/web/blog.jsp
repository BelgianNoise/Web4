<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 26/02/2019
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Lekker Bloggen" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Lekker Bloggen" />
</jsp:include>

<main>
    <div>
        <p>Dit is een leuke blogpost over de lessen IP Major.
        Zelf ben ik niet zo een fan. Web 4, C++ en C# zijn 10x
        zo leuk, aan wat zou dit kunnen liggen, deel jullie
        meningen in mijn epische comment section die ik moet
        laten werken!</p>
        <input type="text" id="Name1" placeholder="Name">
        <input type="text" id="Comment1" placeholder="Comment">
        <input type="number" id="Rating1" placeholder="Rating / 10">
        <input type="submit" id="Post1" value="Post comment">
        <div id="Comments1">

        </div>
    </div>
    <div>
        <p>Rate deze blog post</p>
        <input type="text" id="Name2" placeholder="Name">
        <input type="text" id="Comment2" placeholder="Comment">
        <input type="number" id="Rating2" placeholder="Rating / 10">
        <input type="submit" id="Post2" value="Post comment">
        <div id="Comments2">

        </div>
    </div>
    <div>
        <p>Hoeveel zou jij op dit moment betalen voor
        een dodelijke injectie?</p>
        <input type="text" id="Name3" placeholder="Name">
        <input type="text" id="Comment3" placeholder="Comment">
        <input type="number" id="Rating3" placeholder="Rating / 10">
        <input type="submit" id="Post3" value="Post comment">
        <div id="Comments3">

        </div>
    </div>
    <div>
        <p>Stel u voor: het regent cocosnoten.
        Wat is dan de kans dat ge zo is rap rap naar
        winkel loopt om nog iets te halen?</p>
        <input type="text" id="Name4" placeholder="Name">
        <input type="text" id="Comment4" placeholder="Comment">
        <input type="number" id="Rating4" placeholder="Rating / 10">
        <input type="submit" id="Post4" value="Post comment">
        <div id="Comments4">

        </div>
    </div>
    <div>
        <p>Voor communicatie moeten wij zoveel zever doen
         manneken toch. Les geven? ik word geen leerkracht ofzo.
         Meelopen in een bedrijf, vindt maar is nen dag he als
        ge elke dag naar school moet en project dit en dat.
        jobbeurs hier, en dan nog iets daar. Valt allemaal dood.</p>
        <input type="text" id="Name5" placeholder="Name">
        <input type="text" id="Comment5" placeholder="Comment">
        <input type="number" id="Rating5" placeholder="Rating / 10">
        <input type="submit" id="Post5" value="Post comment">
        <div id="Comments5">

        </div>
    </div>
</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Lekker Bloggen" />
</jsp:include>
<script src="blogscript.js"></script>
</body>
</html>
