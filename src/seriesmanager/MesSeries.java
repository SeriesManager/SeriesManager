/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Django
 */
public class MesSeries extends JPanel{
    
    public MesSeries(){
        this.setPreferredSize( new Dimension(SeriesManager.MAIN_PANEL_WIDTH, SeriesManager.MAIN_PANEL_HEIGHT) );
        this.setBackground(Color.green);
        
        this.setLayout(new GridLayout(3,5));
        
        for(int i = 0; i<10; ++i){
            this.add(new Vignette(null,"Test" + i));
        }
    }
}
