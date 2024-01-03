package affichageObjet;

import dao.Verif;
import modele.Utilisateurs;

import java.util.Scanner;

public class UtilisateurAffiche {
    // Méthode pour afficher les détails d'un utilisateur
    public static void afficherUtilisateur(Utilisateurs utilisateur) {
        System.out.println("ID: " + utilisateur.getId() +
                ", Numéro Employé: " + utilisateur.getNumeroEmploye() +
                ", Nom: " + utilisateur.getNom() +
                ", Prénom: " + utilisateur.getPrenom() +
                ", Email: " + utilisateur.getEmail() +
                ", Login: " + utilisateur.getLogin() +
                ", Mot de passe: " + utilisateur.getPassword());
    }

    // Méthode pour créer un nouvel utilisateur à partir de la saisie utilisateur
    public static Utilisateurs creerUtilisateur() {
        Utilisateurs utilisateur = new Utilisateurs();
        Scanner clavier = new Scanner(System.in);

        // Demande à l'utilisateur de saisir les informations pour créer un nouvel utilisateur
        System.out.println("Numéro Employé : ");
        utilisateur.setNumeroEmploye(clavier.nextInt());

        System.out.println("Nom : ");
        utilisateur.setNom(clavier.next());

        System.out.println("Prénom : ");
        utilisateur.setPrenom(clavier.next());

        System.out.println("Email : ");
        String email = clavier.next();

        while (!Verif.verifEmail(email)) {/*Appelle de la methode verifEmail de Verif
            Pour verifier que l'email est valide
            Tant qu'il est invalide, on doit le retaper*/
            System.out.println("L'email entre n'est pas valide. Réessayer : ");
            email = clavier.next();
        }
        utilisateur.setEmail(email);

        System.out.println("Login : ");
        utilisateur.setLogin(clavier.next());

        System.out.println("Mot de passe : ");
        utilisateur.setPassword(clavier.next());

        return utilisateur;
    }
}
