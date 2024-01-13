package com.example.tp_3.dao;


import com.example.tp_3.models.Etudiant;

import java.util.List;

public interface EtudiantDaoI {
    void ajouterEtudiant(Etudiant etudiant);
    Etudiant getEtudiantById(int id);
    List<Etudiant> getAllEtudiants();
    void updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(int id);
}
