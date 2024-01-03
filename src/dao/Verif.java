package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Verif {

    // La fonction verifId() permet de vérifier si dans les tables Clients, Fournisseurs, Articles et Utilisateurs, un id existe. Elle prend en paramètre une connexion à la base de données et l'ID à vérifier.
    public static boolean verifId(Connection conn, int id, String nomTable) throws SQLException {
        // La requête SQL pour vérifier si un id existe dans les tables Clients, Fournisseurs, Articles et Utilisateurs. Elle est stockée dans une variable de type String.
        String query = "SELECT 1 FROM " + nomTable + " WHERE id = ?";
        // Création d'un objet de type PreparedStatement. Il sera utilisé pour exécuter la requête SQL.
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // On remplace le ? de la requête SQL par l'ID du client à vérifier.
            stmt.setInt(1, id);
            // Exécution de la requête SQL. Le résultat est stocké dans un objet de type ResultSet.
            ResultSet rs = stmt.executeQuery();
            // Si le résultat contient une ligne, on retourne true. Sinon, on retourne false.
            return rs.next();
        }
    }
}
