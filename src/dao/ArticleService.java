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
	String query = "SELECT * FROM Articles"; //Requete sql
        Article lArticle = new Article(); //Objet de type Article pour stocker les informations
	try (PreparedStatement stmt = conn.prepareStatement(query)) {//Statement utilisant la requete
            ResultSet rs = stmt.executeQuery();//Execution du statement
            while (rs.next()) {//Tant qu'il y a des lignes, lArticle recupere les informations
                //(1 seul à la fois)
                lArticle.setId(rs.getInt("id"));
                lArticle.setNumeroArticle(rs.getInt("numeroArticle"));
                lArticle.setNom(rs.getString("nom"));
                lArticle.setDescription(rs.getString("description"));
                lArticle.setAcheter(rs.getBoolean("achat"));
                
                ArticleAffiche.afficherArticle(lArticle);
                //Appele de la methode afficherArticle de ArticleAffiche pour afficher
                //les informations de chaque Article ligne par ligne
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
	String query = "SELECT * FROM Articles WHERE id = ?";//Requete sql
        Article lArticle = new Article();//Objet de type Article pour stocker les informations
	try (PreparedStatement stmt = conn.prepareStatement(query)) {//Statement utilisant la requete
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();//Execution du statement

            if (rs.next()) {//Si il y une ligne (et donc un enregistrement) lArticle recupere les informations
                lArticle.setId(id);
                lArticle.setNumeroArticle(rs.getInt("numeroArticle"));
                lArticle.setNom(rs.getString("nom"));
                lArticle.setDescription(rs.getString("description"));
                lArticle.setAcheter(rs.getBoolean("achat"));
                
                ArticleAffiche.afficherArticle(lArticle);
                //Appelle de la methode afficherArticle de ArticleAffiche pour afficher les informations de l'Article
            } else {//Sinon, un message d'erreur s'affiche
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
	String query = "INSERT INTO Articles (numeroArticle, nom, description, achat) VALUES (?, ?, ?, ?)";//Requete sql
	Article lArticle = ArticleAffiche.creerArticle();//Creation d'un Objet de type Article
        //Par appele de la methode creerArticle de ArticleAffiche
        try (PreparedStatement stmt = conn.prepareStatement(query)) {//Statement utilisant la requete
            //Reuperation des informations de larticle pour les ajouter dans la bdd grace au statement  
            stmt.setInt(1, lArticle.getNumeroArticle());
            stmt.setString(2, lArticle.getNom());
            stmt.setString(3, lArticle.getDescription());
            stmt.setBoolean(4, lArticle.getAchat());

            stmt.executeUpdate();//Execution du statement
            
            System.out.println("Article ajoute avec succes !");
	} 
        catch (SQLException e) {
            // Si une erreur se produit, on affiche un message d'erreur.
            System.out.println("Erreur lors de l'ajout de l'article : " + e.getMessage());
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
	String query = "UPDATE Articles SET numeroArticle = ?, nom = ?, description = ?, achat = ? WHERE id = ?";//Requete sql
	
        if (Verif.verifId(conn, id, "Articles")) {
            /* Verification que le l'article existe grace a son id par appele de la methode verifId de Verif
            Si l'article existe, on peut le modifier */
            Article lArticle = ArticleAffiche.creerArticle();//Creation d'un Objet de type Article
            //Ses informations remplaceront celles de l'enregistrement correspondant dans la bdd
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) {//Statement utilisant la requete
            //Reuperation des informations de lArticle pour les remplacer dans la bdd grace au statement
                stmt.setInt(1, lArticle.getNumeroArticle());
                stmt.setString(2, lArticle.getNom());
                stmt.setString(3, lArticle.getDescription());
                stmt.setBoolean(4, lArticle.getAchat());
                stmt.setInt(5, id);
                
                stmt.executeUpdate();//Execution du statement
                
		System.out.println("Article d'id " + id + " modifie avec succes !");
            } 
            catch (SQLException e) {
                // Si une erreur se produit, on affiche un message d'erreur.
                System.out.println("Erreur lors de la modification de l'article : " + e.getMessage());
            }
        } 
        else {//Sinon, un message d'erreur s'affiche
            System.out.println("Aucun article trouve avec l'ID specifie : " + id);
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
	String query = "DELETE FROM Articles WHERE id = ?";//Requete sql
        if (Verif.verifId(conn, id, "Articles")) {
            /* Verification que l'article existe grace a son id par appele de la methode verifId de Verif
            Si l'article existe, on peut le modifier */
            try (PreparedStatement stmt = conn.prepareStatement(query)) {//Statement utilisant la requete
                stmt.setInt(1, id);

                stmt.executeUpdate();//Execution du statement
                
                System.out.println("Article supprime avec succes !");
            } 
            catch (SQLException e) {
                // Si une erreur se produit, on affiche un message d'erreur.
                System.out.println("Erreur lors de la suppression de l'article : " + e.getMessage());
            }
        }
        else {//Sinon, un message d'erreur s'affiche
            System.out.println("Aucun article trouve avec l'ID specifie : " + id);
        }
    }
}