<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Lectoren" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Lectoren" />
</jsp:include>

<table id="lectoren">
</table>

<label for="naam">Naam: </label>
<input type="text" name="naam" id="naam">
<label for="vak">Vak: </label>
<input type="text" name="vak" id="vak">
<label for="aca">Academiejaar: </label>
<input type="text" name="aca" id="aca">
<br>
<button id="addRegi">Voeg deze toe</button>
<br>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Lectoren" />
</jsp:include>
<script src="lectoren.js"></script>
</body>
</html>
