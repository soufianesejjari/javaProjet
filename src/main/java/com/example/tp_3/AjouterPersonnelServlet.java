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
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/AjouterPersonnelServlet")
public class AjouterPersonnelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String fonction = request.getParameter("fonction");
        String identifiant = request.getParameter("identifiant");

        // Valider les paramètres (à adapter selon vos besoins)

        // Créer un objet Personnel avec les paramètres
        Personnel personnel = new Personnel();
        personnel.setNom(nom);
        personnel.setPrenom(prenom);
        personnel.setFonction(fonction);
        personnel.setIdentifiant(identifiant);

        try {
            // Établir une connexion à la base de données (à adapter selon votre environnement)
            Connection connection = DatabaseConnection.getConnection();

            // Créer un objet PersonnelDao en passant la connexion
            PersonnelDao personnelDao = new PersonnelDao();

            // Ajouter le personnel à la base de données
            personnelDao.ajouterPersonnel(personnel);

            // Fermer la connexion à la base de données
            connection.close();

            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }
}
