/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import database.SerieManager;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import objets.Serie;

/**
 *
 * @author Arles Mathieu
 */
public class Accueil extends JPanel{

    private final static int NB_VIGNETTE_LIGNE = 5;
    
    public Accueil() throws IOException{
        //this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT) );
        
        // ON RECUPERE LES SERIES
        ArrayList<Serie> series = (ArrayList<Serie>) SerieManager.getAllSerie();
        
        GridLayout gl = new GridLayout(2,1);
        gl.setVgap(30);
        this.setLayout(gl);

        // MATHIEU --> à mettre à jour (paramètres en fonction de ce qui est récupéré)
        PanelVignette serieSemaine = new  PanelVignette("Série de la semaine", 1, NB_VIGNETTE_LIGNE);
        PanelVignette episodesVus = new PanelVignette("Episodes vus", 1,NB_VIGNETTE_LIGNE);
        
        while(!serieSemaine.isFull())
            serieSemaine.addVignette(new VignetteButton(series.get(0),true));
        
        while(!episodesVus.isFull())
            episodesVus.addVignette(new VignetteButton(series.get(1),true));
        
        this.add(serieSemaine);
        this.add(episodesVus);
        
        
    }
}
