/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import database.SerieManager;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.List;
import javax.swing.JPanel;
import objets.Serie;

/**
 *
 * @author Arles Mathieu
 */
public class Accueil extends JPanel {

    private final static int NB_VIGNETTE_LIGNE = 5;

    public Accueil() throws IOException {
        //this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT) );

        // On récupère les séries
        List<Serie> seriesWeek = SerieManager.getSeriesOfTheWeek();
        List<Serie> seriesVues = SerieManager.getSeriesVues();

        GridLayout gl = new GridLayout(2, 1);
        gl.setVgap(30);
        this.setLayout(gl);

        PanelVignette serieSemaine = new PanelVignette("Série de la semaine", 1, NB_VIGNETTE_LIGNE);
        PanelVignette episodesVus = new PanelVignette("Episodes vus", 1, NB_VIGNETTE_LIGNE);

        int i = 0;
        while (!serieSemaine.isFull()) {
            if (seriesWeek.size() > i) {
                serieSemaine.addVignette(new VignetteButton(seriesWeek.get(i), seriesWeek.get(i).isVue()));
            } else {
                serieSemaine.addVignette(new Vignette(null));
            }
            i++;
        }
        
        i = 0;
        while (!episodesVus.isFull()) {
            if (seriesVues.size() > i) {
                episodesVus.addVignette(new VignetteButton(seriesVues.get(i), seriesVues.get(i).isVue()));
            } else {
                episodesVus.addVignette(new Vignette(null));
            }
            i++;
        }

        this.add(serieSemaine);
        this.add(episodesVus);

    }
}
