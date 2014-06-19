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
    
    
    public static List<Serie> getSeriesVues() {
        String query = "SELECT DISTINCT * FROM serie WHERE serie_vue = 1";
        return requestOnSerie(query);
    }
    
    public static List<Serie> getAllSerie(){
        return requestOnSerie("SELECT * FROM SERIE");
    }
    
    public static List<Serie> getAllSerieVues(){
        return requestOnSerie("SELECT * FROM SERIE WHERE serie_vue = 1");
    }
    
    public static void setSerieVue(String nomSerie, boolean signe){
        int vu = (signe) ? 1 : 0;
        Connexion connexion = new Connexion("serie_database.db");
        connexion.connect();  
        connexion.update("UPDATE SERIE SET serie_vue="+vu+" WHERE serie_name='"+nomSerie+"'");
        connexion.close();
    }
    
    private static List<Serie> requestOnSerie(String requete){
        
        Connexion connexion = new Connexion("serie_database.db");
        connexion.connect();
        
        List<Serie> series = new ArrayList<>();
        
        ResultSet resultSet = connexion.query(requete);
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
                s.setAnnee(resultSet.getDate("serie_annee"));
                s.setImg(resultSet.getString("serie_img"));
                series.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }              
        
//        // pour les test 
//        for(Serie s : series)
//            System.out.println("\n"+s+"\n");
       
        connexion.close();
        return series;
    
    }
    
}
