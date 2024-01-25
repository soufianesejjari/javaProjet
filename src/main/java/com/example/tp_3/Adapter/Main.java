package com.example.tp_3.Adapter;

public class Main {
    public static void main(String[] args) {
        SalleDeCours salleDeCours = new SalleDeCours();
        AmphiCours amphiCours = new AmphiCours();

        // Adapter une salle de cours pour organiser une fête de fin d'étude
        UsageAdapter feteFinEtudeAdapter = new FeteFinEtudeAdapter(salleDeCours);
        feteFinEtudeAdapter.utiliser();

        // Adapter un amphi de cours pour organiser une soutenance
        UsageAdapter soutenanceAdapter = new SoutenanceAdapter(amphiCours);
        soutenanceAdapter.utiliser();
    }
}