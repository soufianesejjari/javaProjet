package com.example.tp_3.Composite;

public class Main {
    public static void main(String[] args) {
        DepartementFeuille departement1 = new DepartementFeuille("Département 1");
        DepartementFeuille departement2 = new DepartementFeuille("Département 2");
        DepartementFeuille departement3 = new DepartementFeuille("Département 3");

        DepartementComposite groupe1 = new DepartementComposite("Groupe 1");
        groupe1.ajouterDepartement(departement1);
        groupe1.ajouterDepartement(departement2);

        DepartementComposite groupe2 = new DepartementComposite("Groupe 2");
        groupe2.ajouterDepartement(groupe1);
        groupe2.ajouterDepartement(departement3);

        groupe2.afficherDetails();
    }
}
