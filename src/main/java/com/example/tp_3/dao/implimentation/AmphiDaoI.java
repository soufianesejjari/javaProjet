package com.example.tp_3.dao.implimentation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.example.tp_3.dao.AmphiDao;
import com.example.tp_3.dao.DatabaseConnection;
import com.example.tp_3.models.Amphi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmphiDaoI implements AmphiDao {
    static Connection connection = DatabaseConnection.getConnection();

    @Override
    public void addAmphi(Amphi amphi) {
        String query = "INSERT INTO Amphi (Emplacement, Taille, Fonctionnalite, Description) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, amphi.getEmplacement());
            preparedStatement.setInt(2, amphi.getTaille());
            preparedStatement.setString(3, amphi.getFonctionnalite());
            preparedStatement.setString(4, amphi.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your error handling logic
        }
    }

    @Override
    public Amphi getAmphiById(int idAmphi) {
        Amphi amphi = null;
        String query = "SELECT * FROM Amphi WHERE ID_Amphi = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idAmphi);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    amphi = new Amphi(
                            resultSet.getInt("ID_Amphi"),
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

        return amphi;
    }

    @Override
    public List<Amphi> getAllAmphis() {
        List<Amphi> amphis = new ArrayList<>();
        String query = "SELECT * FROM Amphi";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Amphi amphi = new Amphi(
                        resultSet.getInt("ID_Amphi"),
                        resultSet.getString("Emplacement"),
                        resultSet.getInt("Taille"),
                        resultSet.getString("Fonctionnalite"),
                        resultSet.getString("Description")
                );
                amphis.add(amphi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your error handling logic
        }

        return amphis;
    }

    @Override
    public void updateAmphi(Amphi amphi) {
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
            // Handle the exception based on your error handling logic
        }
    }

    @Override
    public void deleteAmphi(int idAmphi) {
        String query = "DELETE FROM Amphi WHERE ID_Amphi = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idAmphi);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your error handling logic
        }
    }
}
