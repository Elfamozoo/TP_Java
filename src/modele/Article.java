package modele;

import java.io.Serializable;

/**
 *
 * @author vincs
 */
public class Article implements Serializable{
    private static final long serialVersionUID = 12346;
    private Integer id;
    private String numeroArticle;
    private Boolean acheter;
    private String nom;
    private String description;

    public Article() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getNumeroArticle() {
        return numeroArticle;
    }

    public Boolean getAcheter() {
        return acheter;
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

    public void setNumeroArticle(String numeroArticle) {
        this.numeroArticle = numeroArticle;
    }

    public void setAcheter(Boolean acheter) {
        this.acheter = acheter;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
