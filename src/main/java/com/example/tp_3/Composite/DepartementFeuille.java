package com.example.tp_3.Composite;

public class DepartementFeuille implements Departement {
    private String nom;

    public DepartementFeuille(String nom) {
        this.nom = nom;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Département : " + nom);
    }
}
