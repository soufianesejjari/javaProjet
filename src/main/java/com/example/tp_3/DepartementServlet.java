package com.example.tp_3;

import com.example.tp_3.Composite.Departement;
import com.example.tp_3.Composite.DepartementComposite;
import com.example.tp_3.Composite.DepartementFeuille;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/DepartementServlet")
public class DepartementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Créez vos objets de département ici
        Departement departement1 = new DepartementFeuille("Département 1");
        Departement departement2 = new DepartementFeuille("Département 2");
        Departement departement3 = new DepartementFeuille("Département 3");

        Departement groupe1 = new DepartementComposite("Groupe 1");
        ((DepartementComposite) groupe1).ajouterDepartement(departement1);
        ((DepartementComposite) groupe1).ajouterDepartement(departement2);

        Departement groupe2 = new DepartementComposite("Groupe 2");
        ((DepartementComposite) groupe2).ajouterDepartement(groupe1);
        ((DepartementComposite) groupe2).ajouterDepartement(departement3);

        // Affichez les détails
        groupe2.afficherDetails();
        request.getRequestDispatcher("/DepartementForm.jsp").forward(request, response);
    }
}
