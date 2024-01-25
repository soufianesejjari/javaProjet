<%@ page import="com.example.tp_3.models.Salle" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.tp_3.models.Amphi" %>
<%@ page import="com.example.tp_3.AdapterImpl.FeteAdapter" %>
<%@ page import="com.example.tp_3.AdapterImpl.SoutenanceAdapter" %><%--
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
<div>
<form action="${pageContext.request.contextPath}/AjouterBatimentServlet" method="post">
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

    <h2>Adapter</h2>
    <div>
        <% FeteAdapter feteAdapte = (FeteAdapter) request.getAttribute("feteAdapte");
        SoutenanceAdapter soutenanceAdapte =(SoutenanceAdapter) request.getAttribute("soutenanceAdapte");
        if (feteAdapte !=null) { %>
        <p>Adapted Fete :</p>
        <h2>ID: <%=feteAdapte.getId()%>  </h2>
        <h2>Emplacement: <%=feteAdapte.getEmplacement()%>  </h2>
        <h2>Taille: <%=feteAdapte.getTaille()%>  </h2>
        <h2>Fonctionnalite: <%=feteAdapte.getFonctionnalite()%>  </h2>
        <h2>Description: <%=feteAdapte.getDescription()%>  </h2>
        <% } else if(soutenanceAdapte !=null ){ %>
        <p>Adapted Soutenance :</p>
        <h2>ID: <%=soutenanceAdapte.getId()%>  </h2>
        <h2>Emplacement: <%=soutenanceAdapte.getEmplacement()%>  </h2>
        <h2>Taille: <%=soutenanceAdapte.getTaille()%>  </h2>
        <h2>Fonctionnalite: <%=soutenanceAdapte.getFonctionnalite()%>  </h2>
        <h2>Description: <%=soutenanceAdapte.getDescription()%>  </h2>
        <% } %>

    </div>
</div>

<aside id="customers">
    <h2>Batiments List</h2>
    <table style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Emplacement</th>
            <th>Taille</th>
            <th>Fonctionnalite</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% List<Salle> salles = (List<Salle>) request.getAttribute("salles");
            if (salles != null && !salles.isEmpty()) {
                for (Salle salle : salles) { %>
        <tr>
            <td><%= salle.getId() %>
            </td>
            <td><%= salle.getEmplacement() %>
            </td>
            <td><%= salle.getTaille() %>
            </td>
            <td><%= salle.getFonctionnalite() %>
            </td>
            <td><%= salle.getDescription() %>
            </td>
            <td>
                <a href="AjouterBatimentServlet?&action=adapt&id=<%= salle.getId() %>">
                    <button class="button button1">Adapt</button>
                </a>
                <a href="AjouterBatimentServlet?&action=delete&id=<%= salle.getId() %>">
                    <button class="button button3">Delete</button>
                </a>
            </td>
        </tr>
        <% }
        } %>

        <% List<Amphi> amphis = (List<Amphi>) request.getAttribute("amphis");
            if (amphis != null && !amphis.isEmpty()) {
                for (Amphi amphi : amphis) { %>
        <tr>
            <td><%= amphi.getId() %>
            </td>
            <td><%= amphi.getEmplacement() %>
            </td>
            <td><%= amphi.getTaille() %>
            </td>
            <td><%= amphi.getFonctionnalite() %>
            </td>
            <td><%= amphi.getDescription() %>
            </td>
            <td>
                <a href="AjouterBatimentServlet?&action=adapt&id=<%= amphi.getId() %>">
                    <button class="button button1">Adapt</button>
                </a>
                <a href="AjouterBatimentServlet?&action=delete&id=<%= amphi.getId() %>">
                    <button class="button button3">Delete</button>
                </a>
            </td>
        </tr>
        <% }
        } %>

        </tbody>
    </table>
</aside>

</body>
</html>
