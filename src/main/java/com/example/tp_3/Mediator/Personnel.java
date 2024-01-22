package com.example.tp_3.Mediator;

public abstract class  Personnel {
    protected MediatorI mediator;
    protected String name;

    public Personnel(MediatorI med, String name){
        this.mediator=med;
        this.name=name;
    }

    public abstract void envoi(String msg);

    public abstract void receive(String msg);



}
