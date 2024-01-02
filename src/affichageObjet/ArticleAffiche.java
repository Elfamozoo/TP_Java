package affichageObjet;

import modele.Article;

import java.util.Scanner;

/**
 *
 * @author vincs
 */
public class ArticleAffiche {
    /**
     * 
     * @param lArticle : l'Article a afficher
     * 
     * Cette methode permet d'afficher les informations d'un article
     */
    public static void afficherArticle(Article lArticle){
        String achat; 
        //Pour eviter d'afficher true ou false
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
    
    /**
     * 
     * @return Article
     * 
     * Cette methode retourne un article
     */
    public static Article creerArticle(){
        Article lArticle = new Article();
        Scanner clavier = new Scanner(System.in);
        
        System.out.print("Numero de l'article : ");
        lArticle.setNumeroArticle(Integer.valueOf(clavier.nextLine()));
        
        System.out.print("Nom de l'article : ");
        lArticle.setNom(clavier.nextLine());
        
        System.out.print("Description de l'article : ");
        lArticle.setDescription(clavier.nextLine());
        
        System.out.print("L'article est-t-il achete? ");
        if("OUI".equals(clavier.nextLine().toUpperCase())){
            lArticle.setAcheter(Boolean.TRUE);
        }
        else{
            lArticle.setAcheter(Boolean.FALSE);
        }
        
        return lArticle;
    }
}