package com.example.tp_3.FactoryAbstract;

public class Salle extends Batiment{
    public Salle(String emplacement, int taille,  String description) {
        super(emplacement, taille,"Salle",  description);
    }

    @Override
    public void setFonctionnalite() {
        this.fonctionnalite="salle";

    }
}
