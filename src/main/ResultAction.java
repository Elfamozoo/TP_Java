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
                    case 0 -> {
                        System.out.println("");
                        System.out.println("Vous avez quitte la table");
                        System.out.println("");
                    }
                    
                    case 1 -> {
                        System.out.println("Affichage de la liste des Fournisseurs : ");
                        FournisseurService.afficheLesFournisseurs(conn);
                        System.out.println();
                    }//Affiche tous les fournisseurs
                    
                    case 2 -> {
                        System.out.println("Affichage d'un Fournisseur : ");
                        System.out.println("Entrer l'Id : ");
                        FournisseurService.afficheFournisseur(conn, clavier.nextInt());
                        System.out.println();
                    }//Affiche le fournisseur correspondant à l'id

                    case 3 -> {
                        System.out.println("Ajout d'un Fournisseur : ");
                        FournisseurService.ajoutFournisseur(conn);
                        System.out.println();
                    }//Ajoute un fournisseur

                    case 4 -> {
                        System.out.println("Modification d'un Fournisseur : ");
                        System.out.println("Entrer l'Id : ");
                        FournisseurService.modifieFournisseur(conn, clavier.nextInt());
                        System.out.println("");
                    }//Modifie le fournisseur correspondant à l'id


                    case 5 -> {
                        System.out.println("Suppression d'un Fournisseur : ");
                        System.out.println("Entrer l'Id : ");
                        FournisseurService.supprimeFournisseur(conn, clavier.nextInt());
                        System.out.println();
                    }//Supprime le fournisseur correspondant à l'id

                    default -> {
                        System.out.println("");
                        System.out.println("Choix d'action incorrect");
                        System.out.println("");
                    }
                }
            }

            case 2 -> {//Table Articles
                switch (numAction) {
                    case 0 -> {
                        System.out.println("");
                        System.out.println("Vous avez quitte la table");
                        System.out.println("");
                    }

                    case 1 -> {
                        System.out.println("Affichage de la liste des Articles : ");
                        ArticleService.afficheLesArticles(conn);
                        System.out.println("");
                    }//Affiche tous les articles
                    
                    case 2 -> {
                        System.out.println("Affichage d'un Article : ");
                        System.out.println("Entrer l'Id : ");
                        ArticleService.afficheArticle(conn, clavier.nextInt());
                        System.out.println("");
                    }//Affiche l'article correspondant à l'id

                    case 3 -> {
                        System.out.println("Ajout d'un Article : ");
                        ArticleService.ajoutArticle(conn);
                        System.out.println("");
                    }//Ajoute un article

                    case 4 -> {
                        System.out.println("Modification d'un Article : ");
                        System.out.println("Entrer l'Id : ");
                        ArticleService.modifieArticle(conn, clavier.nextInt());
                        System.out.println("");
                    }//Modifie l'article correspondant à l'id


                    case 5 -> {
                        System.out.println("Suppression d'un Article : ");
                        System.out.println("Entrer l'Id : ");
                        ArticleService.supprimeArticle(conn, clavier.nextInt());
                        System.out.println("");
                    }//Supprime l'article correspondant à l'id

                    default -> {
                        System.out.println("");
                        System.out.println("Choix d'action incorrect");
                        System.out.println("");
                    }
                }
            }

            case 3 -> {//Table Clients
                switch (numAction) {
                    case 0 -> {
                        System.out.println("");
                        System.out.println("Vous avez quitte la table");
                        System.out.println("");
                    }

                    case 1 -> {
                        System.out.println("Affichage de la liste des Clients : ");
                        ClientsService.afficheLesClients(conn);
                        System.out.println("");
                    }//Affiche tous les clients
                    
                    case 2 -> {
                        System.out.println("Affichage d'un Client : ");
                        System.out.println("Entrer l'Id : ");
                        ClientsService.afficheClient(conn, clavier.nextInt());
                        System.out.println("");
                    }//Affiche le client correspondant à l'id

                    case 3 -> {
                        System.out.println("Ajout d'un Client : ");
                        ClientsService.ajoutClient(conn);
                        System.out.println("");
                    }//Ajoute un client

                    case 4 -> {
                        System.out.println("Modification d'un Client : ");
                        System.out.println("Entrer l'Id : ");
                        ClientsService.modifClient(conn, clavier.nextInt());
                        System.out.println("");
                    }//Modifie le client correspondant à l'id

                    case 5 -> {
                        System.out.println("Suppression d'un Client : ");
                        System.out.println("Entrer l'Id : ");
                        ClientsService.supprimeClient(conn, clavier.nextInt());
                        System.out.println("");
                    }//Supprime le client correspondant à l'id

                    default -> {
                        System.out.println("");
                        System.out.println("Choix d'action incorrect");
                        System.out.println("");
                    }
                }
            }

            case 4 -> {//Table Utilisateurs
                switch (numAction) {
                    case 0 -> {
                        System.out.println("");
                        System.out.println("Vous avez quitte la table");
                        System.out.println("");
                    }

                    case 1 -> {
                        System.out.println("Affichage de la liste des Utilisateurs : ");
                        UtilisateurService.afficheTousLesUtilisateurs(conn);
                        System.out.println("");
                    }//Affiche tous les utilisateurs
                    
                    case 2 -> {
                        System.out.println("Affichage d'un Utilisateur : ");
                        System.out.println("Entrer l'Id : ");
                        UtilisateurService.afficheUtilisateur(conn, clavier.nextInt());
                        System.out.println("");
                    }//Affiche l'utilisateur correspondant à l'id
                    
                    case 3 -> {
                        System.out.println("Ajout d'un Utilisateur : ");
                        UtilisateurService.ajoutUtilisateur(conn);
                        System.out.println("");
                    }//Ajoute un utilisateur
                    
                    case 4 -> {
                        System.out.println("Modification d'un Utilisateur : ");
                        System.out.println("Entrer l'Id : ");
                        UtilisateurService.modifUtilisateur(conn, clavier.nextInt());
                        System.out.println("");
                    }//Modifie l'utilisateur correspondant à l'id

                    case 5 -> {
                        System.out.println("Suppression d'un Utilisateur : ");
                        System.out.println("Entrer l'Id : ");
                        UtilisateurService.supprimeUtilisateur(conn, clavier.nextInt());
                        System.out.println("");
                    }//Supprime l'utilisateur correspondant à l'id

                    default -> {
                        System.out.println("");
                        System.out.println("Choix d'action incorrect");
                        System.out.println("");
                    }
                }
            }

            default -> {
                System.out.println("");
                System.out.println("Choix de table incorrect");
                System.out.println("");
            }
        }
    }
}
