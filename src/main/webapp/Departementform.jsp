<%--
  Created by IntelliJ IDEA.
  User: ettalhaoui
  Date: 23/1/2024
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Affichage des Départements</title>
</head>
<body>
<h2>Affichage des Départements</h2>
<form action="${pageContext.request.contextPath}/DepartementServlet" method="get">
  <input type="submit" value="Afficher les départements">
</form>
</body>
</html>

