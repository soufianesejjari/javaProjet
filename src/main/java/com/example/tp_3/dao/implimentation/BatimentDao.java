package com.example.tp_3.dao.implimentation;

import com.example.tp_3.dao.BatimentDaoI;
import com.example.tp_3.dao.DatabaseConnection;
import com.example.tp_3.models.Batiment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatimentDao implements BatimentDaoI {
    static Connection connection
            = DatabaseConnection.getConnection();



        // Méthode pour ajouter un nouveau bâtiment à la base de données
        public void ajouterBatiment(Batiment batiment) {
            String query = "INSERT INTO Batiment (Emplacement, Taille, Fonctionnalite, Description) VALUES (?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, batiment.getEmplacement());
                preparedStatement.setInt(2, batiment.getTaille());
                preparedStatement.setString(3, batiment.getFonctionnalite());
                preparedStatement.setString(4, batiment.getDescription());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                // Gérer l'exception selon votre logique d'erreur
            }
        }

        // Méthode pour récupérer un bâtiment par son ID
        public Batiment getBatimentById(int idBatiment) {
            Batiment batiment = null;
            String query = "SELECT * FROM Batiment WHERE ID_Batiment = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idBatiment);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        batiment = new Batiment(
                                resultSet.getInt("ID_Batiment"),
                                resultSet.getString("Emplacement"),
                                resultSet.getInt("Taille"),
                                resultSet.getString("Fonctionnalite"),
                                resultSet.getString("Description")
                        );
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Gérer l'exception selon votre logique d'erreur
            }

            return batiment;
        }

        // Méthode pour récupérer tous les bâtiments de la base de données
        public List<Batiment> getAllBatiments() {
            List<Batiment> batiments = new ArrayList<>();
            String query = "SELECT * FROM Batiment";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Batiment batiment = new Batiment(
                            resultSet.getInt("ID_Batiment"),
                            resultSet.getString("Emplacement"),
                            resultSet.getInt("Taille"),
                            resultSet.getString("Fonctionnalite"),
                            resultSet.getString("Description")
                    );
                    batiments.add(batiment);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Gérer l'exception selon votre logique d'erreur
            }

            return batiments;
        }

        // Méthode pour mettre à jour un bâtiment dans la base de données
        public void updateBatiment(Batiment batiment) {
            String query = "UPDATE Batiment SET Emplacement = ?, Taille = ?, Fonctionnalite = ?, Description = ? WHERE ID_Batiment = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, batiment.getEmplacement());
                preparedStatement.setInt(2, batiment.getTaille());
                preparedStatement.setString(3, batiment.getFonctionnalite());
                preparedStatement.setString(4, batiment.getDescription());
                preparedStatement.setInt(5, batiment.getIdBatiment());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                // Gérer l'exception selon votre logique d'erreur
            }
        }

        // Méthode pour supprimer un bâtiment de la base de données
        public void deleteBatiment(int idBatiment) {
            String query = "DELETE FROM Batiment WHERE ID_Batiment = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idBatiment);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                // Gérer l'exception selon votre logique d'erreur
            }
        }
    }
