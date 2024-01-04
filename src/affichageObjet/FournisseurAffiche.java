package affichageObjet;

import dao.Verif;
import modele.Fournisseur;

import java.util.Scanner;

/**
 *
 * @author vincs
 */
public class FournisseurAffiche {
    /**
     * 
     * @param leFournisseur : le Fournisseur à afficher
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
     * Cette methode cree et retourne un fournisseur
     */
    public static Fournisseur creerFournisseur(){
        Fournisseur leFournisseur = new Fournisseur();
        Scanner clavier = new Scanner(System.in);
        
        System.out.println("Numero du fournisseur : ");
        leFournisseur.setNumeroFournisseur(Integer.valueOf(clavier.nextLine()));
        
        System.out.println("Nom du fournisseur : ");
        leFournisseur.setNom(clavier.nextLine());
        
        System.out.println("Email du fournisseur : ");
        String email = clavier.nextLine();
        while (!Verif.verifEmail(email)) {/*Appele de la methode verifEmail de Verif 
            Pour verifier que l'email est valide
            Tant qu'il est invalide, on doit le retaper*/
            System.out.println("L'email entre n'est pas valide. Reessayer : ");
            email = clavier.nextLine();
        }
        
        leFournisseur.setEmail(email);
        
        System.out.println("Adresse du fournisseur : ");
        leFournisseur.setAdresse(clavier.nextLine());
        
        return leFournisseur;
    }
}
