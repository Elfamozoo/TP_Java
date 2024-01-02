package affichageObjet;

import modele.Article;

import java.util.Scanner;

/**
 *
 * @author vincs
 */
public class ArticleAffiche {
    public static void afficherArticle(Article lArticle){
        String achat;
        
        if(lArticle.getAchat()){
            achat = "Oui";
        }else{
            achat = "Non";
        }
        
        System.out.println("ID: " + lArticle.getId() + 
                ", Numero de l'article: " + lArticle.getNumeroArticle() + 
                ", Nom: " + lArticle.getNom() + 
                ", Description: " + lArticle.getDescription() + 
                ", Acheter: " + achat);
    }
    
    public static Article creerArticle(){
        Article lArticle = new Article();
        Scanner clavier = new Scanner(System.in);
        
        System.out.println("Numero de l'article : ");
        lArticle.setNumeroArticle(clavier.nextInt());
        
        System.out.println("Nom de l'article : ");
        lArticle.setNom(clavier.next());
        
        System.out.println("Description de l'article : ");
        lArticle.setDescription(clavier.next());
        
        lArticle.setAcheter(Boolean.FALSE);
        
        System.out.println(lArticle.getDescription());
        
        return lArticle;
    }
}