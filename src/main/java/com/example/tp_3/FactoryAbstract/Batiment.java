package com.example.tp_3.FactoryAbstract;

public abstract class  Batiment {
    private String emplacement;
    private int taille;
    protected String fonctionnalite;
    private String description;

    // Constructeur par défaut
    public Batiment() {
    }

    // Constructeur avec paramètres
    public Batiment( String emplacement, int taille,String fonctionnalite, String description) {
        this.emplacement = emplacement;

        this.taille = taille;
        this.fonctionnalite=fonctionnalite;
        this.description = description;
    }

    // Getters et Setters


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

    public abstract void setFonctionnalite( );

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
