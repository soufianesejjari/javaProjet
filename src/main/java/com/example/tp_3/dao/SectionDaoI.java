package com.example.tp_3.dao;

import com.example.tp_3.models.Section;

import java.util.List;

public interface SectionDaoI {

    void ajouterSection(Section section);

    Section getSectionById(int idSection);

    List<Section> getAllSections();

}