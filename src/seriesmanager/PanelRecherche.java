/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel contenant le champs de recherche
 * @author Arles Mathieu
 */


public class PanelRecherche extends JPanel{
    
    
    public static final int WIDTH = 10;
    private JTextField recherche;

    
    
    public PanelRecherche() {
        super();
        recherche = new JTextField(WIDTH);
        JButton btn = new JButton("ok");
        JPanel east = new JPanel();
        
        this.setLayout(new BorderLayout());
        east.add(recherche);
        east.add(btn);
        
        this.add(east,BorderLayout.EAST);
        
    }

    
    
    
    
}
