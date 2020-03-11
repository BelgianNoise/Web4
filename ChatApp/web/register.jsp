<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 9/05/2019
  Time: 13:26
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
    <form method="POST" action="Controller?action=doRegister">
        <label for="achternaam">Achternaam:</label>
        <input type="text" id="achternaam" name="achternaam">
        <label for="voornaam">Voornaam:</label>
        <input type="text" id="voornaam" name="voornaam">
        <label for="email">E-mail:</label>
        <input type="text" id="email" name="email">
        <label for="geslacht">Geslacht:</label>
        <input type="text" id="geslacht", name="geslacht">
        <label for="pw">Paswoord</label>
        <input type="text" id="pw" name="pw">
        <label for="pw2">Herhaal paswoord:</label>
        <input type="text" id="pw2" name="pw2">
        <label for="leeftijd">Leeftijd:</label>
        <input type="text" id="leeftijd" name="leeftijd">
        <input type="submit" value="Register">
    </form>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Lekker Chatten" />
</jsp:include>
</body>
</html>
