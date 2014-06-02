/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager.Calendrier.dao.impl;

import database.Connexion;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import seriesmanager.Calendrier.dto.Serial;

/**
 * En cours 
 * @author Héloïse
 */
public class SerialsDao implements seriesmanager.Calendrier.dao.SerialsDao{
    
    Connexion connexion;
    String DbPath = null;

    public SerialsDao() {
        
        this.connexion = new Connexion(DbPath);
    }

    @Override
    public List<Serial> getSerialListForDay(Date date) {
        connexion.connect();
        
        ResultSet res = connexion.query("SELCT FROM WHERE");
        connexion.close();
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Serial> getSerialListForMonth(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Serial> getSerialListForYear(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
