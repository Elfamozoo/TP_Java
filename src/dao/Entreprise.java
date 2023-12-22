package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Entreprise {

    public static void createDatabase(Connection conn, String DB_NAME) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME + " CHARACTER SET utf8");
        }
    }

    public static void useDatabase(Connection conn, String DB_NAME) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("USE " + DB_NAME);
        }
    }

    public static void createTables(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
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
