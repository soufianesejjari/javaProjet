package com.example.tp_3.dao;
import com.example.tp_3.models.Personnel;
import java.util.List;

public interface PersonnelDaoI {
    void ajouterPersonnel(Personnel personnel);
    Personnel getPersonnelById(int id);
    List<Personnel> getAllPersonnel();
    void updatePersonnel(Personnel personnel);
    void deletePersonnel(int id);
}
