package modele;

import java.io.Serializable;

/**
 *
 * @author vincs
 */

/**
 * La class Article correspond aux articles de l'entreprise. 
 * Ils ont un id, un numero unique, un nom, une description et un etat indiquant si ils sont acheter ou non.
 * 
 * Cette class comprant des getters, des setters et un constucteur vide.
 */
public class Article implements Serializable{
    private static final long serialVersionUID = 12346;
    private Integer id;
    private Integer numeroArticle;
    private String nom;
    private String description;
    private Boolean achat;

    public Article() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumeroArticle() {
        return numeroArticle;
    }

    public Boolean getAchat() {
        return achat;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumeroArticle(Integer numeroArticle) {
        this.numeroArticle = numeroArticle;
    }

    public void setAcheter(Boolean achat) {
        this.achat = achat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
