package com.example.tp_3.models;

public class Etudiant {

        private int idEtudiant;
        private String nom;
        private String prenom;
        private String codeEtudiant;
        private String situationScolaire;

        // Constructeur par défaut
        public Etudiant() {
        }

        // Constructeur avec paramètres
        public Etudiant(int idEtudiant, String nom, String prenom, String codeEtudiant, String situationScolaire) {
            this.idEtudiant = idEtudiant;
            this.nom = nom;
            this.prenom = prenom;
            this.codeEtudiant = codeEtudiant;
            this.situationScolaire = situationScolaire;
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

    public String getCodeEtudiant() {
        return codeEtudiant;
    }

    public void setCodeEtudiant(String codeEtudiant) {
        this.codeEtudiant = codeEtudiant;
    }

    public String getSituationScolaire() {
        return situationScolaire;
    }

    public void setSituationScolaire(String situationScolaire) {
        this.situationScolaire = situationScolaire;
    }
}
