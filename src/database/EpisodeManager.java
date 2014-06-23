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

        while (res.next()) {
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

    public static int getAllEpisodeViewed() throws SQLException {
        // Connexion conn = new Connexion("serie_database.db");
        Connexion.createConnexion();
        //conn.connect();
        int resultat;

        ResultSet res = Connexion.query("SELECT count(*) as nb FROM EPISODE WHERE episode_vue = 1");
        resultat = res.getInt("nb");

        Connexion.close();
        return resultat;
    }

    public static int getTotalTimeViewed() throws SQLException {

        //  Connexion conn = new Connexion("serie_database.db");
        Connexion.createConnexion();
        int resultat;
        //  conn.connect();

        ResultSet res = Connexion.query("SELECT sum(episode_duree) as duree from episode where episode_vue = 1");

        resultat = res.getInt("duree");
        Connexion.close();
        return resultat;
    }

   public static int getIfEpisodeViewed(int sid) throws SQLException {

        Connexion.createConnexion();

        int resultat;
        ResultSet res = Connexion.query("SELECT episode_vue as vue from episode where episode_id = " + sid);

        resultat = res.getInt("vue");
        
        Connexion.close();
        return resultat;
    }

    public static void setEpisodeViewed(int sid, int pvue) throws SQLException {

        Connexion.createConnexion();

        //System.out.println("update" + sid + " " + pvue);
        Connexion.update("update episode set episode_vue=" + pvue + " where episode_id = " + sid);
        
        Connexion.close();
    }

}
