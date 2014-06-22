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
import objets.Episode;

/**
 *
 * @author Arles Mathieu
 */
public class EpisodeManager {
    
    public static List<Episode> getEpisodeBySaison(int sid) throws SQLException {
        List<Episode> episodes = new ArrayList<>();
        
       
        Connexion.createConnexion();
        
        ResultSet res = Connexion.query("SELECT * FROM EPISODE WHERE saison_id = " + sid);
       
        while(res.next()) {
            Episode e = new Episode();
            
            e.setDate_sortie(res.getDate("episode_date_sortie"));
            e.setDuree(res.getFloat("episode_duree"));
            e.setId(res.getInt("episode_id"));
            e.setName(res.getString("episode_name"));
            e.setSaison_id(sid);
            e.setSynopsis(res.getString("episode_synopsis"));
            
           
           episodes.add(e);
        }
        res.close();
        Connexion.close();
        
        return episodes;
    }
    
}
