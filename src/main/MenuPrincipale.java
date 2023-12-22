/**
 * Exercice JDBC :
 * 
 * Ecrire un programme divis� en plusieurs fichiers et dossiers.
 * 
 * Un dossier dao pour la partie de code accedant � la BDD.
 * Un dossier modele pour les objets utilis�s sous forme de JavaBean.
 * Un dossier main pour le programme principal g�rant les menus.
 * Vous pouvez creer d'autres dossiers si vous le juger necessaire.
 * 
 * Cr�er des fichiers differents selon les besoin,
 * et importer les dans les autres fichiers si n�cessaire.
 * 
 * Description : 
 * 
 * Cre�r la base de donn�es MySQL si elle n'existe pas. Nomm�e la comme vous le souhait�.
 * Connectez-vous � la BDD et cr�er les tables de la BDD si elles n'existent pas.
 * Ces tables sont : Utilisateurs, Clients, Fournisseurs et Articles.
 * 
 * La table Utilisateurs correpond aux utilisateurs du programme dans une entreprise.
 * Les Utilisateurs ont un id, un numero d'employ� unique, un nom, un prenom, un email,
 * un login et un mot de passe.
 * 
 * La table Clients contiendra les clients de l'entreprise. Ils ont un id, un num�ro unique,
 * un nom, un pr�nom, un email et une adresse.
 * 
 * La table Fournisseurs correspond aux fournisseurs de l'entreprise.
 * Ils ont un id, un num�ro unique, un nom, un email et une adresse.
 * 
 * La table Article correspond aux articles achet�s aux fournisseurs et vendu aux clients.
 * Ils ont un id, un numero unique, un champ indiquant si c'est un article achet� ou vendu, un nom, une description.
 * 
 * les op�rations � faire sur les toutes tables de la BDD et � decrire dans les menus sont :
 * la lectures complete.
 * la lecture d'un enregistrement selon l'id.
 * l'ecriture.
 * la modification.
 * la suppression.
 * 
 * Pour les menus, faites un premier menu pour choisir la table sur laquelle on veut faire une op�ration.
 * Puis un sous-menu corresondant aux diff�rentes op�rations.
 * 
 * Faites-les controles necesaires sur les op�rations pour eviter les incoh�rences et les erreur SQL.
 * 
 * Tous les champs de toutes les tables sont obligatoires.
 * 
 * Faire les javadoc pour toutes les m�thodes et classes.
 */

package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import dao.Entreprise;

public class MenuPrincipale {
	private static final String DB_URL = "jdbc:mysql://localhost:3306?useSSL=false";
	private static final String DB_NAME = "Entreprise";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Entreprise.createDatabase(conn, DB_NAME);
            Entreprise.useDatabase(conn, DB_NAME);
            Entreprise.createTables(conn);
            Entreprise.addUser(conn, 5, "Dujardin", "Jean", "email2@email.fr", "login2", "mdp2");
            Entreprise.readAllUsers(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
