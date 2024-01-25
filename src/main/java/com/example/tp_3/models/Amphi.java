package com.example.tp_3.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Amphi implements Batiment {
    private int id;
    private String emplacement;
    private int taille;

    private String fonctionnalite ;
    private String description;
    public Amphi() {
    }
    public Amphi(int id, String emplacement, int taille, String fonctionnalite, String description) {
        this.id = id;
        this.emplacement = emplacement;
        this.taille = taille;
        this.fonctionnalite = fonctionnalite;
        this.description = description;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getEmplacement() {
        return emplacement;
    }

    @Override
    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    @Override
    public int getTaille() {
        return taille;
    }

    @Override
    public void setTaille(int taille) {
        this.taille = taille;
    }

    @Override
    public String getFonctionnalite() {
        return fonctionnalite;
    }

    @Override
    public void setFonctionnalite(String fonctionnalite) {
        this.fonctionnalite = fonctionnalite;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
