/*package com.example.tp_3;

import com.example.tp_3.dao.DatabaseConnection;
import com.example.tp_3.models.Batiment;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AfficherBatimentServlet")
public class AfficherBatimentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Établir une connexion à la base de données (à adapter selon votre environnement)

        try {
            Connection connection = DatabaseConnection.getConnection();

            // Créer un objet BatimentDao en passant la connexion
            BatimentDao batimentDao = new BatimentDao();

            // Récupérer la liste des bâtiments depuis la base de données
            List<Batiment> batiments = batimentDao.getAllBatiments();

            // Afficher la liste des bâtiments dans la réponse HTTP
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Liste des Bâtiments</h2>");
            out.println("<ul>");

            for (Batiment batiment : batiments) {
                out.println("<li>" + batiment.getEmplacement() + " - " + batiment.getDescription() + "</li>");
            }

            out.println("</ul>");
            out.println("</body></html>");

            // Fermer la connexion à la base de données
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }
}*/
