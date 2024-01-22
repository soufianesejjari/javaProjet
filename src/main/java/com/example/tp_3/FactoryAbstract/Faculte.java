package com.example.tp_3.FactoryAbstract;

public interface Faculte {
    Personnel creeUser( String nom, String prenom,  String identifiant);
    Batiment creeBatiment(String emplacement, int taille, String description);
}
