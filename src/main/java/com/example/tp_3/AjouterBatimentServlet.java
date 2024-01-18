package com.example.tp_3;
import com.example.tp_3.Factory.AdministrationFactory;
import com.example.tp_3.Factory.BatimentFactory;
import com.example.tp_3.Factory.ClasseFactory;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emplacement = request.getParameter("emplacement");
        int taille = Integer.parseInt(request.getParameter("taille"));
        String fonctionnalite = request.getParameter("fonctionnalite");
        String description = request.getParameter("description");

        BatimentFactory batimentFactory;
        if ("Classe".equals(fonctionnalite)) {
            batimentFactory = new ClasseFactory();
        } else if ("Administration".equals(fonctionnalite)) {
            batimentFactory = new AdministrationFactory();
        } else {
            throw new ServletException("Fonctionnalité inconnue : " + fonctionnalite);
        }

        Batiment nouveauBatiment = batimentFactory.createBatiment(emplacement, taille, description);

        BatimentDao batimentDao = new BatimentDao();
        batimentDao.ajouterBatiment(nouveauBatiment);

        response.sendRedirect("index.jsp");
    }
}