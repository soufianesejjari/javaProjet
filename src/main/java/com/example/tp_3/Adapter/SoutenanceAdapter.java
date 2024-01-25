package com.example.tp_3.Adapter;

public class SoutenanceAdapter implements UsageAdapter {
    private AmphiCours amphiCours;

    public SoutenanceAdapter(AmphiCours amphiCours) {
        this.amphiCours = amphiCours;
    }

    @Override
    public void utiliser() {
        amphiCours.organiserSoutenance();
    }
}
