<%--
  Created by IntelliJ IDEA.
  User: ettalhaoui
  Date: 13/1/2024
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.tp_3.models.Section" %>
<%@ page import="com.example.tp_3.dao.implimentation.SectionDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Étudiant</title>
</head>
<body>
<h2>Ajouter un Étudiant</h2>
<form action="${pageContext.request.contextPath}/AjouterEtudiantServlet" method="post">
    <label for="nom">Nom:</label>
    <input type="text" name="nom" required><br>
    <label for="prenom">Prénom:</label>
    <input type="text" name="prenom" required><br>
    <label for="code">Code Étudiant:</label>
    <input type="text" name="code" required><br>
    <label for="situationScolaire">Situation Scolaire:</label>
    <input type="text" name="situationScolaire" required><br>

    <label for="idSection">Section:</label>
    <select name="idSection" required>
        <%
            SectionDao sectionDao = new SectionDao();
            List<Section> sections = sectionDao.getAllSections();

            for (Section section : sections) {
        %>
        <option value="<%= section.getIdSection() %>"><%= section.getNomSection() %></option>
        <% } %>
    </select><br>

    <button type="submit">Ajouter l'Étudiant</button>
</form>
</body>
</html>
