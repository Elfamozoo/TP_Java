package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * @author Illyes et Vincs
 */
public class Verif {

    // La fonction verifId() permet de vérifier si dans les tables Clients, Fournisseurs, Articles et Utilisateurs, un id existe. Elle prend en paramètre une connexion à la base de données et l'ID à vérifier.
    public static boolean verifId(Connection conn, int id, String nomTable) throws SQLException {
        /* La requête SQL pour vérifier si un id existe dans les tables Clients, Fournisseurs, Articles et Utilisateurs.
         Cette requête retournera une seule colonne contenant la valeur numérique 1 et autant de lignes que correspondant à la sélection.
         C'est utilisé pour vérifier si une entrée (ligne) avec un certain id existe dans la table.
         Ici, il n'est pas nécessaire de récupérer des données réelles de la table. On veut seulement savoir si un enregistrement correspondant à la condition existe.
         C'est une manière efficace de vérifier l'existence d'une entrée dans une base de données sans avoir besoin de charger de réelles données de cette entrée.
         */
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

    // La fonction verifEmail() permet de verifier si les données entrées durant la demande d'email de la table Clients correspond bien au format d'un Email.
    // Vérifie si l'argument email est une chaîne qui respecte un format d'e-mail basique, elle renvoie true si l'e-mail est conforme à ce format, sinon false.
    public static boolean verifEmail(String email) {
        // Cette regex s'assure qu'il y a au moins un caractère non-espace avant et après le "@",
        // et également au moins un caractère non-espace après le point qui suit le "@".
        String regex = "^\\S+@\\S+\\.\\S+$";
        /* Pattern.matches est utilisée pour vérifier si la chaîne email correspond à l'expression régulière définie par regex.
           Pattern est une classe JAVA pour définir un modèle afin de pouvoir ensuite le comparer avec matches qui vont comparer ici
           regex avec l'input rentré plus tard durant le scanner.
        */
        return Pattern.matches(regex, email);
    }
}
