package com.example.tp_3.models;

public class Departement {
        private int idDepartement;
        private String nomDepartement;

        // Constructeur par défaut
        public Departement() {
        }

        // Constructeur avec paramètres
        public Departement(int idDepartement, String nomDepartement) {
            this.idDepartement = idDepartement;
            this.nomDepartement = nomDepartement;
        }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }
}
