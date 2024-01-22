package com.example.tp_3.FactoryAbstract;

public class Administration extends Batiment{

    public Administration(String emplacement, int taille,  String description) {
        super(emplacement, taille, "Administration", description);
    }

    @Override
    public void setFonctionnalite() {
        this.fonctionnalite="administration";
    }
}
