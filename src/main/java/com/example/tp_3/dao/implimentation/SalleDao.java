package com.example.tp_3.dao.implimentation;

// SalleDao.java
import com.example.tp_3.dao.BatimentDaoI;
import com.example.tp_3.dao.DatabaseConnection;
import com.example.tp_3.models.Batiment;
import com.example.tp_3.models.Salle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleDao implements BatimentDaoI {
    private static Connection connection = DatabaseConnection.getConnection();

    @Override
    public void ajouterBatiment(Batiment salle) {
        String query = "INSERT INTO Salle (Emplacement, Taille, Fonctionnalite, Description) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, salle.getEmplacement());
            preparedStatement.setInt(2, salle.getTaille());
            preparedStatement.setString(3, salle.getFonctionnalite());
            preparedStatement.setString(4, salle.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }

    @Override
    public Batiment getBatimentById(int id) {
        Batiment salle = null;
        String query = "SELECT * FROM Salle WHERE ID_Salle = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    salle = new Salle();
                    salle.setId(resultSet.getInt("ID_Salle"));
                    salle.setEmplacement(resultSet.getString("Emplacement"));
                    salle.setTaille(resultSet.getInt("Taille"));
                    salle.setFonctionnalite(resultSet.getString("Fonctionnalite"));
                    salle.setDescription(resultSet.getString("Description"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }

        return salle;
    }

    @Override
    public List<Batiment> getAllBatiments() {
        List<Batiment> salles = new ArrayList<>();
        String query = "SELECT * FROM Salle";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Salle salle = new Salle();
                salle.setId(resultSet.getInt("ID_Salle"));
                salle.setEmplacement(resultSet.getString("Emplacement"));
                salle.setTaille(resultSet.getInt("Taille"));
                salle.setFonctionnalite(resultSet.getString("Fonctionnalite"));
                salle.setDescription(resultSet.getString("Description"));
                salles.add(salle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }

        return salles;
    }

    @Override
    public void updateBatiment(Batiment salle) {
        String query = "UPDATE Salle SET Emplacement = ?, Taille = ?, Fonctionnalite = ?, Description = ? WHERE ID_Salle = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, salle.getEmplacement());
            preparedStatement.setInt(2, salle.getTaille());
            preparedStatement.setString(3, salle.getFonctionnalite());
            preparedStatement.setString(4, salle.getDescription());
            preparedStatement.setInt(5, salle.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }

    @Override
    public void deleteBatiment(int id) {
        String query = "DELETE FROM Salle WHERE ID_Salle = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }
}

