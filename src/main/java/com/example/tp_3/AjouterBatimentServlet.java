package com.example.tp_3;
import com.example.tp_3.AdapterImpl.FeteAdapter;
import com.example.tp_3.AdapterImpl.SoutenanceAdapter;
import com.example.tp_3.Factory.AmphiFactory;
import com.example.tp_3.Factory.BatimentFactory;
import com.example.tp_3.Factory.SalleFactory;
import com.example.tp_3.dao.implimentation.AmphiDaoI;
import com.example.tp_3.dao.implimentation.SalleDaoI;
import com.example.tp_3.models.Amphi;
import com.example.tp_3.models.Batiment;
import com.example.tp_3.models.Salle;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

@WebServlet("/AjouterBatimentServlet")
public class AjouterBatimentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SalleDaoI salleDao;
    private AmphiDaoI amphiDao;
    @Override
    public void init() throws ServletException {
        super.init();
        salleDao = new SalleDaoI();
        amphiDao = new AmphiDaoI();
    }

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
            //SalleDao salleDao = new SalleDao();
            //salleDao.ajouterBatiment(batiment);
            salleDao.addSalle((Salle) batiment);


        } else if ("Amphi".equals(fonctionnalite)) {
            batimentFactory = new AmphiFactory();
            batiment = batimentFactory.createBatiment(emplacement, taille, description);;
            //AmphiDao amphiDao = new AmphiDao();
            //amphiDao.ajouterBatiment(batiment);
            amphiDao.addAmphi((Amphi) batiment);

        } else {
            throw new ServletException("Fonctionnalité inconnue : " + fonctionnalite);
        }
        List<Salle> salles = salleDao.getAllSalles();
        List<Amphi> amphis = amphiDao.getAllAmphis();
        request.setAttribute("salles", salles);
        request.setAttribute("amphis", amphis);
        request.getRequestDispatcher("fourmulaire.jsp").forward(request, response);
        request.getRequestDispatcher("fourmulaire.jsp").forward(request, response);
        //response.sendRedirect("index.jsp");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String action = request.getParameter("action");
        Batiment batiment = null;
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);

            if ("delete".equals(action)) {
                Salle salleToDelete = salleDao.getSalleById(id);
                Amphi amphiToDelete = amphiDao.getAmphiById(id);
                if (salleToDelete != null) {
                    salleDao.deleteSalle(id);
                    response.getWriter().println("Salle with ID " + id + " deleted successfully.");
                } else if (amphiToDelete != null) {
                    amphiDao.deleteAmphi(id);
                    response.getWriter().println("Amphi with ID " + id + " deleted successfully.");
                } else {
                    response.getWriter().println("Batiment with ID " + id + " not found.");
                }

            }
            if ("adapt".equals(action)) {
                Salle salleToAdapt = salleDao.getSalleById(id);
                Amphi amphiToToadapt = amphiDao.getAmphiById(id);
                if (salleToAdapt != null) {
                    FeteAdapter feteAdapter = new FeteAdapter(salleToAdapt);
                    //feteAdapter.setFonctionnalite("Fonctionnalite.");
                    request.setAttribute("feteAdapte",feteAdapter);
                } else if (amphiToToadapt != null) {
                    SoutenanceAdapter soutenanceAdapter = new SoutenanceAdapter(amphiToToadapt);
                    //soutenanceAdapter.setFonctionnalite("SALLE_DE_SOUTENANCE");
                    request.setAttribute("soutenanceAdapte",soutenanceAdapter);

                } else {
                    response.getWriter().println("Batiment with ID " + id + " not found.");
                }

            } else {
                Salle salle = salleDao.getSalleById(id);
                Amphi amphi = amphiDao.getAmphiById(id);
                if (salle != null) {
                    batiment = salle;
                } else if (amphi != null) {
                    batiment = amphi;
                } else {
                    response.getWriter().println("Batiment with ID " + id + " not found.");
                }
            }
        }
        List<Salle> salles = salleDao.getAllSalles();
        List<Amphi> amphis = amphiDao.getAllAmphis();
        request.setAttribute("batiment", batiment);
        request.setAttribute("salles", salles);
        request.setAttribute("amphis", amphis);
        request.getRequestDispatcher("fourmulaire.jsp").forward(request, response);
    }

}