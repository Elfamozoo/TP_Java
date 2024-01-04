package main;

import java.util.Scanner;

/**
 *
 * @author vincs
 */
public class MenuTable {
    /**
     * 
     * @return Integer
     * 
     * Cette methode affiche la liste des Tables et 
     * retourne le numero correspondant a la table selectionne
     */
    public static Integer afficheTable(){
        Scanner clavier = new Scanner(System.in);
        int reponse;
        System.out.println("Entrer le numero de la table voulue : (Entrer 0 pour arrêter)");
        System.out.println("1 - Fournisseurs");
        System.out.println("2 - Articles");
        System.out.println("3 - Clients");
        System.out.println("4 - Utilisateurs");
        
        reponse = clavier.nextInt();
        
        System.out.println();
        
        switch (reponse) {//Selon la reponse, on affiche la table selectionner : 
            case 0 -> System.out.println("Fermeture du systeme");
            case 1 -> System.out.println("Table selectionner : Fournisseurs");
            case 2 -> System.out.println("Table selectionner : Articles");
            case 3 -> System.out.println("Table selectionner : Clients");
            case 4 -> System.out.println("Table selectionner : Utilisateurs");
            default -> System.out.println("Choix de table incorrect");
        }
        
        System.out.println();
        
        return reponse;
    }
}
