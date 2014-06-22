/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objets.Saison;

/**
 *
 * @author Arles Mathieu
 */
public class SaisonManager {
    
    
    public static List<Saison> getSaisonBySerie(int sid) throws SQLException {
        List<Saison> saisons = new ArrayList<>();
        
        Connexion.createConnexion();
        
        ResultSet res = Connexion.query("SELECT * FROM SAISON WHERE serie_id = " + sid);
        
        while(res.next()) {
            Saison s = new Saison();
            s.setDate_sortie(res.getDate("saison_date_sortie"));
            s.setId(res.getInt("saison_id"));
            s.setId_serie(sid);
            s.setName(res.getString("saison_name"));
            s.setSynopsis(res.getString("saison_synopsis"));
            
            saisons.add(s);
        }
        res.close();
        Connexion.close();
        
        return saisons;
    }
}
