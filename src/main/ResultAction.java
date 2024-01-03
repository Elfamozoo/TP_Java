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
    public static void afficheResult(Connection conn, Integer numTable, Integer numAction) throws SQLException {
        Scanner clavier = new Scanner(System.in);

        switch (numTable) {
            case 0 -> System.out.println("Fermeture du systeme");

            case 1 -> {
                switch (numAction) {
                    case 0 -> System.out.println("Vous avez quitte la table");

                    case 1 -> FournisseurService.afficheLesFournisseurs(conn);

                    case 2 -> {
                        System.out.println("Entrer l'Id : ");
                        FournisseurService.afficheFournisseur(conn, clavier.nextInt());
                    }

                    case 3 -> {
                        FournisseurService.ajoutFournisseur(conn);
                    }

                    case 4 -> {
                        System.out.println("Entrer l'Id : ");
                        FournisseurService.modifieFournisseur(conn, clavier.nextInt());
                    }


                    case 5 -> {
                        System.out.println("Entrer l'Id : ");
                        FournisseurService.supprimeFournisseur(conn, clavier.nextInt());
                    }

                    default -> System.out.println("Choix d'action incorrect");
                }
            }

            case 2 -> {
                switch (numAction) {
                    case 0 -> System.out.println("Vous avez quitte la table");

                    case 1 -> ArticleService.afficheLesArticles(conn);

                    case 2 -> {
                        System.out.println("Entrer l'Id : ");
                        ArticleService.afficheArticle(conn, clavier.nextInt());
                    }

                    case 3 -> {
                        ArticleService.ajoutArticle(conn);
                    }

                    case 4 -> {
                        System.out.println("Entrer l'Id : ");
                        ArticleService.modifieArticle(conn, clavier.nextInt());
                    }


                    case 5 -> {
                        System.out.println("Entrer l'Id : ");
                        ArticleService.supprimeArticle(conn, clavier.nextInt());
                    }

                    default -> System.out.println("Choix d'action incorrect");
                }
            }

            case 3 -> {
                switch (numAction) {
                    case 0 -> System.out.println("Vous avez quitte la table");

                    case 1 -> ClientsService.afficheLesClients(conn);

                    case 2 -> {
                        System.out.println("Entrer l'Id : ");
                        ClientsService.afficheClient(conn, clavier.nextInt());
                    }

                    case 3 -> {
                        ClientsService.ajoutClient(conn);
                    }

                    case 4 -> {
                        System.out.println("Entrer l'Id : ");
                        ClientsService.modifClient(conn, clavier.nextInt());
                    }

                    case 5 -> {
                        System.out.println("Entrer l'Id : ");
                        ClientsService.supprimeClient(conn, clavier.nextInt());
                    }

                    default -> System.out.println("Choix d'action incorrect");
                }
            }

            case 4 -> {
                switch (numAction) {
                    case 0 -> System.out.println("Vous avez quitte la table");

                    case 1 -> UtilisateurService.afficheTousLesUtilisateurs(conn);

                    case 2 -> {
                        System.out.println("Entrer l'Id : ");
                        UtilisateurService.afficheUtilisateur(conn, clavier.nextInt());
                    }
                    // Thibaut a faire par rapport a ton utilisateurService
                    case 3 -> {
                        //UtilisateurService.ajoutUtilisateur(conn);
                    }
                    // Thibaut a faire par rapport a ton utilisateurService
                    case 4 -> {
                        System.out.println("Entrer l'Id : ");
                        // UtilisateurService.modifieUtilisateur(conn);
                    }

                    case 5 -> {
                        System.out.println("Entrer l'Id : ");
                        UtilisateurService.supprimeUtilisateur(conn,clavier.nextInt());
                    }

                    default -> System.out.println("Choix d'action incorrect");
                }
            }

            default -> System.out.println("Choix de table incorrect");
        }
    }
}
