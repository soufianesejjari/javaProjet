package com.example.tp_3.dao;

import com.example.tp_3.models.Amphi;

import java.util.List;

public interface AmphiDao {

    void addAmphi(Amphi amphi);

    Amphi getAmphiById(int id);

    List<Amphi> getAllAmphis();

    void updateAmphi(Amphi amphi);

    void deleteAmphi(int id);

}