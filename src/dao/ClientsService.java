package dao;

import affichageObjet.ClientsAffiche;
import modele.Clients;

import java.sql.*;

/**
 * @author Illyes
 */
// La classe ClientsService permet d'effectuer des requêtes sur la table Clients de la base de données.
// Elle contient les fonctions suivantes : afficheLesClients(), afficheClient(), ajoutClient(), modifClient() et supprimeClient().
public class ClientsService {

    // La fonction afficheLesClients() permet d'afficher tous les clients de la table Clients. Elle prend en paramètre une connexion à la base de données.
    public static void afficheLesClients(Connection conn) throws SQLException {
        // La requête SQL pour récupérer tous les clients de la table Clients. Elle est stockée dans une variable de type String.
        String query = "SELECT * FROM Clients";
        // Création d'un objet de type Clients. Il sera utilisé pour stocker les informations de chaque client.
        Clients lesClients = new Clients();
        // Création d'un objet de type Statement. Il sera utilisé pour exécuter la requête SQL. Il est initialisé à null.
        try (Statement stmt = conn.createStatement()) {
            // Exécution de la requête SQL. Le résultat est stocké dans un objet de type ResultSet.
            ResultSet rs = stmt.executeQuery(query);
            // Tant qu'il y a des lignes dans le résultat, on récupère les informations de chaque client et on les stocke dans l'objet lesClients.
            while (rs.next()) {
                lesClients.setId(rs.getInt("id"));
                lesClients.setNumeroClient(rs.getInt("numeroClient"));
                lesClients.setNom(rs.getString("nom"));
                lesClients.setPrenom(rs.getString("prenom"));
                lesClients.setEmail(rs.getString("email"));
                lesClients.setAdresse(rs.getString("adresse"));
                // On affiche les informations du client.
                ClientsAffiche.afficherClient(lesClients);
            }
        }
    }

