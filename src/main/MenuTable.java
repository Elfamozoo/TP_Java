package main;

import java.util.Scanner;

/**
 *
 * @author vincs
 */
public class MenuTable {
    public static Integer afficheTable(){
        Scanner clavier = new Scanner(System.in);
        int reponse;
        System.out.println("Entrer le numero de la table voulue : (Entrer 0 pour arreter)");
        System.out.println("1 - Fournisseurs");
        System.out.println("2 - Articles");
        System.out.println("3 - Clients");
        System.out.println("4 - Utilisateurs");
        reponse = clavier.nextInt();
        return reponse;
    }
}
