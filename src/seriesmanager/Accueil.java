/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Arles Mathieu
 */
public class Accueil extends JPanel{
    
    
    
    public Accueil(){
        this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT) );
        this.setBackground(Color.orange);
        
        this.setLayout(new GridLayout(2,1));
        
        PanelVignette serieSemaine = new  PanelVignette("Série de la semaine", 1, 6);
        PanelVignette episodesVus = new PanelVignette("Episodes vus", 1,6);
        
        while(!serieSemaine.isFull())
            serieSemaine.addVignette(new Vignette(null, "Test"));
        
        while(!episodesVus.isFull())
            episodesVus.addVignette(new Vignette(null, "Test"));
        
        this.add(serieSemaine);
        this.add(episodesVus);
        
    }
}
