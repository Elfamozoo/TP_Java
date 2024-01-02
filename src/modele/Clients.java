package modele;

import java.io.Serial;
import java.io.Serializable;


// La classe Clients correspond aux clients de l'entreprise. Ils ont un id, un numero unique, un nom, un prenom, un email et une adresse.
// Elle implémente Serializable pour pouvoir être sérialisée.
public class Clients implements Serializable {

    // La variable serialVersionUID est utilisée lors de la sérialisation pour vérifier que l'objet sérialisé correspond bien à la classe.
    @Serial
    private static final long serialVersionUID = -1912226135221L;

    // Les variables de la classe Clients.
    private int id;
    private int numeroClient;

    private String nom;

    private String prenom;

    private String email;

    private String adresse;

    // Le constructeur de la classe Clients.
    public Clients() {
    }

    // Les getters et setters de la classe Clients.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(int numeroClient) {
        this.numeroClient = numeroClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
