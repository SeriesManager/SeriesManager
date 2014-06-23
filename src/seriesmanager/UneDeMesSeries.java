/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import database.EpisodeManager;
import database.SaisonManager;
import database.SerieManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import objets.Episode;
import objets.Saison;
import objets.Serie;

/**
 *
 * @author Wajdi
 */
public class UneDeMesSeries extends JPanel implements ActionListener {

    private final Serie serie;
    private JButton validerCommentaire;
    private JTextArea txtSerie;
    Integer vue;
    Episode unEpisode = new Episode();

    public UneDeMesSeries(Serie serie) throws SQLException {
        this.serie = serie;

        //Deux premier panels 
        JPanel pnlBaseGauche = new JPanel();
        JPanel pnlBaseDroite = new JPanel();

        //Premier Layout
        this.setLayout(new BorderLayout());

        GridBagConstraints gbc1 = new GridBagConstraints();

        /**
         * **************** AJOUTE PAR DJANGO POUR PAPI **************
         */
        this.setPreferredSize(new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT));

        /**
         * ****************************************************
         */
        this.add(pnlBaseGauche, BorderLayout.CENTER);

        this.add(pnlBaseDroite, BorderLayout.EAST);
        this.setBorder(new EmptyBorder(0, 0, 0, 30));

    //On attaque le panel de gauche
        pnlBaseGauche.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();

        /**
         * **************** AJOUTE PAR DJANGO POUR PAPI **************
         */
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(0, 0, 0, 0);
        gbc2.ipady = 10;
        //gbc2.anchor=GridBagConstraints.FIRST_LINE_START;
        /**
         * *******************************************
         */

// partie de gauche (titre, image, commentaire)
        JLabel lblTitre = new JLabel();
        lblTitre.setText(serie.getName());
        lblTitre.setFont(new java.awt.Font("Tahoma", 0, 20));
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.gridheight = 1;
        gbc2.gridwidth = 2;
        pnlBaseGauche.add(lblTitre, gbc2);

        JPanel pnlImg = new JPanel();
        JLabel monImage = new JLabel(new ImageIcon(serie.getImg()));
        pnlImg.add(monImage);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridheight = 7;
        gbc2.gridwidth = 2;
        gbc2.fill = GridBagConstraints.BOTH;
        pnlBaseGauche.add(pnlImg, gbc2);

        JPanel comm = new JPanel();
        comm.setLayout(new BorderLayout());
        txtSerie = new JTextArea();
        txtSerie.setPreferredSize(new Dimension(140, 30));
        txtSerie.setText(serie.getCommentaire());

        validerCommentaire = new JButton();
        validerCommentaire.setText("ok");

        validerCommentaire.addActionListener(this);

        comm.add(txtSerie, BorderLayout.WEST);
        comm.add(validerCommentaire, BorderLayout.EAST);

        gbc2.gridx = 0;
        gbc2.gridy = 8;
        gbc2.gridheight = 1;
        gbc2.gridwidth = 2;
        gbc2.fill = GridBagConstraints.BOTH;
        pnlBaseGauche.add(comm, gbc2);

        //On attaque le panel de droite
        gbc2.insets = new Insets(0, 20, 0, 0); // MARGIN
        gbc2.ipadx = 80;  // TAILLE DELA CELULE en X
        gbc2.ipady = 16;  // TAILLE DELA CELULE en Y
        JLabel lblAnnee = new JLabel();
        lblAnnee.setText("<html>Année : " + String.valueOf(serie.getAnnee()) + "</html>");
        //lblAnnee.setBorder(BorderFactory.createLineBorder(Color.black));
        gbc2.gridx = 2;
        gbc2.gridy = 1;
        gbc2.gridheight = 1;
        gbc2.gridwidth = 2;
        pnlBaseGauche.add(lblAnnee, gbc2);

        JLabel lblRealisateur = new JLabel();
        lblRealisateur.setText("<html>Réalisateur :<br>" + serie.getRealisateur() + "</html>");
        gbc2.gridx = 2;
        gbc2.gridy = 2;
        gbc2.gridheight = 1;
        gbc2.gridwidth = 2;
        pnlBaseGauche.add(lblRealisateur, gbc2);

