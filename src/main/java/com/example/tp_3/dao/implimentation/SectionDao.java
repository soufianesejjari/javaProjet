package com.example.tp_3.dao.implimentation;

import com.example.tp_3.dao.SectionDaoI;
import com.example.tp_3.dao.DatabaseConnection;
import com.example.tp_3.models.Section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectionDao implements SectionDaoI {
    static Connection connection = DatabaseConnection.getConnection();

    @Override
    public void ajouterSection(Section section) {
        String query = "INSERT INTO Section (Nom_Section) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, section.getNomSection());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }

    @Override
    public Section getSectionById(int idSection) {
        Section section = null;
        String query = "SELECT * FROM Section WHERE ID_Section = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idSection);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    section = new Section(
                            resultSet.getInt("ID_Section"),
                            resultSet.getString("Nom_Section")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }

        return section;
    }

    @Override
    public List<Section> getAllSections() {
        List<Section> sections = new ArrayList<>();
        String query = "SELECT * FROM Section";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Section section = new Section(
                        resultSet.getInt("ID_Section"),
                        resultSet.getString("Nom_Section")
                );
                sections.add(section);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }

        return sections;
    }

    // Vous pouvez ajouter d'autres méthodes au besoin
}
