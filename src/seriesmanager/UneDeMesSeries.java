/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import objets.Serie;


/**
 *
 * @author Wajdi
 */
public class UneDeMesSeries extends JPanel{
    
    Serie serie;
    
    public UneDeMesSeries(Serie serie){
    this.serie = serie;    
        
    //Deux premier panels 
    JPanel pnlBaseGauche = new JPanel();   
    JPanel pnlBaseDroite = new JPanel();
    //pnlBaseGauche.setPreferredSize(new Dimension(300,500));
    //pnlBaseDroite.setPreferredSize(new Dimension(300,500));
            
    //Premier Layout
    this.setLayout(new BorderLayout());
             
    GridBagConstraints gbc1 = new GridBagConstraints();
    
    /****************** AJOUTE PAR DJANGO POUR PAPI ***************/

    this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT));
//    gbc1.fill=GridBagConstraints.BOTH;
//    gbc1.insets = new Insets(5, 5, 5, 5);
//    gbc1.ipady=gbc1.anchor=GridBagConstraints.CENTER;
//    gbc1.weightx=10;
//    gbc1.weighty=10;

    /*******************************************************/
    
//    gbc1.gridx = 0;
//    gbc1.gridy = 0;
//    gbc1.gridheight = 1;
//    gbc1.gridwidth = 2;
//    gbc1.fill = GridBagConstraints.HORIZONTAL;
    this.add(pnlBaseGauche, BorderLayout.CENTER);
    
//    gbc1.gridx = 2;
//    gbc1.gridheight = 1;
//    gbc1.gridwidth = 1;
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
    lblTitre.setText("Titre");
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblTitre, gbc2);
    
    
    JPanel pnlImg = new JPanel();
    pnlImg.setBackground(Color.red);
    gbc2.gridx = 0;
    gbc2.gridy = 1;
    gbc2.gridheight = 8;
    gbc2.gridwidth = 6;
    gbc2.fill = GridBagConstraints.BOTH;
    pnlBaseGauche.add(pnlImg, gbc2);
    
    
    JLabel lblAnnee = new JLabel();
    lblAnnee.setText("Annee");
    gbc2.gridx = 7;
    gbc2.gridy = 1;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblAnnee, gbc2);
    
    
    JLabel lblRealisateur = new JLabel();
    lblRealisateur.setText("Realisateur");
    gbc2.gridx = 7;
    gbc2.gridy = 2;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblRealisateur, gbc2);
    
    
    JLabel lblPays = new JLabel();
    lblPays.setText("Pays");
    gbc2.gridx = 7;
    gbc2.gridy = 3;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblPays, gbc2);
    
    
    JLabel lblGenre=  new JLabel();
    lblGenre.setText("Genre");
    gbc2.gridx = 7;
    gbc2.gridy = 4;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblGenre, gbc2);
    
    
    JLabel lblActeur1 = new JLabel();
    lblActeur1.setText("Acteurs");
    gbc2.gridx = 7;
    gbc2.gridy = 5;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblActeur1, gbc2);
    
    
//    JLabel lblActeur2 = new JLabel();
//    lblActeur2.setText("Acteur2");
//    gbc2.gridx = 3;
//    gbc2.gridy = 4;
//    gbc2.gridheight = 1;
//    gbc2.gridwidth = 1;
//    pnlBaseGauche.add(lblActeur2, gbc2);
//    
//    
//    JLabel lblActeur3 = new JLabel();
//    lblActeur3.setText("Acteur3");
//    gbc2.gridx = 3;
//    gbc2.gridy = 4;
//    gbc2.gridheight = 1;
//    gbc2.gridwidth = 1;
//    pnlBaseGauche.add(lblActeur3, gbc2);
    
    
    JLabel lblStatut = new JLabel();
    lblStatut.setText("Statut");
    gbc2.gridx = 7;
    gbc2.gridy = 6;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblStatut, gbc2);
    
    
    JTextArea txtSerie = new JTextArea();
    txtSerie.setText("Statut");
    gbc2.gridx = 0;
    gbc2.gridy = 9;
    gbc2.gridheight = 4;
    gbc2.gridwidth = 4;
    gbc2.fill = GridBagConstraints.BOTH;
    pnlBaseGauche.add(txtSerie, gbc2);
    
    //On attaque le panel de droite
    
    JTabbedPane jtbSaison = new JTabbedPane();
    JPanel pnlTab1 = new JPanel();
    JPanel pnlTab2 = new JPanel();
    jtbSaison.addTab("saion1", pnlTab1);
    pnlTab1.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH/3, SeriesManager.MAIN_PANEL_HEIGHT - 100)); // django, valeur à modifier ?
    jtbSaison.addTab("saion2", pnlTab2);
    pnlTab1.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH/3, SeriesManager.MAIN_PANEL_HEIGHT - 100)); // django, valeur à modifier ?
    pnlBaseDroite.add(jtbSaison);
    
    
    }
}


