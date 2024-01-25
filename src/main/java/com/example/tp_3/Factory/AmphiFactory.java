package com.example.tp_3.Factory;

import com.example.tp_3.models.Amphi;
import com.example.tp_3.models.Batiment;

public class AmphiFactory implements BatimentFactory{
    @Override
    public Batiment createBatiment(String emplacement, int taille, String description) {
        return new Amphi(0, emplacement, taille, "Amphi", description);
    }

}