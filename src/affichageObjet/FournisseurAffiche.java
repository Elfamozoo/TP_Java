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
        
        System.out.println("Numero du fournisseur : ");
        leFournisseur.setNumeroFournisseur(clavier.nextInt());
        
        System.out.println("Nom du fournisseur : ");
        leFournisseur.setNom(clavier.next());
        
        System.out.println("Email du fournisseur : ");
        leFournisseur.setEmail(clavier.next());
        
        System.out.println("Adresse du fournisseur : ");
        leFournisseur.setAdresse(clavier.next());
        
        return leFournisseur;
    }
}