/*** ANCIEN CODE APRES MES PREMIERES MODIF
 
package seriesmanager;
import java.awt.*;
import javax.swing.*;


public class UneDeMesSeries extends JPanel{
    
    public UneDeMesSeries(){
        
    //Deux premier panels 
    JPanel pnlBaseGauche = new JPanel();   
    JPanel pnlBaseDroite = new JPanel();
    //pnlBaseGauche.setPreferredSize(new Dimension(300,500));
    //pnlBaseDroite.setPreferredSize(new Dimension(300,500));
            
    //Premier Layout
    this.setLayout(new BorderLayout());
             
    GridBagConstraints gbc1 = new GridBagConstraints();
    
     /////////////////////////////////// AJOUTE PAR DJANGO POUR PAPI  ///////////////////////////////////

    this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT));
//    gbc1.fill=GridBagConstraints.BOTH;
//    gbc1.insets = new Insets(5, 5, 5, 5);
//    gbc1.ipady=gbc1.anchor=GridBagConstraints.CENTER;
//    gbc1.weightx=10;
//    gbc1.weighty=10;

    ///////////////////////////////////
    
//    gbc1.gridx = 0;
//    gbc1.gridy = 0;
//    gbc1.gridheight = 1;
//    gbc1.gridwidth = 2;
//    gbc1.fill = GridBagConstraints.HORIZONTAL;
    this.add(pnlBaseGauche, BorderLayout.WEST);
    
//    gbc1.gridx = 2;
//    gbc1.gridheight = 1;
//    gbc1.gridwidth = 1;
    this.add(pnlBaseDroite, BorderLayout.EAST);
    
    //On attaque le panel de gauche
    
    pnlBaseGauche.setLayout(new GridBagLayout());
    GridBagConstraints gbc2 = new GridBagConstraints();
    
    ///////////////////////////////////AJOUTE PAR DJANGO POUR PAPI
    gbc2.fill=GridBagConstraints.BOTH;
    gbc2.insets = new Insets(5, 5, 5, 5);
    gbc2.ipady=gbc2.anchor=GridBagConstraints.CENTER;
    gbc2.weightx=10;
    gbc2.weighty=10;
    ///////////////////////////////////
    
    JLabel lblTitre = new JLabel();
    lblTitre.setText("Titre");
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblTitre, gbc2);
    
    
    JPanel pnlImg = new JPanel();
    pnlImg.setBackground(Color.red);
    gbc2.gridx = 0;
    gbc2.gridy = 1;
    gbc2.gridheight = 8;
    gbc2.gridwidth = 2;
    gbc2.fill = GridBagConstraints.BOTH;
    pnlBaseGauche.add(pnlImg, gbc2);
    
    
    JLabel lblAnnee = new JLabel();
    lblAnnee.setText("Annee");
    gbc2.gridx = 3;
    gbc2.gridy = 1;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblAnnee, gbc2);
    
    
    JLabel lblRealisateur = new JLabel();
    lblRealisateur.setText("Realisateur");
    gbc2.gridx = 3;
    gbc2.gridy = 2;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblRealisateur, gbc2);
    
    
    JLabel lblPays = new JLabel();
    lblPays.setText("Pays");
    gbc2.gridx = 3;
    gbc2.gridy = 3;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblPays, gbc2);
    
    
    JLabel lblGenre=  new JLabel();
    lblGenre.setText("Genre");
    gbc2.gridx = 3;
    gbc2.gridy = 4;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblGenre, gbc2);
    
    
    JLabel lblActeur1 = new JLabel();
    lblActeur1.setText("Acteurs");
    gbc2.gridx = 3;
    gbc2.gridy = 5;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblActeur1, gbc2);
    
    
//    JLabel lblActeur2 = new JLabel();
//    lblActeur2.setText("Acteur2");
//    gbc2.gridx = 3;
//    gbc2.gridy = 4;
//    gbc2.gridheight = 1;
//    gbc2.gridwidth = 1;
//    pnlBaseGauche.add(lblActeur2, gbc2);
//    
//    
//    JLabel lblActeur3 = new JLabel();
//    lblActeur3.setText("Acteur3");
//    gbc2.gridx = 3;
//    gbc2.gridy = 4;
//    gbc2.gridheight = 1;
//    gbc2.gridwidth = 1;
//    pnlBaseGauche.add(lblActeur3, gbc2);
    
    
    JLabel lblStatut = new JLabel();
    lblStatut.setText("Statut");
    gbc2.gridx = 3;
    gbc2.gridy = 6;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblStatut, gbc2);
    
    
    JTextArea txtSerie = new JTextArea();
    txtSerie.setText("Statut");
    gbc2.gridx = 0;
    gbc2.gridy = 9;
    gbc2.gridheight = 4;
    gbc2.gridwidth = 4;
    gbc2.fill = GridBagConstraints.BOTH;
    pnlBaseGauche.add(txtSerie, gbc2);
    
    //On attaque le panel de droite
    
    JTabbedPane jtbSaison = new JTabbedPane();
    JPanel pnlTab1 = new JPanel();
    JPanel pnlTab2 = new JPanel();
    jtbSaison.addTab("saion1", pnlTab1);
    pnlTab1.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH/3, 200)); // django, valeur à modifier ?
    jtbSaison.addTab("saion2", pnlTab2);
    pnlTab1.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH/3, 200)); // django, valeur à modifier ?
    pnlBaseDroite.add(jtbSaison);
    
    
    }
}

 */