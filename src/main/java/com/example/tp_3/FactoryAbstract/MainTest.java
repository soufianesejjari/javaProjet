package com.example.tp_3.FactoryAbstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez choisir le type de bâtiment (Etudiant/Administration) : ");
        String media = scanner.nextLine().toLowerCase();

        Faculte factory = null;
        if ("etudiant".equals(media)) {
            factory = new SalleEtudiantFactory();
        } else if ("administration".equals(media)) {
            factory = new AdministrationFactory();
        } else {
            System.out.println("Type de bâtiment non pris en charge.");
            System.exit(1);
        }

        List<Batiment> batiments = new ArrayList<>();
        List<Personnel> personnels = new ArrayList<>();

        System.out.println("Combien de bâtiments souhaitez-vous créer ?");
        int nombreBatiments = scanner.nextInt();

        System.out.println("Combien de personnels souhaitez-vous créer ?");
        int nombrePersonnels = scanner.nextInt();

        for (int i = 0; i < nombreBatiments; i++) {
            Batiment batiment = factory.creeBatiment("Emplacement" + i, 100 + i, "Fonctionnalite" + i);
            batiments.add(batiment);
        }

        for (int i = 0; i < nombrePersonnels; i++) {
            Personnel personnel = factory.creeUser("Nom" + i, "Prenom" + i, "ID" + i);
            personnels.add(personnel);
        }

        System.out.println("Liste des bâtiments créés :");
        for (Batiment batiment : batiments) {
            System.out.println("Nom de bâtiment : " + batiment.getEmplacement());
            System.out.println("Fonctionnalité : " + batiment.getFonctionnalite());
            System.out.println("------");
        }

        System.out.println("Liste du personnel créé :");
        for (Personnel personnel : personnels) {
            System.out.println("Nom de personnel : " + personnel.getNom());
            System.out.println("Fonction : " + personnel.getFonction());
            System.out.println("------");
        }
    }
}
