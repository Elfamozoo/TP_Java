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
	String query = "SELECT * FROM Fournisseurs"; //Requete sql
        Fournisseur leFournisseur = new Fournisseur(); //Objet de type Fournisseur pour stocker les informations
	try (PreparedStatement stmt = conn.prepareStatement(query)) {//Statement utilisant la requete
            ResultSet rs = stmt.executeQuery();//Execution du statement
            while (rs.next()) {//Tant qu'il y a des lignes, leFournisseur recupere les informations
                //(1 seul à la fois)
                leFournisseur.setId(rs.getInt("id"));
                leFournisseur.setNumeroFournisseur(rs.getInt("numeroFournisseur"));
                leFournisseur.setNom(rs.getString("nom"));
                leFournisseur.setEmail(rs.getString("email"));
                leFournisseur.setAdresse(rs.getString("adresse"));
                
                FournisseurAffiche.afficherFournisseur(leFournisseur);
                //Appele de la methode afficherFournisseur de FournisseurAffiche pour afficher
                //les informations de chaque Fournisseur ligne par ligne
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
	String query = "SELECT * FROM Fournisseurs WHERE id = ?";//Requete sql
        Fournisseur leFournisseur = new Fournisseur();//Objet de type Fournisseur pour stocker les informations
	try (PreparedStatement stmt = conn.prepareStatement(query)) {//Statement utilisant la requete
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();//Execution du statement

            if (rs.next()) {//Si il y une ligne (et donc un enregistrement) leFournisseur recupere les informations
                leFournisseur.setId(id);
                leFournisseur.setNumeroFournisseur(rs.getInt("numeroFournisseur"));
                leFournisseur.setNom(rs.getString("nom"));
                leFournisseur.setEmail(rs.getString("email"));
                leFournisseur.setAdresse(rs.getString("adresse"));
                
                FournisseurAffiche.afficherFournisseur(leFournisseur);
                //Appele de la methode afficherFournisseur de FournisseurAffiche pour afficher les informations de l'Article
            } else {//Sinon, un message d'erreur s'affiche
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
	String query = "INSERT INTO Fournisseurs (numeroFournisseur, nom, email, adresse) VALUES (?, ?, ?, ?)";//Requete sql
	Fournisseur leFournisseur = FournisseurAffiche.creerFournisseur();//Creation d'un Objet de type Fournisseur
        //Par appele de la methode creerFournisseur de FournisseurAffiche
        try (PreparedStatement stmt = conn.prepareStatement(query)) {//Statement utilisant la requete
            //Reuperation des informations de leFournisseur pour les ajouter dans la bdd grace au statement
            stmt.setInt(1, leFournisseur.getNumeroFournisseur());
            stmt.setString(2, leFournisseur.getNom());
            stmt.setString(3, leFournisseur.getEmail());
            stmt.setString(4, leFournisseur.getAdresse());

            stmt.executeUpdate();//Execution du statement
            
            System.out.println("Fournisseur ajoute avec succes !");
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
	String query = "UPDATE Fournisseurs SET numeroFournisseur = ?, nom = ?, email = ?, adresse = ? WHERE id = ?";//Requete sql
	
        if (Verif.verifId(conn, id, "Fournisseurs")) {
            /* Verification que le fournisseur existe grace a son id par appele de la methode verifId de Verif
            Si le fournisseur existe, on peut le modifier */
            Fournisseur leFournisseur = FournisseurAffiche.creerFournisseur();//Creation d'un Objet de type Fournisseur
            //Ses informations remplaceront celles de l'enregistrement correspondant dans la bdd
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) {//Statement utilisant la requete
            //Reuperation des informations de leFournisseur pour les remplacer dans la bdd grace au statement
                stmt.setInt(1, leFournisseur.getNumeroFournisseur());
                stmt.setString(2, leFournisseur.getNom());
                stmt.setString(3, leFournisseur.getEmail());
                stmt.setString(4, leFournisseur.getAdresse());
                stmt.setInt(5, id);
                
                stmt.executeUpdate();//Execution du statement
                
		System.out.println("Fournisseur d'id " + id + " modifie avec succes !");
            }
        } 
        else {//Sinon, un message d'erreur s'affiche
            System.out.println("Aucun fournisseur trouve avec l'ID specifie : " + id);
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
	String query = "DELETE FROM Fournisseurs WHERE id = ?";//Requete sql
        if (Verif.verifId(conn, id, "Fournisseurs")) {
            /* Verification que le fournisseur existe grace a son id par appele de la methode verifId de Verif
            Si le fournisseur existe, on peut le modifier */
            try (PreparedStatement stmt = conn.prepareStatement(query)) {//Statement utilisant la requete
                stmt.setInt(1, id);

                stmt.executeUpdate();//Execution du statement
                
                System.out.println("Fournisseur supprime avec succes !");
            }
        }
        else {//Sinon, un message d'erreur s'affiche
            System.out.println("Aucun fournisseur trouve avec l'ID specifie : " + id);
        }
    }
}