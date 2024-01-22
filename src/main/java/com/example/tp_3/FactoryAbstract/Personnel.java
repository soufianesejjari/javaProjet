package com.example.tp_3.FactoryAbstract;

public abstract class Personnel {


    private String nom;
    private String prenom;
    protected String fonction;
    private String identifiant;

    // Constructeur par défaut
    public Personnel() {
    }

    // Constructeur avec paramètres
    public Personnel( String nom, String prenom, String fonction, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.identifiant = identifiant;
    }

    // Getters et Setters
    // ...




    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public abstract void setFonction() ;

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
}

