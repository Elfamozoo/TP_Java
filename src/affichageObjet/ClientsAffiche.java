package affichageObjet;

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
        client.setEmail(clavier.next());

        // Le clavier.next + clavier.nextLine permet de récupérer la ligne entière et non pas seulement le numero de la rue.
        System.out.println("Adresse du client : ");
        client.setAdresse(clavier.next() + clavier.nextLine());

        // On retourne l'objet client.
        return client;
    }
}
