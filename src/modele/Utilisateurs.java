package modele;

import java.io.Serial;
import java.io.Serializable;

// La classe Utilisateurs correspond aux utilisateurs de l'application. Ils ont un id, un numero unique, un nom, un prenom, un email, un login et un mot de passe.
// Elle implémente Serializable pour pouvoir être sérialisée.


public class Utilisateurs implements Serializable {
    @Serial
    private static final long serialVersionUID = -191245848552L;
    private int id;
    private int numeroEmploye;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;

    // Le constructeur de la classe Utilisateurs.
    public Utilisateurs() {
    }

    // Les getters et setters de la classe Utilisateurs.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroEmploye() {
        return numeroEmploye;
    }

    public void setNumeroEmploye(int numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
