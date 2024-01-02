package affichageObjet;

import modele.Fournisseur;

import java.util.Scanner;

/**
 *
 * @author vincs
 */
public class FournisseurAffiche {
    /**
     * 
     * @param leFournisseur : le Fournisseur a afficher
     * 
     * Cette methode permet d'afficher les informations d'un fournisseur
     */
    public static void afficherFournisseur(Fournisseur leFournisseur){
        System.out.println("ID: " + leFournisseur.getId() + 
                ", Numero de Fournisseur: " + leFournisseur.getNumeroFournisseur() + 
                ", Nom: " + leFournisseur.getNom() + 
                ", Email: " + leFournisseur.getEmail() + 
                ", Adresse: " + leFournisseur.getAdresse());
    }
    
    /**
     * 
     * @return Fournisseur
     * 
     * Cette methode retourne un fournisseur
     */
    public static Fournisseur creerFournisseur(){
        Fournisseur leFournisseur = new Fournisseur();
        Scanner clavier = new Scanner(System.in);
        
        System.out.print("Numero du fournisseur : ");
        leFournisseur.setNumeroFournisseur(Integer.valueOf(clavier.nextLine()));
        
        System.out.print("Nom du fournisseur : ");
        leFournisseur.setNom(clavier.nextLine());
        
        System.out.print("Email du fournisseur : ");
        leFournisseur.setEmail(clavier.nextLine());
        
        System.out.print("Adresse du fournisseur : ");
        leFournisseur.setAdresse(clavier.nextLine());
        
        return leFournisseur;
    }
}
