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
import objets.Serie;
import static database.Connexion.close;
import static database.Connexion.createConnexion;
import static database.Connexion.query;
import static database.Connexion.update;

/**
 *
 * @author Arles Mathieu
 */
public class SerieManager {

    /**
     * Retourne les séries de la semaine
     * @return Retourne une liste de série 
     */
    public static List<Serie> getSeriesOfTheWeek() {
        String query = "SELECT DISTINCT serie.serie_id, serie_name, serie_annee, "
                + "serie_vue, serie_statut, serie_acteurs, serie_realisateurs,serie_pays, serie_genre,"
                + "serie_commentaire, serie_note,serie_img "
                + "FROM serie, saison, episode "
                + "WHERE serie.serie_id = saison.serie_id AND saison.saison_id = episode.saison_id "
                + "AND julianday('now') - julianday(episode_date_sortie) <= 7";
        return requestOnSerie(query);
    }
    
    /**
     * Retourne les série que l'on suit ou dont on a vu un épisode
     * @return  Retourne une liste de série
     */
    public static List<Serie> getSeriesVues() {
        String query = "SELECT DISTINCT serie.serie_id, serie_name, serie_annee, "
                + "serie_vue, serie_statut, serie_acteurs, serie_realisateurs,serie_pays, serie_genre,"
                + "serie_commentaire, serie_note,serie_img "
                + "FROM serie, saison, episode "
                + "WHERE serie_vue = 1 OR episode_vue=1";
        return requestOnSerie(query);
    }
    
    public static List<Serie> getSeriesByNom(String part_name) {
        String query = "SELECT DISTINCT * FROM serie WHERE serie_name LIKE '%"+part_name+"%'";
        return requestOnSerie(query);
    }
    
    public static List<Serie> getAllSerie(String order){
        if(order != null)
            return requestOnSerie("SELECT * FROM SERIE ORDER BY " + order);
        else
            return requestOnSerie("SELECT * FROM SERIE");
    }
    
    public static List<Serie> getAllSerieVues(String order){
        if(order != null)
            return requestOnSerie("SELECT * FROM SERIE WHERE serie_vue = 1 ORDER BY " + order);
        else
            return requestOnSerie("SELECT * FROM SERIE WHERE serie_vue = 1");
    }
    
    public static void setSerieVue(String nomSerie, boolean signe){
        int vu = (signe) ? 1 : 0;
        createConnexion(); 
        update("UPDATE SERIE SET serie_vue="+vu+" WHERE serie_name='"+nomSerie+"'");
        close();
    }
    
    private static List<Serie> requestOnSerie(String requete){
        
        createConnexion();
        
        List<Serie> series = new ArrayList<>();
        
        ResultSet resultSet = query(requete);
        try {
            while (resultSet.next()) {
                Serie s = new Serie();
                s.setId(resultSet.getInt("serie_id"));
                s.setName(resultSet.getString("serie_name"));
                s.setRealisateur(resultSet.getString("serie_realisateurs"));
                s.setActeurs(resultSet.getString("serie_acteurs"));
                s.setPays(resultSet.getString("serie_pays"));
                s.setGenre(resultSet.getString("serie_genre"));
                s.setStatut(resultSet.getString("serie_statut"));
                s.setVue(resultSet.getBoolean("serie_vue"));
                s.setCommentaire(resultSet.getString("serie_commentaire"));
                s.setNote(resultSet.getFloat("serie_note"));
                s.setAnnee(resultSet.getInt("serie_annee"));
                s.setImg(resultSet.getString("serie_img"));
                series.add(s);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }              
        
//        // pour les test 
//        for(Serie s : series)
//            System.out.println("\n"+s+"\n");
       
        close();
        return series;
    
    }
    
}
