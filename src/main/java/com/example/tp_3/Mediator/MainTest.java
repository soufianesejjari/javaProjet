package com.example.tp_3.Mediator;

public class MainTest {
    public static void main (String[] args) {
        MediatorI med= new MediatorCmn();

        Personnel chefInfo= new ChefDepartement(med,"ahmed","informatique");
        Personnel chefMath= new ChefDepartement(med,"mohammed","Math");
        Personnel chefPC= new ChefDepartement(med,"Mustafa","Pc");

        med.addUser(chefInfo);
        med.addUser(chefMath);
        med.addUser(chefPC);

        chefInfo.envoi("salut");


    }
}
