package dao;

import affichageObjet.UtilisateurAffiche;
import modele.Utilisateurs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurService {
    // Méthode pour afficher tous les utilisateurs
    public static void afficheTousLesUtilisateurs(Connection conn) throws SQLException {
        String query = "SELECT * FROM Utilisateurs";
        Utilisateurs utilisateur = new Utilisateurs(); // Création d'une instance d'Utilisateurs
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // Récupération des données de la base et assignation à l'objet Utilisateurs
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNumeroEmploye(rs.getInt("numeroEmploye"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setLogin(rs.getString("login"));
                utilisateur.setPassword(rs.getString("motDePasse"));

                UtilisateurAffiche.afficherUtilisateur(utilisateur);
            }
        }
    }

    // Méthode pour afficher un utilisateur en fonction de son ID
    public static void afficheUtilisateur(Connection conn, int id) throws SQLException {
        String query = "SELECT * FROM Utilisateurs WHERE id = ?";
        Utilisateurs utilisateur = new Utilisateurs();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                utilisateur.setId(id);
                utilisateur.setNumeroEmploye(rs.getInt("numeroEmploye"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setLogin(rs.getString("login"));
                utilisateur.setPassword(rs.getString("motDePasse"));

                UtilisateurAffiche.afficherUtilisateur(utilisateur);
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID : " + id);
            }
        }
    }

    // Méthode pour ajouter un nouvel utilisateur
    public static void ajoutUtilisateur(Connection conn) throws SQLException {
        // La requête SQL pour ajouter un Utilisateur dans la table Utilisateurs. Elle est stockée dans une variable de type String.
        String query = "INSERT INTO Utilisateurs (numeroEmploye, nom, prenom, email, login, motDePasse) VALUES (?, ?, ?, ?, ?, ?)";
        // Création d'un objet de type Utilisateur. Il sera utilisé pour stocker les informations du client à ajouter.
        Utilisateurs utilisateur = UtilisateurAffiche.creerUtilisateur();
        // Création d'un objet de type PreparedStatement. Il sera utilisé pour exécuter la requête SQL.
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // On remplace les ? de la requête SQL par les informations du client à ajouter.
            stmt.setInt(1, utilisateur.getNumeroEmploye());
            stmt.setString(2, utilisateur.getNom());
            stmt.setString(3, utilisateur.getPrenom());
            stmt.setString(4, utilisateur.getEmail());
            stmt.setString(5, utilisateur.getLogin());
            stmt.setString(6, utilisateur.getPassword());
            // Exécution de la requête SQL.
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Si une erreur se produit, on affiche un message d'erreur.
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    // Méthode pour modifier un utilisateur existant en fonction de son ID
    public static void modifUtilisateur(Connection conn, int id) throws SQLException {
        // La requête SQL pour modifier un utilisateur dans la table Utilisateurs. Elle est stockée dans une variable de type String.
        String query = "UPDATE Utilisateurs SET numeroEmploye = ?, nom = ?, prenom = ?, email = ?, login = ?, motDePasse = ? WHERE id = ?";
        // Si l'id ne correspond à aucun client, on affiche un message d'erreur. Sinon, on continue.
        if (Verif.verifId(conn, id, "Utilisateurs")) {
            // Création d'un objet de type Utilisateur. Il sera utilisé pour stocker les informations du client à ajouter.
            Utilisateurs utilisateur = UtilisateurAffiche.creerUtilisateur();
            // Création d'un objet de type PreparedStatement. Il sera utilisé pour exécuter la requête SQL.
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // On remplace les ? de la requête SQL par les informations de l'utilisateur à modifier.
                stmt.setInt(1, utilisateur.getNumeroEmploye());
                stmt.setString(2, utilisateur.getNom());
                stmt.setString(3, utilisateur.getPrenom());
                stmt.setString(4, utilisateur.getEmail());
                stmt.setString(5, utilisateur.getLogin());
                stmt.setString(6, utilisateur.getPassword());
                stmt.setInt(7, id);
                // Exécution de la requête SQL.
                stmt.executeUpdate();
            } catch (SQLException e) {
                // Si une erreur se produit, on affiche un message d'erreur.
                System.out.println("Erreur lors de la modification de l'utilisateur : " + e.getMessage());
            }
        } else {
            // Si l'id ne correspond à aucun utilisateur, on affiche un message d'erreur.
            System.out.println("Aucun Utilisateur trouve avec l'ID : " + id);
        }
    }


    // Méthode pour supprimer un utilisateur en fonction de son ID
    public static void supprimeUtilisateur(Connection conn, int id) throws SQLException {
        String query = "DELETE FROM Utilisateurs WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilisateur supprimé avec succès !");
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID spécifié : " + id);
            }
        }
    }
}
