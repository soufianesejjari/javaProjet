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
    }
