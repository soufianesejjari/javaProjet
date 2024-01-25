package com.example.tp_3.Factory;

import com.example.tp_3.models.Batiment;
import com.example.tp_3.models.Salle;

public class SalleFactory implements BatimentFactory{
    @Override
    public Batiment createBatiment(String emplacement, int taille, String description) {
        return new Salle(0, emplacement, taille, "Salle", description);
    }
}

