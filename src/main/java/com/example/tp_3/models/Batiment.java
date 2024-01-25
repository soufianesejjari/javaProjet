package com.example.tp_3.models;

public interface Batiment {
    int getId();
    String getEmplacement();
    int getTaille();
    String getFonctionnalite();
    String getDescription();

    void setId(int id);
    void setEmplacement(String emplacement);
    void setTaille(int taille);
    void setFonctionnalite(String fonctionnalite);
    void setDescription(String description);
}
