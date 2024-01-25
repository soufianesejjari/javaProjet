package com.example.tp_3.AdapterImpl;

import com.example.tp_3.models.Amphi;
import com.example.tp_3.models.Batiment;

public class SoutenanceAdapter implements Batiment {
    Amphi amphi;

    public SoutenanceAdapter(Amphi amphi) {
        this.amphi = amphi;
    }

    @Override
    public int getId() {
        return amphi.getId();
    }

    @Override
    public void setId(int id) {
        amphi.setId(id);
    }

    @Override
    public String getEmplacement() {
        return amphi.getEmplacement();
    }

    @Override
    public void setEmplacement(String emplacement) {
        amphi.setEmplacement(emplacement);
    }

    @Override
    public int getTaille() {
        return amphi.getTaille();
    }

    @Override
    public void setTaille(int taille) {
        amphi.setTaille(taille);
    }

    @Override
    public String getFonctionnalite() {
        return "SALLE_DE_SOUTENANCE";
    }

    @Override
    public void setFonctionnalite(String fonctionnalite) {
        amphi.setFonctionnalite(fonctionnalite);
    }

    @Override
    public String getDescription() {
        return amphi.getDescription();
    }

    @Override
    public void setDescription(String description) {
        amphi.setDescription(description);
    }
}
