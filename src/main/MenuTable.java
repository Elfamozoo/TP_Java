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
        return reponse;
    }
}
