package com.example.tp_3;

import com.example.tp_3.dao.implimentation.PersonnelDao;
import com.example.tp_3.dao.DatabaseConnection;
import com.example.tp_3.models.Personnel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AfficherPersonnelsServlet")
public class AfficherPersonnelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Établir une connexion à la base de données (à adapter selon votre environnement)

        try {
            Connection connection = DatabaseConnection.getConnection();

            // Créer un objet PersonnelDao en passant la connexion
            PersonnelDao personnelDao = new PersonnelDao();

            // Récupérer la liste des personnels depuis la base de données
            List<Personnel> personnels = personnelDao.getAllPersonnel();

            // Afficher la liste des personnels dans la réponse HTTP
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Liste des Personnels</h2>");
            out.println("<ul>");

            for (Personnel personnel : personnels) {
                out.println("<li>" + personnel.getNom() + " " + personnel.getPrenom() + " - " + personnel.getFonction() + "</li>");
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
}
