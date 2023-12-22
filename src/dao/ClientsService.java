package dao;

import modele.Clients;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientsService {
    // Variable de type Connection
    Connection conn;

    // Constructeur
    public ClientsService(Connection conn) {
        this.conn = conn;
    }
    /**
     * La methode ajouteClient prend en parametre un objet de type Clients et l'ajoute dans la base de donnees.
     *
     * @param client
     */
    public void ajouteClient(Clients client) {
        String query = "INSERT INTO Clients (numeroClient, nom, prenom, email, adresse) VALUES (?, ?, ?, ?, ?)";

    }

    //* La methode afficheClient prend en parametre un objet de type Clients et affiche ses proprietes.
    public void afficheClient(Clients client) {
    }
}
