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

    public static List<Serie> getAllSerie(){
        Connexion connexion = new Connexion("serie_database.db");
        connexion.connect();
        
        List<Serie> series = new ArrayList<Serie>();
        
        ResultSet resultSet = connexion.query("SELECT * FROM SERIE");
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
        
        // pour les test 
        for(Serie s : series)
            System.out.println("\n"+s+"\n");
        connexion.close();
        return series;
    }
    
}
