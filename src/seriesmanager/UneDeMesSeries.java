/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;
import database.EpisodeManager;
import database.SaisonManager;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import objets.Episode;
import objets.Saison;
import objets.Serie;


/**
 *
 * @author Wajdi
 */
public class UneDeMesSeries extends JPanel{
    
    Serie serie;
    
    public UneDeMesSeries(Serie serie) throws SQLException{
    this.serie = serie;    

        
    //Deux premier panels 
    JPanel pnlBaseGauche = new JPanel();   
    JPanel pnlBaseDroite = new JPanel();

            
    //Premier Layout
    this.setLayout(new BorderLayout());
             
    GridBagConstraints gbc1 = new GridBagConstraints();
    
    /****************** AJOUTE PAR DJANGO POUR PAPI ***************/

    this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT));

    /*******************************************************/
    

    this.add(pnlBaseGauche, BorderLayout.CENTER);
    

    this.add(pnlBaseDroite, BorderLayout.EAST);
    this.setBorder(new EmptyBorder(0, 0, 0, 30));
    
    //On attaque le panel de gauche
    
    pnlBaseGauche.setLayout(new GridBagLayout());
    GridBagConstraints gbc2 = new GridBagConstraints();
    
    /****************** AJOUTE PAR DJANGO POUR PAPI ***************/
    gbc2.fill=GridBagConstraints.BOTH;
    gbc2.insets = new Insets(5, 30, 30, 5);
    gbc2.ipady=gbc2.anchor=GridBagConstraints.CENTER;
    gbc2.weightx=15;
    gbc2.weighty=15;
    /**********************************************/
    
    JLabel lblTitre = new JLabel();
    lblTitre.setText(serie.getName());
    lblTitre.setFont(new java.awt.Font("Tahoma", 0, 24));
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblTitre, gbc2);
    
    
    JPanel pnlImg = new JPanel();
    JLabel monImage = new JLabel(new ImageIcon(serie.getImg()));
    pnlImg.add(monImage);
    gbc2.gridx = 0;
    gbc2.gridy = 1;
    gbc2.gridheight = 8;
    gbc2.gridwidth = 6;
    gbc2.fill = GridBagConstraints.BOTH;
    pnlBaseGauche.add(pnlImg, gbc2);
    
    
    JLabel lblAnnee = new JLabel();
    lblAnnee.setText(String.valueOf(serie.getAnnee()));
    gbc2.gridx = 7;
    gbc2.gridy = 1;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblAnnee, gbc2);
    
    
    JLabel lblRealisateur = new JLabel();
    lblRealisateur.setText(serie.getRealisateur());
    gbc2.gridx = 7;
    gbc2.gridy = 2;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblRealisateur, gbc2);
    
    
    JLabel lblPays = new JLabel();
    lblPays.setText(serie.getPays());
    gbc2.gridx = 7;
    gbc2.gridy = 3;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblPays, gbc2);
    
    
    JLabel lblGenre=  new JLabel();
    lblGenre.setText(serie.getGenre());
    gbc2.gridx = 7;
    gbc2.gridy = 4;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblGenre, gbc2);
    
    
    JLabel lblActeur1 = new JLabel();
    lblActeur1.setText(serie.getActeurs());
    gbc2.gridx = 7;
    gbc2.gridy = 5;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblActeur1, gbc2);
    
    
    JLabel lblStatut = new JLabel();
    lblStatut.setText(serie.getStatut());
    gbc2.gridx = 7;
    gbc2.gridy = 6;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblStatut, gbc2);
    
    
    JTextArea txtSerie = new JTextArea();
    txtSerie.setText(serie.getCommentaire());
    gbc2.gridx = 0;
    gbc2.gridy = 9;
    gbc2.gridheight = 4;
    gbc2.gridwidth = 4;
    gbc2.fill = GridBagConstraints.BOTH;
    pnlBaseGauche.add(txtSerie, gbc2);
    
    //On attaque le panel de droite
    
    JTabbedPane jtbSaison = new JTabbedPane();
    ArrayList listeSaison = new ArrayList();
    listeSaison = (ArrayList) SaisonManager.getSaisonBySerie(serie.getId());
    JPanel tabJpanel[]= new JPanel[listeSaison.size()];
    
    
    for(int i=0; i<listeSaison.size(); i++) {

        Saison uneSaison = new Saison();
        uneSaison = (Saison) listeSaison.get(i);
        tabJpanel[i]=new JPanel();
        tabJpanel[i].setLayout(new GridLayout(20, 1));
        jtbSaison.addTab(uneSaison.getName(), tabJpanel[i]);
        tabJpanel[i].setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH/3, SeriesManager.MAIN_PANEL_HEIGHT - 100));
        
        ArrayList listeEpisodes = new ArrayList();
        listeEpisodes = (ArrayList) EpisodeManager.getEpisodeBySaison(uneSaison.getId());
        JCheckBox tabCheckBox[]= new JCheckBox[listeEpisodes.size()];
        
         for(int y=0; y<listeEpisodes.size(); y++) {
            
            Episode unEpisode = new Episode();
            unEpisode = (Episode) listeEpisodes.get(y);
            tabCheckBox[y]=new JCheckBox();
            tabCheckBox[y].setText(unEpisode.getName());
            tabJpanel[i].add(tabCheckBox[y]);
        }

}
    pnlBaseDroite.add(jtbSaison);
    }
}