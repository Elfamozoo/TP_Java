package modele;

// La table Clients contiendra les clients de l'entreprise. Ils ont un id, un num�ro unique,
// un nom, un prenom, un email et une adresse.

import java.io.Serial;
import java.io.Serializable;

/**
 * La classe Clients correspond aux clients de l'entreprise. Ils ont un id, un numero unique, un nom, un prenom, un email et une adresse.
 */
public class Clients implements Serializable {
    @Serial
    private static final long serialVersionUID = -1912226135221L;
    private int id;
    private int numeroClient;

    private String nom;

    private String prenom;

    private String email;

    private String adresse;

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
