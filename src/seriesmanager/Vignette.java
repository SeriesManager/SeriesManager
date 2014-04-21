/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Django
 */
public class Vignette extends JPanel{
    
    public static final int PANEL_WIDTH = 125;
    public static final int PANEL_HEIGHT = 185;
    
    public Vignette(){
        this.setPreferredSize( new Dimension(PANEL_WIDTH, PANEL_HEIGHT) );
        this.setBackground(Color.gray);
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
    }
    
    //POUR LES TESTS
   public Vignette(int numero){
        this.setPreferredSize( new Dimension(PANEL_WIDTH, PANEL_HEIGHT) );
        this.setBackground(Color.gray);
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        this.add(new JLabel("Vignette " + numero));
    }
}
