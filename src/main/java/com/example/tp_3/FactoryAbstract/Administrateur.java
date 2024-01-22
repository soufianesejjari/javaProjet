package com.example.tp_3.FactoryAbstract;

public class Administrateur extends Personnel{
    public Administrateur(String nom, String prenom,  String identifiant) {
        super(nom, prenom, "Administrateur", identifiant);
    }

    @Override
    public void setFonction() {
        this.fonction="Administrateur";

    }
}
