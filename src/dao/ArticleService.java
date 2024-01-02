package dao;

import modele.Article;
import affichageObjet.ArticleAffiche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vincs
 */
public class ArticleService {
    /**
     * 
     * @param conn : La connection a la bdd
     * @throws SQLException 
     * 
     * Cette methode recupere les articles present dans la bdd 
     * puis les affiches en utilisant la methode afficherArticle de ArticleAffiche 
     */
    public static void afficheLesArticles(Connection conn) throws SQLException {
	String query = "SELECT * FROM Articles";
        Article lArticle = new Article();
	try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lArticle.setId(rs.getInt("id"));
                lArticle.setNumeroArticle(rs.getInt("numeroArticle"));
                lArticle.setNom(rs.getString("nom"));
                lArticle.setDescription(rs.getString("description"));
                lArticle.setAcheter(rs.getBoolean("achat"));
                
                ArticleAffiche.afficherArticle(lArticle);
            }
	}
    }
    
    /**
     * 
     * @param conn : La connection a la bdd
     * @param id (int) : l'id de l'article a afficher
     * @throws SQLException
     * 
     * Cette methode prend en argument un id
     * Puis, si un article qui porte cet id se trouve dans la bdd, 
     * il s'affiche en utilisant la methode afficherArticle de ArticleAffiche 
     * Sinon, un message d'erreur s'affiche
     */
    public static void afficheArticle(Connection conn, int id) throws SQLException {
	String query = "SELECT * FROM Articles WHERE id = ?";
        Article lArticle = new Article();
	try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                lArticle.setId(id);
                lArticle.setNumeroArticle(rs.getInt("numeroArticle"));
                lArticle.setNom(rs.getString("nom"));
                lArticle.setDescription(rs.getString("description"));
                lArticle.setAcheter(rs.getBoolean("achat"));
                
                ArticleAffiche.afficherArticle(lArticle);
            } else {
		System.out.println("Aucun article trouve avec l'ID : " + id);
            }
	}
    }
    
    /**
     * 
     * @param conn : : La connection a la bdd
     * @throws SQLException 
     * 
     * Cette methode appele la methode creerArticle de ArticleAffiche
     * pour creer un Article qui sera ensuite ajouter dans la bdd
     */
    public static void ajoutArticle(Connection conn) throws SQLException {
	String query = "INSERT INTO Articles (numeroArticle, nom, description, achat) VALUES (?, ?, ?, ?)";
	Article lArticle = ArticleAffiche.creerArticle();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, lArticle.getNumeroArticle());
            stmt.setString(2, lArticle.getNom());
            stmt.setString(3, lArticle.getDescription());
            stmt.setBoolean(4, lArticle.getAchat());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
		System.out.println("Article ajoute avec succes !");
            } else {
		System.out.println("Echec de l'ajout de l'article.");
            }
	}
    }

    /**
     * 
     * @param conn : La connection a la bdd
     * @param id (int) : l'id de l'article a modifier
     * @throws SQLException 
     * 
     * Cette methode prend en argument un id
     * Puis, si un article qui porte cet id se trouve dans la bdd, 
     * Cette methode appele la methode creerArticle de ArticleAffiche
     * pour creer un nouvel Article qui remplacera celui se trouvant la bdd ayant l'id entre en argument
     * Sinon, un message d'erreur s'affiche
     */
    public static void modifieArticle(Connection conn, int id) throws SQLException {
	String query = "UPDATE Articles SET numeroArticle = ?, nom = ?, description = ?, achat = ? WHERE id = ?";
	Article lArticle = ArticleAffiche.creerArticle();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, lArticle.getNumeroArticle());
            stmt.setString(2, lArticle.getNom());
            stmt.setString(3, lArticle.getDescription());
            stmt.setBoolean(4, lArticle.getAchat());
            stmt.setInt(5, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
		System.out.println("Article d'id " + id + " modifie avec succes !");
            } else {
		System.out.println("Aucun Article trouve avec l'ID specifie : " + id);
            }
	}
    }

    /**
     * 
     * @param conn : La connection a la bdd
     * @param id (int) : l'id de l'article a supprimer
     * @throws SQLException 
     * 
     * Cette methode prend en argument un id
     * Puis, si un article qui porte cet id se trouve dans la bdd, 
     * Cette methode le supprime de la bdd
     * Sinon, un message d'erreur s'affiche
     */
    public static void supprimeArticle(Connection conn, int id) throws SQLException {
	String query = "DELETE FROM Articles WHERE id = ?";
	try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
		System.out.println("Article supprime avec succes !");
            } else {
		System.out.println("Aucun article trouve avec l'ID specifie : " + id);
            }
	}
    }
}