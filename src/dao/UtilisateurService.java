package dao;

import modele.Utilisateurs;
import affichageObjet.UtilisateurAffiche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurService {
    public static void afficheTousLesUtilisateurs(Connection conn) throws SQLException {
        String query = "SELECT * FROM Utilisateurs";
        Utilisateurs utilisateur = new Utilisateurs();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
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

    public static void ajoutUtilisateur(Connection conn, Utilisateurs utilisateur) throws SQLException {
        String query = "INSERT INTO Utilisateurs (numeroEmploye, nom, prenom, email, login, motDePasse) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, utilisateur.getNumeroEmploye());
            stmt.setString(2, utilisateur.getNom());
            stmt.setString(3, utilisateur.getPrenom());
            stmt.setString(4, utilisateur.getEmail());
            stmt.setString(5, utilisateur.getLogin());
            stmt.setString(6, utilisateur.getPassword());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilisateur ajouté avec succès !");
            } else {
                System.out.println("Échec de l'ajout de l'utilisateur.");
            }
        }
    }

    public static void modifieUtilisateur(Connection conn, int id, Utilisateurs utilisateur) throws SQLException {
        String query = "UPDATE Utilisateurs SET numeroEmploye = ?, nom = ?, prenom = ?, email = ?, login = ?, motDePasse = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, utilisateur.getNumeroEmploye());
            stmt.setString(2, utilisateur.getNom());
            stmt.setString(3, utilisateur.getPrenom());
            stmt.setString(4, utilisateur.getEmail());
            stmt.setString(5, utilisateur.getLogin());
            stmt.setString(6, utilisateur.getPassword());
            stmt.setInt(7, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilisateur d'id " + id + " modifié avec succès !");
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID spécifié : " + id);
            }
        }
    }

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