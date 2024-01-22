package com.example.tp_3.FactoryAbstract;

public class SalleEtudiantFactory implements Faculte{

    @Override
    public Personnel creeUser(String nom, String prenom, String identifiant) {
        return new Etudiant(nom,prenom,identifiant);
    }

    @Override
    public Batiment creeBatiment(String emplacement, int taille, String description) {
        return new Salle(emplacement,taille,description);
    }
}
