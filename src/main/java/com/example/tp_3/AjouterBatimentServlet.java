package com.example.tp_3;
import com.example.tp_3.dao.implimentation.BatimentDao;
import com.example.tp_3.models.Batiment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.PrintWriter;

@WebServlet("/AjouterBatimentServlet")
public class AjouterBatimentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        String emplacement = request.getParameter("emplacement");
        int taille = Integer.parseInt(request.getParameter("taille"));
        String fonctionnalite = request.getParameter("fonctionnalite");
        String description = request.getParameter("description");

        // Établir une connexion à la base de données (à adapter selon votre environnement)
        // ... (code pour établir la connexion)

        // Créer un objet BatimentDao en passant la connexion
        BatimentDao batimentDao = new BatimentDao();

        // Créer un nouvel objet Batiment avec les données du formulaire
        Batiment nouveauBatiment = new Batiment(0, emplacement, taille, fonctionnalite, description);

        // Ajouter le nouveau bâtiment à la base de données
        batimentDao.ajouterBatiment(nouveauBatiment);

        // Fermer la connexion à la base de données


        // Afficher la liste des bâtiments dans la réponse HTTP
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>ajoute des Bâtiments</h2>");
        out.println("<ul>");

        // Rediriger l'utilisateur vers une page de confirmation ou une autre page appropriée
        response.sendRedirect("index.jsp");

    }
}