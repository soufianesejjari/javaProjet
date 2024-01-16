package com.example.tp_3;

import com.example.tp_3.dao.implimentation.EtudiantDao;
import com.example.tp_3.models.Etudiant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/AfficherEtudiantsServlet")
public class AfficherEtudiantsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Créer un objet EtudiantDao
            EtudiantDao etudiantDao = new EtudiantDao();

            // Récupérer la liste des étudiants depuis la base de données
            List<Etudiant> etudiants = etudiantDao.getAllEtudiants();

            // Afficher la liste des étudiants dans la réponse HTTP
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Liste des Étudiants</h2>");
            out.println("<ul>");

            for (Etudiant etudiant : etudiants) {
                out.println("<li>" + etudiant.getNom() + " " + etudiant.getPrenom() + " - Code: " + etudiant.getCode() + "</li>");
            }

            out.println("</ul>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }
}
