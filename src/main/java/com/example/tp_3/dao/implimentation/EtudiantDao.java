package com.example.tp_3.dao.implimentation;

import com.example.tp_3.dao.EtudiantDaoI;
import com.example.tp_3.dao.DatabaseConnection;
import com.example.tp_3.models.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDao implements EtudiantDaoI {
    static Connection connection = DatabaseConnection.getConnection();

    @Override
    public void ajouterEtudiant(Etudiant etudiant) {
        String query = "INSERT INTO Etudiant (Nom, Prenom, Code, Situation_Scolaire, ID_Section) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getCode());
            preparedStatement.setString(4, etudiant.getSituationScolaire());
            preparedStatement.setInt(5, etudiant.getIdSection());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Etudiant getEtudiantById(int idEtudiant) {
        Etudiant etudiant = null;
        String query = "SELECT * FROM Etudiant WHERE ID_Etudiant = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idEtudiant);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    etudiant = new Etudiant(
                            resultSet.getInt("ID_Etudiant"),
                            resultSet.getString("Nom"),
                            resultSet.getString("Prenom"),
                            resultSet.getString("Code"),
                            resultSet.getString("Situation_Scolaire"),
                            resultSet.getInt("ID_Section")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiant;
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM Etudiant";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant(
                        resultSet.getInt("ID_Etudiant"),
                        resultSet.getString("Nom"),
                        resultSet.getString("Prenom"),
                        resultSet.getString("Code"),
                        resultSet.getString("Situation_Scolaire"),
                        resultSet.getInt("ID_Section")
                );
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiants;
    }

    @Override
    public List<Etudiant> getEtudiantsBySection(int idSection) {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM Etudiant WHERE ID_Section = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idSection);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Etudiant etudiant = new Etudiant(
                            resultSet.getInt("ID_Etudiant"),
                            resultSet.getString("Nom"),
                            resultSet.getString("Prenom"),
                            resultSet.getString("Code"),
                            resultSet.getString("Situation_Scolaire"),
                            resultSet.getInt("ID_Section")
                    );
                    etudiants.add(etudiant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiants;
    }

    @Override
    public void updateEtudiant(Etudiant etudiant) {
        String query = "UPDATE Etudiant SET Nom = ?, Prenom = ?, Code = ?, Situation_Scolaire = ?, ID_Section = ? WHERE ID_Etudiant = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getCode());
            preparedStatement.setString(4, etudiant.getSituationScolaire());
            preparedStatement.setInt(5, etudiant.getIdSection());
            preparedStatement.setInt(6, etudiant.getIdEtudiant());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEtudiant(int idEtudiant) {
        String query = "DELETE FROM Etudiant WHERE ID_Etudiant = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idEtudiant);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
