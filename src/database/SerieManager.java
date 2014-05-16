/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Arles Mathieu
 */
public class SerieManager {
     
    public static void test(){
        Connexion connexion = new Connexion("serie_database.db");
        connexion.connect();
        
        ResultSet resultSet = connexion.query("SELECT * FROM SERIE");
        try {
            while (resultSet.next()) {
                System.out.println("Titre : "+resultSet.getString("serie_img"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        connexion.close();
    }
    
}
