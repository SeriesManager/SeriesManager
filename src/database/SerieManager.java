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
     * @throws SQLException 
     */
    public static List<Serie> getSeriesOfTheWeek() throws SQLException {
        List<Serie> series = new ArrayList();
        
        Connexion conn = new Connexion("serie_database.db");
        conn.connect();
        
        ResultSet rs = conn.query("SELECT idSerie, nomSerie, dateSortie, nationalite, "
                + "vu, termine, synopsis, acteurs, realisateur "
                + "FROM serie, saison "
                + "WHERE serie.nomSerie = saison.nomSaison");
        
        while(rs.next()) {
            
        }
        
        
        conn.close();
        return series;
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
                s.setAnnee(resultSet.getInt("serie_annee"));
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
