/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager.Calendrier.dao.impl;

import database.Connexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import seriesmanager.Calendrier.dao.SerialsDao;
import seriesmanager.Calendrier.dto.Serial;

/**
 * En cours 
 * @author Héloïse
 */
public class SimpleSerialsDao implements SerialsDao{
    
   

    @Override
    public List<Serial> getSerialListForDay(Date date) {
       
         Connexion.createConnexion();

     	String theDay = new SimpleDateFormat("YYYY-MM-dd").format(date);
     	theDay = '"' + theDay + '"'; //in sqlite dates are stored as strings.
     	StringBuilder queryString  = new  StringBuilder();
     	queryString.append(" select ");
     	queryString.append(" ser.serie_name ").append(',');
     	queryString.append(" ser.serie_genre ").append(',');
     	queryString.append(" sai.saison_name ").append(',');
     	queryString.append(" epi.episode_name ").append(',');
     	queryString.append(" epi.episode_synopsis ");
     	queryString.append(" from ");
     	queryString.append(" Serie ").append(" as ser ").append(',');
     	queryString.append(" Episode ").append(" as epi ").append(',');
     	queryString.append(" Saison ").append(" as sai ");
     	queryString.append(" where ");
     	queryString.append(" ser.serie_id ").append('=').append(" sai.serie_id ").append(" and ");
     	queryString.append(" sai.saison_id ").append('=').append(" epi.saison_id ").append(" and ");
     	queryString.append(" epi.episode_date_sortie ").append('=').append(theDay);
     	
        ResultSet res = Connexion.query(queryString.toString());
        List<Serial> serials = new ArrayList<>();
        try {
			while(res.next()){
				Serial s = new Serial("", res.getString("serie_name"), res.getString("serie_genre"), date, res.getString("saison_name"), res.getString("episode_name"));
				s.setSynopsis(res.getString("episode_synopsis"));
				serials.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Connexion.close();
		}
		return serials;
        
    }

    @Override
    public List<Serial> getSerialListForMonth(Date date) {
    	   
        Connexion.createConnexion();
        String theDay = new SimpleDateFormat("YYYY-MM").format(date);
        String first  = '"' + theDay + "-01"  + '"';
        String second  = '"' + theDay + "-31" + '"';
        
     	StringBuilder queryString  = new  StringBuilder();
     	queryString.append(" select ");
     	queryString.append(" ser.serie_name ").append(',');
     	queryString.append(" ser.serie_genre ").append(',');
     	queryString.append(" epi.episode_date_sortie ").append(',');

     	queryString.append(" sai.saison_name ").append(',');
     	queryString.append(" epi.episode_name ").append(',');
     	queryString.append(" epi.episode_synopsis ");
     	
     	queryString.append(" from ");
     	queryString.append(" Serie ").append(" as ser ").append(',');
     	queryString.append(" Episode ").append(" as epi ").append(',');
     	queryString.append(" Saison ").append(" as sai ");
     	queryString.append(" where ");
     	queryString.append(" ser.serie_id ").append('=').append(" sai.serie_id ").append(" and ");
     	queryString.append(" sai.saison_id ").append('=').append(" epi.saison_id ").append(" and ");
     	queryString.append(" epi.episode_date_sortie ").append(" between ").append(first).append(" and ").append(second);
        ResultSet res = Connexion.query(queryString.toString());
        List<Serial> serials = new ArrayList<>();
        try {
			while(res.next()){

				Date episodeDate = new SimpleDateFormat("yyyy-MM-dd").parse(res.getString("episode_date_sortie"));
				Serial s = new Serial("", res.getString("serie_name"), res.getString("serie_genre"), episodeDate, res.getString("saison_name"), res.getString("episode_name"));
				
				serials.add(s);
			}
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			Connexion.close();
		}
        
		return serials; 
   }

    @Override
    public List<Serial> getSerialListForYear(Date date) {
    	   
        Connexion.createConnexion();
        String theDay = new SimpleDateFormat("YYYY").format(date);
        String first  = '"' + theDay + "-01-01"  + '"';
        String second  = '"' + theDay + "-12-31" + '"';
        
        
     	StringBuilder queryString  = new  StringBuilder();
     	queryString.append(" select ");
     	queryString.append(" ser.serie_name ").append(',');
     	queryString.append(" ser.serie_genre ").append(',');
     	queryString.append(" epi.episode_date_sortie ").append(',');

     	queryString.append(" sai.saison_name ").append(',');
     	queryString.append(" epi.episode_name ").append(',');
     	queryString.append(" epi.episode_synopsis ");
     	queryString.append(" from ");
     	queryString.append(" Serie ").append(" as ser ").append(',');
     	queryString.append(" Episode ").append(" as epi ").append(',');
     	queryString.append(" Saison ").append(" as sai ");
     	queryString.append(" where ");
     	queryString.append(" ser.serie_id ").append('=').append(" sai.serie_id ").append(" and ");
     	queryString.append(" sai.saison_id ").append('=').append(" epi.saison_id ").append(" and ");
     	queryString.append(" epi.episode_date_sortie ").append(" between ").append(first).append(" and ").append(second);
     	
        ResultSet res = Connexion.query(queryString.toString());
        
        List<Serial> serials = new ArrayList<>();
        try {
			while(res.next()){
				Date episodeDate = new SimpleDateFormat("yyyy-MM-dd").parse(res.getString("episode_date_sortie"));
				Serial s = new Serial("", res.getString("serie_name"), res.getString("serie_genre"),episodeDate ,  res.getString("saison_name"),  res.getString("episode_name"));
				serials.add(s);
			}
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			Connexion.close();
		}
		return serials;
   }
    
    
}
