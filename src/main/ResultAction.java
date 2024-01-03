package main;

import dao.ArticleService;
import dao.ClientsService;
import dao.FournisseurService;
import dao.UtilisateurService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author vincs
 */
public class ResultAction {
    /**
     * 
     * @param conn : La connection a la bdd
     * @param numTable : Le numero de la table selectionne
     * @param numAction : Le numero de l'action selectionne
     * @throws SQLException 
     * 
     * Cette methode effectue l'action demande pour la table choisi
     * Puis affiche le resultat de l'action en appelant la methode correspondante 
     */
    public static void afficheResult(Connection conn, Integer numTable, Integer numAction) throws SQLException {
        Scanner clavier = new Scanner(System.in);

        switch (numTable) {//Selon le numero de la table : 
            case 0 -> System.out.println("Fermeture du systeme");

            case 1 -> {//Table Fournisseurs
                switch (numAction) {//Selon le numero de l'action : 
                    case 0 -> System.out.println("Vous avez quitte la table");

                    case 1 -> FournisseurService.afficheLesFournisseurs(conn);
                    //Affiche tous les fournisseurs
                    case 2 -> {
                        System.out.println("Entrer l'Id : ");
                        FournisseurService.afficheFournisseur(conn, clavier.nextInt());
                    }//Affiche le fournisseur correspondant à l'id

                    case 3 -> {
                        FournisseurService.ajoutFournisseur(conn);
                    }//Ajoute un fournisseur

                    case 4 -> {
                        System.out.println("Entrer l'Id : ");
                        FournisseurService.modifieFournisseur(conn, clavier.nextInt());
                    }//Modifie le fournisseur correspondant à l'id


                    case 5 -> {
                        System.out.println("Entrer l'Id : ");
                        FournisseurService.supprimeFournisseur(conn, clavier.nextInt());
                    }//Supprime le fournisseur correspondant à l'id

                    default -> System.out.println("Choix d'action incorrect");
                }
            }

            case 2 -> {//Table Articles
                switch (numAction) {
                    case 0 -> System.out.println("Vous avez quitte la table");

                    case 1 -> ArticleService.afficheLesArticles(conn);
                    //Affiche tous les articles
                    case 2 -> {
                        System.out.println("Entrer l'Id : ");
                        ArticleService.afficheArticle(conn, clavier.nextInt());
                    }//Affiche l'article correspondant à l'id

                    case 3 -> {
                        ArticleService.ajoutArticle(conn);
                    }//Ajoute un article

                    case 4 -> {
                        System.out.println("Entrer l'Id : ");
                        ArticleService.modifieArticle(conn, clavier.nextInt());
                    }//Modifie l'article correspondant à l'id


                    case 5 -> {
                        System.out.println("Entrer l'Id : ");
                        ArticleService.supprimeArticle(conn, clavier.nextInt());
                    }//Supprime l'article correspondant à l'id

                    default -> System.out.println("Choix d'action incorrect");
                }
            }

            case 3 -> {//Table Clients
                switch (numAction) {
                    case 0 -> System.out.println("Vous avez quitte la table");

                    case 1 -> ClientsService.afficheLesClients(conn);
                    //Affiche tous les clients
                    case 2 -> {
                        System.out.println("Entrer l'Id : ");
                        ClientsService.afficheClient(conn, clavier.nextInt());
                    }//Affiche le client correspondant à l'id

                    case 3 -> {
                        ClientsService.ajoutClient(conn);
                    }//Ajoute un client

                    case 4 -> {
                        System.out.println("Entrer l'Id : ");
                        ClientsService.modifClient(conn, clavier.nextInt());
                    }//Modifie le client correspondant à l'id

                    case 5 -> {
                        System.out.println("Entrer l'Id : ");
                        ClientsService.supprimeClient(conn, clavier.nextInt());
                    }//Supprime le client correspondant à l'id

                    default -> System.out.println("Choix d'action incorrect");
                }
            }

            case 4 -> {//Table Utilisateurs
                switch (numAction) {
                    case 0 -> System.out.println("Vous avez quitte la table");

                    case 1 -> UtilisateurService.afficheTousLesUtilisateurs(conn);
                    //Affiche tous les fournisseurs
                    case 2 -> {
                        System.out.println("Entrer l'Id : ");
                        UtilisateurService.afficheUtilisateur(conn, clavier.nextInt());
                    }//Affiche l'utilisateur correspondant à l'id
                    
                    case 3 -> {
                        UtilisateurService.ajoutUtilisateur(conn);
                    }//Ajoute un utilisateur
                    
                    case 4 -> {
                        System.out.println("Entrer l'Id : ");
                        UtilisateurService.modifUtilisateur(conn, clavier.nextInt());
                    }//Modifie l'utilisateur correspondant à l'id

                    case 5 -> {
                        System.out.println("Entrer l'Id : ");
                        UtilisateurService.supprimeUtilisateur(conn, clavier.nextInt());
                    }//Supprime l'utilisateur correspondant à l'id

                    default -> System.out.println("Choix d'action incorrect");
                }
            }

            default -> System.out.println("Choix de table incorrect");
        }
    }
}
