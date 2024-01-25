package com.example.tp_3.dao.implimentation;

// AmphiDao.java
import com.example.tp_3.dao.BatimentDaoI;
import com.example.tp_3.dao.DatabaseConnection;
import com.example.tp_3.models.Amphi;
import com.example.tp_3.models.Batiment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmphiDao implements BatimentDaoI {
    private static Connection connection = DatabaseConnection.getConnection();

    @Override
    public void ajouterBatiment(Batiment amphi) {
        String query = "INSERT INTO Amphi (Emplacement, Taille, Fonctionnalite, Description) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, amphi.getEmplacement());
            preparedStatement.setInt(2, amphi.getTaille());
            preparedStatement.setString(3, amphi.getFonctionnalite());
            preparedStatement.setString(4, amphi.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }

    @Override
    public Batiment getBatimentById(int id) {
        Batiment amphi = null;
        String query = "SELECT * FROM Amphi WHERE ID_Amphi = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    amphi = new Amphi();
                    amphi.setId(resultSet.getInt("ID_Amphi"));
                    amphi.setEmplacement(resultSet.getString("Emplacement"));
                    amphi.setTaille(resultSet.getInt("Taille"));
                    amphi.setFonctionnalite(resultSet.getString("Fonctionnalite"));
                    amphi.setDescription(resultSet.getString("Description"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }

        return amphi;
    }

    @Override
    public List<Batiment> getAllBatiments() {
        List<Batiment> amphis = new ArrayList<>();
        String query = "SELECT * FROM Amphi";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Amphi amphi = new Amphi();
                amphi.setId(resultSet.getInt("ID_Amphi"));
                amphi.setEmplacement(resultSet.getString("Emplacement"));
                amphi.setTaille(resultSet.getInt("Taille"));
                amphi.setFonctionnalite(resultSet.getString("Fonctionnalite"));
                amphi.setDescription(resultSet.getString("Description"));
                amphis.add(amphi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }

        return amphis;
    }

    @Override
    public void updateBatiment(Batiment amphi) {
        String query = "UPDATE Amphi SET Emplacement = ?, Taille = ?, Fonctionnalite = ?, Description = ? WHERE ID_Amphi = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, amphi.getEmplacement());
            preparedStatement.setInt(2, amphi.getTaille());
            preparedStatement.setString(3, amphi.getFonctionnalite());
            preparedStatement.setString(4, amphi.getDescription());
            preparedStatement.setInt(5, amphi.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }

    @Override
    public void deleteBatiment(int id) {
        String query = "DELETE FROM Amphi WHERE ID_Amphi = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }
}
