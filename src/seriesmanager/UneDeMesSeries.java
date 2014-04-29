/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;
import java.awt.*;
import javax.swing.*;


/**
 *
 * @author Wajdi
 */
public class UneDeMesSeries extends JPanel{
    
    public UneDeMesSeries(){
        
    //Deux premier panels 
    JPanel pnlBaseGauche = new JPanel();   
    JPanel pnlBaseDroite = new JPanel();

    //pnlBaseGauche.setPreferredSize(new Dimension(300,500));
    //pnlBaseDroite.setPreferredSize(new Dimension(300,500));
            
    //Premier Layout
    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc1 = new GridBagConstraints();
    
    gbc1.gridx = 0;
    gbc1.gridy = 0;
    gbc1.gridheight = 1;
    gbc1.gridwidth = 2;
    gbc1.fill = GridBagConstraints.HORIZONTAL;
    this.add(pnlBaseGauche, gbc1);
    
    gbc1.gridx = 2;
    gbc1.gridheight = 1;
    gbc1.gridwidth = 1;
    this.add(pnlBaseDroite, gbc1);
    
    //On attaque le panel de gauche
    
    pnlBaseGauche.setLayout(new GridBagLayout());
    GridBagConstraints gbc2 = new GridBagConstraints();
    
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
    gbc2.gridy = 3;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblGenre, gbc2);
    
    
    JLabel lblActeur1 = new JLabel();
    lblActeur1.setText("Acteur1");
    gbc2.gridx = 3;
    gbc2.gridy = 4;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblActeur1, gbc2);
    
    
    JLabel lblActeur2 = new JLabel();
    lblActeur2.setText("Acteur2");
    gbc2.gridx = 3;
    gbc2.gridy = 4;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblActeur2, gbc2);
    
    
    JLabel lblActeur3 = new JLabel();
    lblActeur3.setText("Acteur3");
    gbc2.gridx = 3;
    gbc2.gridy = 4;
    gbc2.gridheight = 1;
    gbc2.gridwidth = 1;
    pnlBaseGauche.add(lblActeur3, gbc2);
    
    
    JLabel lblStatut = new JLabel();
    lblStatut.setText("Statut");
    gbc2.gridx = 3;
    gbc2.gridy = 5;
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
    jtbSaison.addTab("saion2", pnlTab2);
    pnlBaseDroite.add(jtbSaison);
    
    
    }
}
