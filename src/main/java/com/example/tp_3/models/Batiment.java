package com.example.tp_3.models;
public class Batiment {
    private int idBatiment;
    private String emplacement;
    private int taille;
    private String fonctionnalite;
    private String description;

    // Constructeur par défaut
    public Batiment() {
    }

    // Constructeur avec paramètres
    public Batiment(int idBatiment, String emplacement, int taille, String fonctionnalite, String description) {
        this.idBatiment = idBatiment;
        this.emplacement = emplacement;
        this.taille = taille;
        this.fonctionnalite = fonctionnalite;
        this.description = description;
    }

    // Getters et Setters
    public int getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(int idBatiment) {
        this.idBatiment = idBatiment;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getFonctionnalite() {
        return fonctionnalite;
    }

    public void setFonctionnalite(String fonctionnalite) {
        this.fonctionnalite = fonctionnalite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
