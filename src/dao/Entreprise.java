package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public static void readAllUsers(Connection conn) throws SQLException {
		String query = "SELECT * FROM Utilisateurs";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int employeeNumber = rs.getInt("numeroEmploye");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String login = rs.getString("login");
				String password = rs.getString("motDePasse");

				System.out.println("ID: " + id + ", Employee Number: " + employeeNumber + ", Nom: " + nom + ", Prénom: "
						+ prenom + ", Email: " + email + ", Login: " + login + ", Mot de Passe: " + password);
			}
		}
	}
	
	public static void addUser(Connection conn, int employeeNumber, String nom, String prenom, String email, String login, String password) throws SQLException {
	    String query = "INSERT INTO Utilisateurs (numeroEmploye, nom, prenom, email, login, motDePasse) VALUES (?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, employeeNumber);
	        stmt.setString(2, nom);
	        stmt.setString(3, prenom);
	        stmt.setString(4, email);
	        stmt.setString(5, login);
	        stmt.setString(6, password);

	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Utilisateur ajouté avec succès !");
	        } else {
	            System.out.println("Échec de l'ajout de l'utilisateur.");
	        }
	    }
	}
}
