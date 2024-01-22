package com.example.tp_3.FactoryAbstract;

public class AdministrationFactory implements Faculte{
    @Override
    public Personnel creeUser(String nom, String prenom, String identifiant) {
        return new Administrateur(nom,prenom,identifiant);
    }

    @Override
    public Batiment creeBatiment(String emplacement, int taille, String description) {
        return new Administration(emplacement,taille,description);
    }
}