    // La fonction afficheClient() permet d'afficher les informations d'un client. Elle prend en paramètre une connexion à la base de données et l'ID du client à afficher.
    public static void afficheClient(Connection conn, int id) throws SQLException {
        // La requête SQL pour récupérer un client de la table Clients. Elle est stockée dans une variable de type String.
        String query = "SELECT * FROM Clients WHERE id = ?";
        // Création d'un objet de type Clients. Il sera utilisé pour stocker les informations du client.
        Clients leClient = new Clients();
        // Création d'un objet de type PreparedStatement. Il sera utilisé pour exécuter la requête SQL.
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // On remplace le ? de la requête SQL par l'ID du client à afficher.
            stmt.setInt(1, id);
            // Exécution de la requête SQL. Le résultat est stocké dans un objet de type ResultSet.
            ResultSet rs = stmt.executeQuery();
            // Si le résultat contient une ligne, on récupère les informations du client et on les stocke dans l'objet leClient.
            if (rs.next()) {
                leClient.setId(rs.getInt("id"));
                leClient.setNumeroClient(rs.getInt("numeroClient"));
                leClient.setNom(rs.getString("nom"));
                leClient.setPrenom(rs.getString("prenom"));
                leClient.setEmail(rs.getString("email"));
                leClient.setAdresse(rs.getString("adresse"));
                // On affiche les informations du client.
                ClientsAffiche.afficherClient(leClient);
            } else {
                // Si l'id ne correspond à aucun client, on affiche un message d'erreur.
                System.out.println("Aucun client trouve avec l'ID : " + id);
            }
        }

    }

    // La fonction ajoutClient() permet d'ajouter un client dans la table Clients. Elle prend en paramètre une connexion à la base de données.
    public static void ajoutClient(Connection conn) throws SQLException {
        // La requête SQL pour ajouter un client dans la table Clients. Elle est stockée dans une variable de type String.
        String query = "INSERT INTO Clients (numeroClient, nom, prenom, email, adresse) VALUES (?, ?, ?, ?, ?)";
        // Création d'un objet de type Clients. Il sera utilisé pour stocker les informations du client à ajouter.
        Clients leClient = ClientsAffiche.creerClient();
        // Création d'un objet de type PreparedStatement. Il sera utilisé pour exécuter la requête SQL.
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // On remplace les ? de la requête SQL par les informations du client à ajouter.
            stmt.setInt(1, leClient.getNumeroClient());
            stmt.setString(2, leClient.getNom());
            stmt.setString(3, leClient.getPrenom());
            stmt.setString(4, leClient.getEmail());
            stmt.setString(5, leClient.getAdresse());
            // Exécution de la requête SQL.
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Si une erreur se produit, on affiche un message d'erreur.
            System.out.println("Erreur lors de l'ajout du client : " + e.getMessage());
        }
    }

    // La fonction modifClient() permet de modifier un client dans la table Clients. Elle prend en paramètre une connexion à la base de données et l'ID du client à modifier.
    public static void modifClient(Connection conn, int id) throws SQLException {
        // La requête SQL pour modifier un client dans la table Clients. Elle est stockée dans une variable de type String.
        String query = "UPDATE Clients WHERE id = ? SET numeroClient = ?, nom = ?, prenom = ?, email = ?, adresse = ?";
        // Si l'id ne correspond à aucun client, on affiche un message d'erreur. Sinon, on continue.
        if (ClientsService.verifId(conn, id)) {
            // Création d'un objet de type Clients. Il sera utilisé pour stocker les informations du client à modifier.
            Clients leClient = ClientsAffiche.creerClient();
            // Création d'un objet de type PreparedStatement. Il sera utilisé pour exécuter la requête SQL.
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // On remplace les ? de la requête SQL par les informations du client à modifier.
                stmt.setInt(1, leClient.getNumeroClient());
                stmt.setString(2, leClient.getNom());
                stmt.setString(3, leClient.getPrenom());
                stmt.setString(4, leClient.getEmail());
                stmt.setString(5, leClient.getAdresse());
                stmt.setInt(6, id);
                // Exécution de la requête SQL.
                stmt.executeUpdate();
            } catch (SQLException e) {
                // Si une erreur se produit, on affiche un message d'erreur.
                System.out.println("Erreur lors de la modification du client : " + e.getMessage());
            }
        } else {
            // Si l'id ne correspond à aucun client, on affiche un message d'erreur.
            System.out.println("Aucun client trouve avec l'ID : " + id);
        }

    }


    // La fonction supprimeClient() permet de supprimer un client dans la table Clients. Elle prend en paramètre une connexion à la base de données et l'ID du client à supprimer.
    public static void supprimeClient(Connection conn, int id) throws SQLException {
        // La requête SQL pour supprimer un client dans la table Clients. Elle est stockée dans une variable de type String.
        String query = "DELETE FROM Clients WHERE id = ?";
        // Si l'id ne correspond à aucun client, on affiche un message d'erreur. Sinon, on continue.
        if (ClientsService.verifId(conn, id)) {
            // Création d'un objet de type PreparedStatement. Il sera utilisé pour exécuter la requête SQL.
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // On remplace le ? de la requête SQL par l'ID du client à supprimer.
                stmt.setInt(1, id);
                // Exécution de la requête SQL.
                stmt.executeUpdate();
            } catch (SQLException e) {
                // Si une erreur se produit, on affiche un message d'erreur.
                System.out.println("Erreur lors de la suppression du client : " + e.getMessage());
            }
        } else {
            // Si l'id ne correspond à aucun client, on affiche un message d'erreur.
            System.out.println("Aucun client trouve avec l'ID : " + id);
        }
    }

    // La fonction verifId() permet de vérifier si un client existe dans la table Clients. Elle prend en paramètre une connexion à la base de données et l'ID du client à vérifier.
    public static boolean verifId(Connection conn, int id) throws SQLException {
        // La requête SQL pour vérifier si un client existe dans la table Clients. Elle est stockée dans une variable de type String.
        String query = "SELECT 1 FROM Clients WHERE id = ?";
        // Création d'un objet de type PreparedStatement. Il sera utilisé pour exécuter la requête SQL.
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // On remplace le ? de la requête SQL par l'ID du client à vérifier.
            stmt.setInt(1, id);
            // Exécution de la requête SQL. Le résultat est stocké dans un objet de type ResultSet.
            ResultSet rs = stmt.executeQuery();
            // Si le résultat contient une ligne, on retourne true. Sinon, on retourne false.
            return rs.next();
        }
    }


}
