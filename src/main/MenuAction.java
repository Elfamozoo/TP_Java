package main;

import java.util.Scanner;

/**
 *
 * @author vincs
 */
public class MenuAction {
    /**
     * 
     * @return Integer
     * 
     * Cette methode affiche la liste des Actions et 
     * retourne le numero correspondant a l'action selectionne
     */
    public static Integer afficheAction(){
        Scanner clavier = new Scanner(System.in);
        int reponse;
        System.out.println("Entrer le numero de l'action voulue : (Entrer 0 pour revenir en arriere)");
        System.out.println("1 - Lecture complete de la table");
        System.out.println("2 - Lecture d'un enregistrement selon l'id");
        System.out.println("3 - Ajout d'un enregistrement");
        System.out.println("4 - Modification d'un enregistrement");
        System.out.println("5 - Suppression d'un enregistrement");
        reponse = clavier.nextInt();
        return reponse;
    }
}
