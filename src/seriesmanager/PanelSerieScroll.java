/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Django
 */
public class PanelSerieScroll extends JPanel{
    
    private JScrollPane vertical;
    private JPanel filtreBouton;
    private JComboBox combo;

    private final static int NB_VIGNETTE_LIGNE = 5;
    private final static int SIZE_ESPACE_H = 25;
    private final static int SIZE_ESPACE_W = 3;
    private final static int SCROLL_SPEED = 20;
        
    public PanelSerieScroll(JPanel filtreBouton){
        this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT - 15));
        this.setBackground(Color.green);
        this.setLayout(new BorderLayout());
        
        JPanel container = new JPanel();
        
        combo = new JComboBox();
        combo.setPreferredSize(new Dimension(145, 20));
        combo.addItem("tri par popularité");
        combo.addItem("tri par date");
        combo.addItem("tri par année");
        
        this.filtreBouton = filtreBouton;
        //this.filtreBouton.setBackground(Color.CYAN);
        // on ajoute le combobox quand on affiche la page
        //(voir code fenetre)
        
        
        // ON RECUPERE LE NOMBRE DEVIGNETTE A AFFICHR EN BASE DE DONNEE
        int nbVignette = 29;
        // ON DIVISE LE NOMBRE PAR 5 (nombre par lignes)
        int  nbLigne = (int) Math.ceil(nbVignette / (float) NB_VIGNETTE_LIGNE); // cast float important  
        // ON MULTIPLIE LE NOMBRE DELIGNE AR LA HAUTEUR D'UNE VIGNETTE
        int height_scroll = (int) (Math.round(nbLigne * Vignette.PANEL_HEIGHT) + (nbLigne * (SIZE_ESPACE_H +8 /* les bords des vignettes */)))+ 100; // 100 = marge
        // ON ADAPTE LA TAILLE DU CONTAINER
        container.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH - 25, height_scroll ) );
        // ON AJOUTE LES VIGNETTES
        for(int i = 0; i< nbVignette; ++i){
            
            if(i%5 == 0){
                JPanel espaceH = new JPanel();
                espaceH.setPreferredSize(new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SIZE_ESPACE_H));
                container.add(espaceH);
            }
            JPanel espaceW = new JPanel();
            espaceW.setPreferredSize(new Dimension(SIZE_ESPACE_W,0));
            container.add(espaceW);
            container.add(new VignetteButton(null, ("Vignette " + (i+1)), true)); //container.add(new Vignette(i+1));
        }
       
        // ON AJOUTE NOTRE PANEL A SCROLL PANEL
        vertical = new JScrollPane();
        vertical.setBorder(new EmptyBorder(0,0,0,0));
        vertical.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
        vertical.setPreferredSize(new Dimension(SeriesManager.MAIN_PANEL_WIDTH, height_scroll));
        vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        vertical.setViewportView(container);   
        this.add(vertical, BorderLayout.CENTER);

    }
    
    public JComboBox getComboBoxTri(){
        return combo;
    }
}