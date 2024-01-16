package com.example.tp_3;

import com.example.tp_3.dao.implimentation.EtudiantDao;
import com.example.tp_3.models.Etudiant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AjouterEtudiantServlet")
public class AjouterEtudiantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String code = request.getParameter("code");
        String situationScolaire = request.getParameter("situationScolaire");
        int idSection = Integer.parseInt(request.getParameter("idSection"));

        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setCode(code);
        etudiant.setSituationScolaire(situationScolaire);
        etudiant.setIdSection(idSection);

        EtudiantDao etudiantDao = new EtudiantDao();
        etudiantDao.ajouterEtudiant(etudiant);

        // Rediriger vers la page d'affichage des étudiants après l'ajout
        //response.sendRedirect(request.getContextPath() + "/AfficherEtudiantsServlet");
        response.sendRedirect("index.jsp");

    }
}

