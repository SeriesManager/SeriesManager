/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import database.EpisodeManager;
import database.SerieManager;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import objets.Serie;

/**
 *
 * @author Django
 */
public class Profil extends JPanel{
    
   
    public Profil() throws SQLException{
        
		//this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT));
		/* On ajoute un gridbagLauout au this */
		this.setLayout(new GridBagLayout());
		this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT - 15));
     
		/* Le gridBagConstraints va définir la position et la taille des éléments */
		GridBagConstraints gc = new GridBagConstraints();
		//gc.anchor = GridBagConstraints.NORTHWEST;

		/* 

		 
 le parametre fill sert à définir comment le composant sera rempli
		 
 GridBagConstraints.BOTH permet d'occuper tout l'espace disponible horizontalement et verticalement
		 
 GridBagConstraints.HORIZONTAL maximise horizontalement
		 
 GridBagConstraints.VERTICAL maximise verticalement
		 
*/

		gc.fill=GridBagConstraints.BOTH;
		
		/*

		 
 insets définir la marge entre les composant
		 
 new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite)
		 
*/

		gc.insets = new Insets(5, 5, 5, 5);
		
		/*

		 
 ipady permet de savoir où on place le composant s'il n'occupe pas la totalité
		 
 de l'espace disponnible
		 
*/

		gc.ipady=gc.anchor=GridBagConstraints.CENTER;
	
		/* weightx définit le nombre de cases en abscisse */
		gc.weightx=6;
		
		/* weightx définit le nombre de cases en ordonnée */
		gc.weighty=6;
		
		/* 

		 
 pour dire qu'on ajoute un composant en position (i, j), on définit
		 
 gridx=i et gridy=j
		 
*/
                
    // séries la plus regardée           
    JLabel lbl_plus_vu = new JLabel();
    lbl_plus_vu.setText("Série la plus vue : ");
    gc.gridx = 0;
    gc.gridy = 0;
    gc.gridheight = 1;
    gc.gridwidth = 1;
    this.add(lbl_plus_vu, gc);
    
    JLabel lbl_reponse_plus_vu = new JLabel();
    lbl_reponse_plus_vu.setText(SerieManager.getMostViewedSerie());
    gc.gridx = 1;
    gc.gridy = 0;
    gc.gridheight = 1;
    gc.gridwidth = 1;
    this.add(lbl_reponse_plus_vu, gc);
    
    
    
    // nombre d'heure
    JLabel nbr_heure = new JLabel();
    nbr_heure.setText("Nombre d'heure de visionnage : ");
    gc.gridx = 0;
    gc.gridy = 1;
    gc.gridheight = 1;
    gc.gridwidth = 1;
    this.add(nbr_heure, gc);
    
    JLabel reponse_nbr_heure = new JLabel();
    int duree = EpisodeManager.getTotalTimeViewed();
    int hours = duree / 60;
    int minutes = duree % 60;
    reponse_nbr_heure.setText(hours + " heures et " + minutes + " minutes");
    gc.gridx = 1;
    gc.gridy = 1;
    gc.gridheight = 1;
    gc.gridwidth = 1;
    this.add(reponse_nbr_heure, gc);
    
    
    
    
    // nombre episode
    JLabel nbr_episode = new JLabel();
    nbr_episode.setText("Nombre d'episodes vus : ");
    gc.gridx = 0;
    gc.gridy = 3;
    gc.gridheight = 1;
    gc.gridwidth = 1;
    this.add(nbr_episode, gc);
    
    JLabel reponse_nbr_episode = new JLabel();
    int nbEpisode = EpisodeManager.getAllEpisodeViewed();
    reponse_nbr_episode.setText(nbEpisode + " épisodes vus");
    gc.gridx = 1;
    gc.gridy = 3;
    gc.gridheight = 1;
    gc.gridwidth = 1;
    this.add(reponse_nbr_episode, gc);
    
    
    
    
    // nombre serie vues
    JLabel nbr_serie = new JLabel();
    nbr_serie.setText("Nombre de série visionnées : ");
    gc.gridx = 0;
    gc.gridy = 4;
    gc.gridheight = 1;
    gc.gridwidth = 1;
    this.add(nbr_serie, gc);
    
    JLabel reponse_nbr_serie = new JLabel();
    List<Serie> ls = SerieManager.getAllSerieVues(null);
    int nbSerie = ls.size();
    reponse_nbr_serie.setText(nbSerie + " séries");
    gc.gridx = 1;
    gc.gridy = 4;
    gc.gridheight = 1;
    gc.gridwidth = 1;
    this.add(reponse_nbr_serie, gc);
		
  }

}
