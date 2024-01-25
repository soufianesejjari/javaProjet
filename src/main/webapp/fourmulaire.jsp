<%--
  Created by IntelliJ IDEA.
  User: sejja
  Date: 11/01/2024
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Ajouter un Bâtiment</h2>
<form action="${pageContext.request.contextPath}/BatimentServlet" method="post">
    <label for="emplacement">Emplacement :</label>
    <input type="text" id="emplacement" name="emplacement" required><br>

    <label for="taille">Taille :</label>
    <input type="number" id="taille" name="taille" required><br>

    <label for="fonctionnalite">Fonctionnalité :</label>
    <select id="fonctionnalite" name="fonctionnalite" required>
        <option value="Salle">Salle</option>
        <option value="Amphi">Amphi</option>
    </select><br>

    <label for="description">Description :</label>
    <textarea id="description" name="description" rows="4" required></textarea><br>




    <input type="submit" value="Ajouter">
</form>
</body>
</html>
