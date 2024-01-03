package affichageObjet;

import dao.Verif;
import modele.Clients;

import java.util.Scanner;

/**
 * @author Illyes
 */
public class ClientsAffiche {

    // La fonction afficherClient() permet d'afficher les informations d'un client.
    // Elle prend en paramètre un objet de type Clients.
    public static void afficherClient(Clients leClient) {
        // On affiche les informations du client.
        System.out.println("ID: " + leClient.getId() +
                ", Numero du client: " + leClient.getNumeroClient() +
                ", Nom: " + leClient.getNom() +
                ", Prenom: " + leClient.getPrenom() +
                ", Email: " + leClient.getEmail() +
                ", Adresse: " + leClient.getAdresse());
    }

    // La fonction creerClient() permet de créer un client en demandant à l'utilisateur de rentrer les informations nécessaires.
    // Elle retourne un objet de type Clients.
    public static Clients creerClient() {
        // Création d'un objet de type Clients. Il sera utilisé pour stocker les informations du client à ajouter.
        Clients client = new Clients();
        // Création d'un objet de type Scanner. Il sera utilisé pour récupérer les informations entrées par l'utilisateur.
        Scanner clavier = new Scanner(System.in);
        // On demande à l'utilisateur de rentrer les informations du client.
        System.out.println("Numero du client : ");
        client.setNumeroClient(clavier.nextInt());

        System.out.println("Nom du client : ");
        client.setNom(clavier.next());

        System.out.println("Prenom du client : ");
        client.setPrenom(clavier.next());

        System.out.println("Email du client : ");
        // Création d'une variable email de type String qui va stocker l'adresse mail qui sera saisie.
        String email = clavier.next();

        // Boucle while jusqu'à ce qu'une adresse e-mail valide soit saisie (!Verif.verifEmail(email) veut dire false).
        while (!Verif.verifEmail(email)) {
            System.out.println("L'email entré n'est pas valide. Réessayer : ");
            email = clavier.next();
        }

        client.setEmail(email);


        System.out.println("Adresse du client : ");
        // Le clavier.nextLine() permets de vider le buffer et repartir sur la ligne suivante.
        clavier.nextLine();
        client.setAdresse(clavier.nextLine());

        // On retourne l'objet client.
        return client;
    }
}
