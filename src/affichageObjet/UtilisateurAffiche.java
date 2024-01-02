package affichageObjet;

import modele.Utilisateurs;

import java.util.Scanner;

public class UtilisateurAffiche {
    public static void afficherUtilisateur(Utilisateurs utilisateur) {
        System.out.println("ID: " + utilisateur.getId() +
                ", Numéro Employé: " + utilisateur.getNumeroEmploye() +
                ", Nom: " + utilisateur.getNom() +
                ", Prénom: " + utilisateur.getPrenom() +
                ", Email: " + utilisateur.getEmail() +
                ", Login: " + utilisateur.getLogin() +
                ", Mot de passe: " + utilisateur.getPassword());
    }

    public static Utilisateurs creerUtilisateur() {
        Utilisateurs utilisateur = new Utilisateurs();
        Scanner clavier = new Scanner(System.in);

        System.out.println("Numéro Employé : ");
        utilisateur.setNumeroEmploye(clavier.nextInt());

        System.out.println("Nom : ");
        utilisateur.setNom(clavier.next());

        System.out.println("Prénom : ");
        utilisateur.setPrenom(clavier.next());

        System.out.println("Email : ");
        utilisateur.setEmail(clavier.next());

        System.out.println("Login : ");
        utilisateur.setLogin(clavier.next());

        System.out.println("Mot de passe : ");
        utilisateur.setPassword(clavier.next());

        return utilisateur;
    }
}
