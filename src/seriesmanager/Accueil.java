/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Arles Mathieu
 */
public class Accueil extends JPanel{
    
    
    private final static int NB_VIGNETTE_LIGNE = 5;
    
    public Accueil(){
        this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT) );
        this.setBackground(Color.orange);
        
        this.setLayout(new GridLayout(2,1));
        
        PanelVignette serieSemaine = new  PanelVignette("Série de la semaine", 1, NB_VIGNETTE_LIGNE);
        PanelVignette episodesVus = new PanelVignette("Episodes vus", 1,NB_VIGNETTE_LIGNE);
        
        while(!serieSemaine.isFull())
            serieSemaine.addVignette(new Vignette(null, "Test"));
        
        while(!episodesVus.isFull())
            episodesVus.addVignette(new Vignette(null, "Test"));
        
        this.add(serieSemaine);
        this.add(episodesVus);
        
    }
}
