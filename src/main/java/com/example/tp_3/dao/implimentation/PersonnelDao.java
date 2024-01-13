package com.example.tp_3.dao.implimentation;

import com.example.tp_3.dao.PersonnelDaoI;
import com.example.tp_3.dao.DatabaseConnection;
import com.example.tp_3.models.Personnel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonnelDao implements PersonnelDaoI {
    static Connection connection = DatabaseConnection.getConnection();

    @Override
    public void ajouterPersonnel(Personnel personnel) {
        String query = "INSERT INTO Personnel (Nom, Prenom, Fonction, Identifiant) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, personnel.getNom());
            preparedStatement.setString(2, personnel.getPrenom());
            preparedStatement.setString(3, personnel.getFonction());
            preparedStatement.setString(4, personnel.getIdentifiant());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }

    @Override
    public Personnel getPersonnelById(int idPersonnel) {
        Personnel personnel = null;
        String query = "SELECT * FROM Personnel WHERE ID_Personnel = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idPersonnel);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    personnel = new Personnel(
                            resultSet.getInt("ID_Personnel"),
                            resultSet.getString("Nom"),
                            resultSet.getString("Prenom"),
                            resultSet.getString("Fonction"),
                            resultSet.getString("Identifiant")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }

        return personnel;
    }

    @Override
    public List<Personnel> getAllPersonnel() {
        List<Personnel> personnelList = new ArrayList<>();
        String query = "SELECT * FROM Personnel";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Personnel personnel = new Personnel(
                        resultSet.getInt("ID_Personnel"),
                        resultSet.getString("Nom"),
                        resultSet.getString("Prenom"),
                        resultSet.getString("Fonction"),
                        resultSet.getString("Identifiant")
                );
                personnelList.add(personnel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }

        return personnelList;
    }

    @Override
    public void updatePersonnel(Personnel personnel) {
        String query = "UPDATE Personnel SET Nom = ?, Prenom = ?, Fonction = ?, Identifiant = ? WHERE ID_Personnel = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, personnel.getNom());
            preparedStatement.setString(2, personnel.getPrenom());
            preparedStatement.setString(3, personnel.getFonction());
            preparedStatement.setString(4, personnel.getIdentifiant());
            preparedStatement.setInt(5, personnel.getIdPersonnel());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }

    @Override
    public void deletePersonnel(int idPersonnel) {
        String query = "DELETE FROM Personnel WHERE ID_Personnel = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idPersonnel);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'erreur
        }
    }
}
