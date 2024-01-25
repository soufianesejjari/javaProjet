package com.example.tp_3.Adapter;

public class FeteFinEtudeAdapter implements UsageAdapter {
    private SalleDeCours salleDeCours;

    public FeteFinEtudeAdapter(SalleDeCours salleDeCours) {
        this.salleDeCours = salleDeCours;
    }

    @Override
    public void utiliser() {
        salleDeCours.organiserFeteFinEtude();
    }
}
