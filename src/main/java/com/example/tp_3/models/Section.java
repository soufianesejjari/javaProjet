package com.example.tp_3.models;

import java.util.List;

public class Section {
    private int idSection;
    private String nomSection;
    private List<Etudiant> etudiants;  // Liste d'étudiants associés à la section

    public Section() {
    }
    // Constructeur avec paramètres
    public Section(int idSection, String nomSection) {
        this.idSection = idSection;
        this.nomSection = nomSection;
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public String getNomSection() {
        return nomSection;
    }

    public void setNomSection(String nomSection) {
        this.nomSection = nomSection;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
// Ajoutez des méthodes supplémentaires au besoin
}