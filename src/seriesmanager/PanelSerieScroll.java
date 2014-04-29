/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Django
 */
public class PanelSerieScroll extends JPanel{
    
    private JScrollPane vertical;
    private final static int NB_VIGNETTE_LIGNE = 5;
        
    public PanelSerieScroll(){
        this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT) );
        this.setBackground(Color.green);
        this.setLayout(new BorderLayout());
        JPanel container = new JPanel();
        
        // ON RECUPERE LE NOMBRE DEVIGNETTE A AFFICHR EN BASE DE DONNEE
        int nbVignette = 20;
        // ON DIVISE LE NOMBRE PAR 5 (nombre par lignes)
        float  nbLigne = nbVignette / NB_VIGNETTE_LIGNE;
        // ON MULTIPLIE LE NOMBRE DELIGNE AR LA HAUTEUR D'UNE VIGNETTE
        int height_scroll = Math.round(nbLigne * Vignette.PANEL_HEIGHT);
        // ON ADAPTE LA TAILLE DU CONTAINER
        container.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH - 25, height_scroll + 90) );
        // ON AJOUTE LES VIGNETTES
        for(int i = 0; i<nbVignette; ++i){
            container.add(new VignetteButton(null, ("Vignette " + (i+1)), true)); //container.add(new Vignette(i+1));
        }
       
        // ON AJOUTE NOTRE PANEL A SCROLL PANEL
        vertical = new JScrollPane();
        vertical.setPreferredSize(new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT));
        vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        vertical.setViewportView(container);   
        this.add(vertical, BorderLayout.CENTER);

    }
}
