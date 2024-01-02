package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Entreprise {

    // La fonction createDatabase() permet de créer la base de données. Elle prend en paramètre une connexion à la base de données et le nom de la base de données à créer.
    public static void createDatabase(Connection conn, String DB_NAME) throws SQLException {
        // Création d'un objet de type Statement. Il sera utilisé pour exécuter la requête SQL.
        try (Statement stmt = conn.createStatement()) {
            // Exécution de la requête SQL.
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME + " CHARACTER SET utf8");
        }
    }

    // La fonction useDatabase() permet de sélectionner la base de données à utiliser. Elle prend en paramètre une connexion à la base de données et le nom de la base de données à utiliser.
    public static void useDatabase(Connection conn, String DB_NAME) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("USE " + DB_NAME);
        }
    }

    // La fonction createTables() permet de créer les tables de la base de données. Elle prend en paramètre une connexion à la base de données.
    public static void createTables(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            // Exécution de la requête SQL. On crée les tables si elles n'existent pas.
            // On utilise le mot clé IF NOT EXISTS pour éviter d'avoir une erreur si la table existe déjà.
            // On utilise le mot clé AUTO_INCREMENT pour que l'ID soit généré automatiquement.
            // On utilise le mot clé PRIMARY KEY pour définir l'ID comme clé primaire.
            // On utilise le mot clé NOT NULL pour définir que les champs ne peuvent pas être vides.
            // On utilise le mot clé VARCHAR pour définir le type de données des champs.
            // On utilise le mot clé BOOLEAN pour définir le type de données des champs.
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Utilisateurs (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, numeroEmploye INT NOT NULL, nom VARCHAR(50) NOT NULL, prenom VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL, login VARCHAR(50) NOT NULL, motDePasse VARCHAR(50) NOT NULL)");
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, numeroClient INT NOT NULL, nom VARCHAR(50) NOT NULL, prenom VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL, adresse VARCHAR(255) NOT NULL)");
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Fournisseurs (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, numeroFournisseur INT NOT NULL, nom VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL, adresse VARCHAR(255) NOT NULL)");
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Articles (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, numeroArticle INT NOT NULL, nom VARCHAR(50) NOT NULL, description VARCHAR(255) NOT NULL, achat BOOLEAN NOT NULL)");
        }
    }
}

