package com.example.tp_3.FactoryAbstract;

public class Etudiant extends Personnel{
    public Etudiant(String nom, String prenom,  String identifiant) {
        super(nom, prenom, "Etudiant", identifiant);
    }

    @Override
    public void setFonction() {
        this.fonction="Administrateur";

    }
}
