package com.example.tp_3.AdapterImpl;

import com.example.tp_3.models.Batiment;
import com.example.tp_3.models.Salle;

public class FeteAdapter implements Batiment {
    Salle salle;

    public FeteAdapter(Salle salle) {
        this.salle = salle;
    }

    @Override
    public int getId() {
        return salle.getId();
    }

    @Override
    public String getEmplacement() {
        return salle.getEmplacement();
    }

    @Override
    public int getTaille() {
        return salle.getTaille();
    }

    @Override
    public String getFonctionnalite() {
        // Change the fonctionnalite to SALLE_DE_FETE
        return "SALLE_DE_FETE";
    }

    @Override
    public String getDescription() {
        return salle.getDescription();
    }

    @Override
    public void setId(int id) {
        salle.setId(id);
    }

    @Override
    public void setEmplacement(String emplacement) {
        salle.setEmplacement(emplacement);
    }

    @Override
    public void setTaille(int taille) {
        salle.setTaille(taille);
    }

    @Override
    public void setFonctionnalite(String fonctionnalite) {
        salle.setFonctionnalite(fonctionnalite);
    }

    @Override
    public void setDescription(String description) {
        salle.setDescription(description);
    }
}
