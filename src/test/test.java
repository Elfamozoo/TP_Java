package test;

import java.sql.*;

import dao.Entreprise;
import main.MenuAction;
import main.MenuTable;
import main.ResultAction;


/**
 *
 * @author vincs
 */
public class test {
    private static final String DB_URL = "jdbc:mysql://localhost:3306?useSSL=false";
    private static final String DB_NAME = "Entreprise";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Entreprise.createDatabase(conn, DB_NAME);
            Entreprise.useDatabase(conn, DB_NAME);
            Entreprise.createTables(conn);
            
            System.out.println();
            
            Integer reponseTable = 9;
            Integer reponseAction  = 9;
            
            while (reponseTable != 0) {
                reponseTable = MenuTable.afficheTable();
                if(reponseTable != 0){ 
                    while (reponseAction != 0){
                        reponseAction = MenuAction.afficheAction();
                        ResultAction.afficheResult(conn, reponseTable, reponseAction);
                    }
                }
                reponseAction = 9;
            }            
            conn.close();            
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }   
    }
}
