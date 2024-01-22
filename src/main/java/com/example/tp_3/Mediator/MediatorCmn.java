package com.example.tp_3.Mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorCmn implements MediatorI{
    private List<Personnel> chefs ;

    public MediatorCmn() {
        this.chefs = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, Personnel user) {
        for (Personnel chef : this.chefs ){
            if(chef != user){
                chef.receive(msg);

            }

        }
    }

    @Override
    public void addUser(Personnel user) {
        chefs.add(user);


    }
}
