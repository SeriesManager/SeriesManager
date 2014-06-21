/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import database.SerieManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import objets.Serie;

/**
 *
 * @author Arles Mathieu
 */
public class TriListener implements ActionListener {

    public final static String TRI_NAME = "tri par nom";
    public final static String TRI_DATE = "tri par date";
    public final static String TRI_POPULARITY = "tri par popularité";

    private final static String COL_NAME = "serie_name";
    private final static String COL_DATE = "serie_annee";
    private final static String COL_POPULARITY = "serie_note";

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JComboBox cb = (JComboBox) e.getSource();
            String tri = (String) cb.getSelectedItem();
            List<Serie> series = null;
            
            Fenetre fenetre = (Fenetre) cb.getTopLevelAncestor();
            JPanel page = (JPanel) fenetre.page;
            //Si on est dans toutes mes series
            if (fenetre.mesSeries != null) {
                
                switch (tri) {
                    case TRI_NAME:
                        series = SerieManager.getAllSerieVues(COL_NAME);
                        break;
                    case TRI_DATE:
                        series = SerieManager.getAllSerieVues(COL_DATE);
                        break;
                    case TRI_POPULARITY:
                        series = SerieManager.getAllSerieVues(COL_POPULARITY);
                        break;
                }
                
            }//si on est dans toutes les series
            else if (fenetre.lesSeries != null) {
                
                switch (tri) {
                    case TRI_NAME:
                        series = SerieManager.getAllSerie(COL_NAME);
                        break;
                    case TRI_DATE:
                        series = SerieManager.getAllSerie(COL_DATE);
                        break;
                    case TRI_POPULARITY:
                        series = SerieManager.getAllSerie(COL_POPULARITY);
                        break;
                }
                
            }
            page.removeAll();
            page.add(new PanelSerieScroll(fenetre.nordOuest,series));
            page.revalidate();
            page.repaint();
        } catch (IOException ex) {
            Logger.getLogger(TriListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
