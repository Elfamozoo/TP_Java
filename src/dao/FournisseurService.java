package dao;

import modele.Fournisseur;
import affichageObjet.FournisseurAffiche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vincs
 */
public class FournisseurService {
    /**
     * 
     * @param conn : La connection a la bdd
     * @throws SQLException 
     * 
     * Cette methode recupere les fournisseurs present dans la bdd 
     * puis les affiches en utilisant la methode afficherFournisseur de FournisseurAffiche 
     */
    public static void afficheLesFournisseurs(Connection conn) throws SQLException {
	String query = "SELECT * FROM Fournisseurs";
        Fournisseur leFournisseur = new Fournisseur();
	try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                leFournisseur.setId(rs.getInt("id"));
                leFournisseur.setNumeroFournisseur(rs.getInt("numeroFournisseur"));
                leFournisseur.setNom(rs.getString("nom"));
                leFournisseur.setEmail(rs.getString("email"));
                leFournisseur.setAdresse(rs.getString("adresse"));
                
                FournisseurAffiche.afficherFournisseur(leFournisseur);
            }
	}
    }
    
    /**
     * 
     * @param conn : La connection a la bdd
     * @param id (int) : l'id du fournisseur a afficher
     * @throws SQLException
     * 
     * Cette methode prend en argument un id
     * Puis, si un fournisseur qui porte cet id se trouve dans la bdd, 
     * il s'affiche en utilisant la methode afficherFournisseur de FournisseurAffiche 
     * Sinon, un message d'erreur s'affiche
     */
    public static void afficheFournisseur(Connection conn, int id) throws SQLException {
	String query = "SELECT * FROM Fournisseurs WHERE id = ?";
        Fournisseur leFournisseur = new Fournisseur();
	try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                leFournisseur.setId(id);
                leFournisseur.setNumeroFournisseur(rs.getInt("numeroFournisseur"));
                leFournisseur.setNom(rs.getString("nom"));
                leFournisseur.setEmail(rs.getString("email"));
                leFournisseur.setAdresse(rs.getString("adresse"));
                
                FournisseurAffiche.afficherFournisseur(leFournisseur);
            } else {
		System.out.println("Aucun fournisseur trouve avec l'ID : " + id);
            }
	}
    }
    
    /**
     * 
     * @param conn : : La connection a la bdd
     * @throws SQLException 
     * 
     * Cette methode appele la methode creerFournisseur de FournisseurAffiche
     * pour creer un Fournisseur qui sera ensuite ajouter dans la bdd
     */
    public static void ajoutFournisseur(Connection conn) throws SQLException {
	String query = "INSERT INTO Fournisseurs (numeroFournisseur, nom, email, adresse) VALUES (?, ?, ?, ?)";
	Fournisseur leFournisseur = FournisseurAffiche.creerFournisseur();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, leFournisseur.getNumeroFournisseur());
            stmt.setString(2, leFournisseur.getNom());
            stmt.setString(3, leFournisseur.getEmail());
            stmt.setString(4, leFournisseur.getAdresse());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
		System.out.println("Fournisseur ajoute avec succes !");
            } else {
		System.out.println("Echec de l'ajout du fournisseur.");
            }
	}
    }

    /**
     * 
     * @param conn : La connection a la bdd
     * @param id (int) : l'id du fournisseur a modifier
     * @throws SQLException 
     * 
     * Cette methode prend en argument un id
     * Puis, si un fournisseur qui porte cet id se trouve dans la bdd, 
     * Cette methode appele la methode creerFournisseur de FournisseurAffiche
     * pour creer un nouveau Fournisseur qui remplacera celui se trouvant la bdd ayant l'id entre en argument
     * Sinon, un message d'erreur s'affiche
     */
    public static void modifieFournisseur(Connection conn, int id) throws SQLException {
	String query = "UPDATE Fournisseurs SET numeroFournisseur = ?, nom = ?, email = ?, adresse = ? WHERE id = ?";
	Fournisseur leFournisseur = FournisseurAffiche.creerFournisseur();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, leFournisseur.getNumeroFournisseur());
            stmt.setString(2, leFournisseur.getNom());
            stmt.setString(3, leFournisseur.getEmail());
            stmt.setString(4, leFournisseur.getAdresse());
            stmt.setInt(5, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
		System.out.println("Fournisseur d'id " + id + " modifie avec succes !");
            } else {
		System.out.println("Aucun fournisseur trouve avec l'ID specifie : " + id);
            }
	}
    }

    /**
     * 
     * @param conn : La connection a la bdd
     * @param id (int) : l'id du fournisseur a supprimer
     * @throws SQLException 
     * 
     * Cette methode prend en argument un id
     * Puis, si un fournisseur qui porte cet id se trouve dans la bdd, 
     * Cette methode le supprime de la bdd
     * Sinon, un message d'erreur s'affiche
     */
    public static void supprimeFournisseur(Connection conn, int id) throws SQLException {
	String query = "DELETE FROM Fournisseurs WHERE id = ?";
	try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
		System.out.println("Fournisseur supprime avec succes !");
            } else {
		System.out.println("Aucun fournisseur trouve avec l'ID specifie : " + id);
            }
	}
    }
}