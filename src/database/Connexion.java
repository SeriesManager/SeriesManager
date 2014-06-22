/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Arles Mathieu
 * @author Heloise 
 * 
 * @brief class used for database connexion
 * as an utility class it doesn't need instantiation
 * DBpath should be specified only once, in config files or here.
 */
public class Connexion {
    private final static String DBPath = "serie_database.db";
    private static Connection connection = null;
    private static Statement statement = null;
    private Connexion() {
       
    }
    
    public static void createConnexion() {
    	 try {
             Class.forName("org.sqlite.JDBC");
             connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
             statement = connection.createStatement();
             System.out.println("Connexion a " + DBPath + " avec succès");
         } catch (ClassNotFoundException notFoundException) {
             notFoundException.printStackTrace();
             System.out.println("Erreur de connexion");
         } catch (SQLException sqlException) {
             sqlException.printStackTrace();
             System.out.println("Erreur de connexion");
         }
    	
    }
 
    public static void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static ResultSet query(String requet) {
       ResultSet resultat = null;
       try {
           resultat = statement.executeQuery(requet);
       } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("Erreur dans la requête : " + requet);
       }
       return resultat;
   }
    
   public static  void update(String requet) {
       try {
           statement.executeUpdate(requet);
       } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("Erreur dans la requête : " + requet);
       }
   }
}
