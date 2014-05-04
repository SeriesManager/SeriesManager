/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import javax.swing.JFrame;

/**
 *
 * @author Arles Mathieu
 */
public class SeriesManager {

    public static final int MAIN_PANEL_WIDTH = 720;
    public static final int MAIN_PANEL_HEIGHT = 470; // 530;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame f = new Fenetre();
        f.setVisible(true);
    }   
}
