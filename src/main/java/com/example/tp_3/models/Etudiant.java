package com.example.tp_3.models;

public class Etudiant {

        private int idEtudiant;
        private String nom;
        private String prenom;
        private String code;
        private String situationScolaire;
        private int idSection;

    // Constructeur par défaut
        public Etudiant() {
        }

        // Constructeur avec paramètres
        public Etudiant(int idEtudiant, String nom, String prenom, String code, String situationScolaire,int idSection) {
            this.idEtudiant = idEtudiant;
            this.nom = nom;
            this.prenom = prenom;
            this.code = code;
            this.situationScolaire = situationScolaire;
            this.idSection =idSection;
        }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSituationScolaire() {
        return situationScolaire;
    }

    public void setSituationScolaire(String situationScolaire) {
        this.situationScolaire = situationScolaire;
    }
}
