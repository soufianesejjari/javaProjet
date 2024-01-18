package com.example.tp_3.Factory;

import com.example.tp_3.models.Batiment;

public class AdministrationFactory implements BatimentFactory {
    @Override
    public Batiment createBatiment(String emplacement, int taille, String description) {
        return new Batiment(0, emplacement, taille, "Administration", description);
    }
}
