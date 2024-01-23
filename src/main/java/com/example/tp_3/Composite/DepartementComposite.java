package com.example.tp_3.Composite;

import java.util.ArrayList;
import java.util.List;

public class DepartementComposite implements Departement {
    private List<Departement> departements = new ArrayList<>();
    private String nom;

    public DepartementComposite(String nom) {
        this.nom = nom;
    }

    public void ajouterDepartement(Departement departement) {
        departements.add(departement);
    }

    public void supprimerDepartement(Departement departement) {
        departements.remove(departement);
    }

    @Override
    public void afficherDetails() {
        System.out.println("Groupe de départements : " + nom);
        for (Departement departement : departements) {
            departement.afficherDetails();
        }
    }
}