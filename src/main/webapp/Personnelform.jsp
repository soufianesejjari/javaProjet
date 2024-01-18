<%--
  Created by IntelliJ IDEA.
  User: ettalhaoui
  Date: 13/1/2024
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Personnel</title>
</head>
<body>
<h2>Ajouter Personnel</h2>
<form action="${pageContext.request.contextPath}/AjouterPersonnelServlet" method="post">
    Nom: <input type="text" name="nom" required><br>
    Prénom: <input type="text" name="prenom" required><br>
    Fonction: <input type="text" name="fonction" required><br>
    Identifiant: <input type="text" name="identifiant" required><br>
    <input type="submit" value="Ajouter Personnel">
</form>
</body>
</html>
