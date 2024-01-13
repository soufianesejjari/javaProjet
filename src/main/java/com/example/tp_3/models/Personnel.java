package com.example.tp_3.models;

public class Personnel {

    private int idPersonnel;
    private String nom;
    private String prenom;
    private String fonction;
    private String identifiant;

    // Constructeur par défaut
    public Personnel() {
    }

    // Constructeur avec paramètres
    public Personnel(int idPersonnel, String nom, String prenom, String fonction, String identifiant) {
        this.idPersonnel = idPersonnel;
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.identifiant = identifiant;
    }

    // Getters et Setters
    // ...

    public int getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

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

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
}

