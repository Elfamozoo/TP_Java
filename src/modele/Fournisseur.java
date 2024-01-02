package modele;

import java.io.Serializable;

/**
 *
 * @author vincs
 */
public class Fournisseur implements Serializable{
    private static final long serialVersionUID = 12345;
    private Integer id;
    private Integer numeroFournisseur;
    private String nom;
    private String email;
    private String adresse;
    
    public Fournisseur() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumeroFournisseur() {
        return numeroFournisseur;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumeroFournisseur(Integer numeroFournisseur) {
        this.numeroFournisseur = numeroFournisseur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
