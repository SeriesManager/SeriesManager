/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Django
 */
public class Menu extends JPanel{
    
    private static final int PANEL_WIDTH = 210;
    private static final int PANEL_HEIGHT = 530;
    
    private JButton accueil;
    private JButton mesSeries;
    private JButton series;
    private JButton calendrier;
    private JButton profil;
    private JButton wajdi;
    
    public Menu(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.gray);
        this.add(new JLabel("Menu"));
        
        accueil = new JButton("Accueil");
        mesSeries = new JButton("Mes séries");
        series = new JButton("Series");
        calendrier = new JButton("Calendrier");
        profil = new JButton("Profil");
        wajdi = new JButton("Pour le mec des anées 80");
        
        this.add(accueil);
        this.add(mesSeries);
        this.add(series);
        this.add(calendrier);
        this.add(profil);
        this.add(wajdi);
    }
    
    public JButton getMesSeries(){
        return mesSeries;
    }

    public JButton getWajdi() {
        return wajdi;
    }
    
    public JButton getAccueil(){
        return accueil;
    }
    
    public JButton getProfil(){
        return profil;
    }
    
    
}
