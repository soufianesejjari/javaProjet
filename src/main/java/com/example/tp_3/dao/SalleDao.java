package com.example.tp_3.dao;


import com.example.tp_3.models.Salle;

import java.util.List;

public interface SalleDao {
    void addSalle(Salle Salle);
    Salle getSalleById(int id);
    List<Salle> getAllSalles();
    void updateSalle(Salle Salle);
    void deleteSalle(int id);
}
