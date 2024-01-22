package com.example.tp_3.Mediator;

public class ChefDepartement extends Personnel {
    private String departement;
    public ChefDepartement(MediatorI med, String name,String departement) {
        super(med, name);

        this.departement=departement;
    }

    @Override
    public void envoi(String msg) {
        System.out.println(this.name+": message envoye "+msg +" departement :"+ departement);
        mediator.sendMessage(msg,this);

    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name+" message reçu :"+msg);
    }
}
