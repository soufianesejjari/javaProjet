package com.example.tp_3;

import com.example.tp_3.Factory.AmphiFactory;
import com.example.tp_3.Factory.BatimentFactory;
import com.example.tp_3.Factory.SalleFactory;
import com.example.tp_3.dao.implimentation.AmphiDao;
import com.example.tp_3.dao.implimentation.SalleDao;
import com.example.tp_3.models.Batiment;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/BatimentServlet")
public class BatimentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emplacement = request.getParameter("emplacement");
        int taille = Integer.parseInt(request.getParameter("taille"));
        String fonctionnalite = request.getParameter("fonctionnalite");
        String description = request.getParameter("description");

        BatimentFactory batimentFactory;
        Batiment batiment;
        if ("Salle".equals(fonctionnalite)) {
            batimentFactory = new SalleFactory();
            batiment = batimentFactory.createBatiment(emplacement, taille, description);;
            SalleDao salleDao = new SalleDao();
            salleDao.ajouterBatiment(batiment);

        } else if ("Amphi".equals(fonctionnalite)) {
            batimentFactory = new AmphiFactory();
            batiment = batimentFactory.createBatiment(emplacement, taille, description);;
            AmphiDao amphiDao = new AmphiDao();
            amphiDao.ajouterBatiment(batiment);
        } else {
            throw new ServletException("Fonctionnalité inconnue : " + fonctionnalite);
        }

        response.sendRedirect("index.jsp");
    }
}