package com.example.tp_3.Factory;

import com.example.tp_3.models.Batiment;

public interface BatimentFactory {
    Batiment createBatiment(String emplacement, int taille, String description);
}
