package com.example.tp_3.dao.implimentation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.example.tp_3.dao.DatabaseConnection;
import com.example.tp_3.dao.SalleDao;
import com.example.tp_3.models.Salle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleDaoI implements SalleDao {
    static Connection connection = DatabaseConnection.getConnection();

    @Override
    public void addSalle(Salle salle) {
        String query = "INSERT INTO Salle (Emplacement, Taille, Fonctionnalite, Description) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, salle.getEmplacement());
            preparedStatement.setInt(2, salle.getTaille());
            preparedStatement.setString(3, salle.getFonctionnalite());
            preparedStatement.setString(4, salle.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your error handling logic
        }
    }

    @Override
    public Salle getSalleById(int salleId) {
        Salle salle = null;
        String query = "SELECT * FROM Salle WHERE ID_Salle = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, salleId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    salle = new Salle(
                            resultSet.getInt("ID_Salle"),
                            resultSet.getString("Emplacement"),
                            resultSet.getInt("Taille"),
                            resultSet.getString("Fonctionnalite"),
                            resultSet.getString("Description")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your error handling logic
        }

        return salle;
    }

    @Override
    public List<Salle> getAllSalles() {
        List<Salle> salles = new ArrayList<>();
        String query = "SELECT * FROM Salle";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Salle salle = new Salle(
                        resultSet.getInt("ID_Salle"),
                        resultSet.getString("Emplacement"),
                        resultSet.getInt("Taille"),
                        resultSet.getString("Fonctionnalite"),
                        resultSet.getString("Description")
                );
                salles.add(salle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your error handling logic
        }

        return salles;
    }

    @Override
    public void updateSalle(Salle salle) {
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
            // Handle the exception based on your error handling logic
        }
    }

    @Override
    public void deleteSalle(int salleId) {
        String query = "DELETE FROM Salle WHERE ID_Salle = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, salleId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your error handling logic
        }
    }
}