        JLabel lblPays = new JLabel();
        lblPays.setText("<html>Pays :<br>" + serie.getPays() + "</html>");
        gbc2.gridx = 2;
        gbc2.gridy = 3;
        gbc2.gridheight = 1;
        gbc2.gridwidth = 2;
        pnlBaseGauche.add(lblPays, gbc2);

        JLabel lblGenre = new JLabel();
        lblGenre.setText("<html>Genre :<br>" + serie.getGenre() + "</html>");
        gbc2.gridx = 2;
        gbc2.gridy = 4;
        gbc2.gridheight = 1;
        gbc2.gridwidth = 2;
        pnlBaseGauche.add(lblGenre, gbc2);

        JLabel lblActeur1 = new JLabel();
        lblActeur1.setText("<html>Acteurs :<br>" + serie.getActeurs() + "</html>");
        gbc2.gridx = 2;
        gbc2.gridy = 5;
        gbc2.gridheight = 1;
        gbc2.gridwidth = 2;
        pnlBaseGauche.add(lblActeur1, gbc2);

        JLabel lblStatut = new JLabel();
        lblStatut.setText("<html>Statut : " + serie.getStatut() + "</html>");
        gbc2.gridx = 2;
        gbc2.gridy = 6;
        gbc2.gridheight = 1;
        gbc2.gridwidth = 2;
        pnlBaseGauche.add(lblStatut, gbc2);

        JTabbedPane jtbSaison = new JTabbedPane();
        jtbSaison.setBorder(new EmptyBorder(0, 0, 0, 0));
        ArrayList listeSaison = new ArrayList();
        listeSaison = (ArrayList) SaisonManager.getSaisonBySerie(serie.getId());
        JPanel tabJpanel[] = new JPanel[listeSaison.size()];

        for (int i = 0; i < listeSaison.size(); i++) {

            Saison uneSaison = new Saison();
            uneSaison = (Saison) listeSaison.get(i);
            tabJpanel[i] = new JPanel();
            tabJpanel[i].setLayout(new GridLayout(20, 1));
            jtbSaison.addTab(uneSaison.getName(), tabJpanel[i]);
            tabJpanel[i].setPreferredSize(new Dimension(SeriesManager.MAIN_PANEL_WIDTH / 3, SeriesManager.MAIN_PANEL_HEIGHT - 100));

            ArrayList listeEpisodes = new ArrayList();
            listeEpisodes = (ArrayList) EpisodeManager.getEpisodeBySaison(uneSaison.getId());
            JCheckBox tabCheckBox[] = new JCheckBox[listeEpisodes.size()];

            for (int y = 0; y < listeEpisodes.size(); y++) {

                unEpisode = (Episode) listeEpisodes.get(y);
                tabCheckBox[y] = new JCheckBox();
                tabCheckBox[y].setText(unEpisode.getName());

                vue = (Integer) EpisodeManager.getIfEpisodeViewed(unEpisode.getId());
                if (vue == 0) {
                    tabCheckBox[y].setSelected(false);
                } else {
                    tabCheckBox[y].setSelected(true);
                }

                tabCheckBox[y].addItemListener(
                        new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent e) {

                                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                                    if (vue == 0) {
                                        try {
                                            EpisodeManager.setEpisodeViewed(unEpisode.getId(), 1);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(UneDeMesSeries.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }

                                } else {
                                    try {
                                        EpisodeManager.setEpisodeViewed(unEpisode.getId(), 0);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(UneDeMesSeries.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                }

                            }
                        }
                );

                tabJpanel[i].add(tabCheckBox[y]);
            }

        }
        pnlBaseDroite.add(jtbSaison);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == validerCommentaire) {
            try {
                SerieManager.setCommentaire(serie.getId(), txtSerie.getText());
            } catch (SQLException ex) {
                Logger.getLogger(UneDeMesSeries.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
