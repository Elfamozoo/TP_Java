package dao;

//La table Utilisateurs correpond aux utilisateurs du programme dans une entreprise.
// * Les Utilisateurs ont un id, un numero d'employ� unique, un nom, un prenom, un email,
//        * un login et un mot de passe.

//* La table Clients contiendra les clients de l'entreprise. Ils ont un id, un num�ro unique,
//        * un nom, un pr�nom, un email et une adresse.

// * La table Fournisseurs correspond aux fournisseurs de l'entreprise.
//        * Ils ont un id, un num�ro unique, un nom, un email et une adresse.

// * La table Article correspond aux articles achet�s aux fournisseurs et vendu aux clients.
// * Ils ont un id, un numero unique, un champ indiquant si c'est un article achet� ou vendu, un nom, une description.

public class Entreprise {
    public static void main(String args[]) {
        final String str1 = "CREATE DATABASE IF NOT EXISTS Entreprise CHARACTER SET utf8;";
        final String str2 = "use Entreprise";
        final String str3 = "CREATE TABLE IF NOT EXISTS Utilisateurs ("
                + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "numeroEmploye INT NOT NULL, "
                + "nom VARCHAR(50) NOT NULL, "
                + "prenom VARCHAR(50) NOT NULL, "
                + "email VARCHAR(50) NOT NULL, "
                + "login VARCHAR(50) NOT NULL, "
                + "motDePasse VARCHAR(50) NOT NULL, ";
        final String str4 = "CREATE TABLE IF NOT EXISTS Clients ("
                + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "numeroClient INT NOT NULL, "
                + "nom VARCHAR(50) NOT NULL, "
                + "prenom VARCHAR(50) NOT NULL, "
                + "email VARCHAR(50) NOT NULL, "
                + "adresse VARCHAR(255) NOT NULL, ";
        final String str5 = "CREATE TABLE IF NOT EXISTS Fournisseurs ("
                + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "numeroFournisseur INT NOT NULL, "
                + "nom VARCHAR(50) NOT NULL, "
                + "email VARCHAR(50) NOT NULL, "
                + "adresse VARCHAR(255) NOT NULL, ";
        final String str6 = "CREATE TABLE IF NOT EXISTS Articles ("
                + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "numeroArticle INT NOT NULL, "
                + "nom VARCHAR(50) NOT NULL, "
                + "description VARCHAR(255) NOT NULL, "
                + "achat BOOLEAN NOT NULL, ";


    }

}
