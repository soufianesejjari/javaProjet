package com.example.tp_3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main (String[] args) {
        // Création de la configuration Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        // Création de la fabrique de sessions
        SessionFactory factory = configuration.buildSessionFactory();
        // Ouverture d'une session
        Session session = factory.openSession();
        // Début de la transaction
        session.beginTransaction();
        //Exécutez vos opérations de persistance ici Commit de la transaction
        session.getTransaction().commit();
        // Fermeture de la session
        session.close();
        // Fermeture de la fabrique de sessions
        factory.close();
    }
}
