/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Panel contenant le champs de recherche
 * @author Arles Mathieu
 */


public class PanelRecherche extends JPanel implements ActionListener{
    
    
    public static final int WIDTH_SEARCH = 10;
    private JTextField recherche;
    private JButton btn;
    
    public PanelRecherche() {
        super();
        recherche = new JTextField(WIDTH_SEARCH);
        recherche.setPreferredSize(new Dimension(140, 30));
        btn = new JButton("ok");
        btn.setPreferredSize(new Dimension(60, 30));
        btn.addActionListener(this);
        JPanel east = new JPanel();
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(5, 0, 0, 14));
        east.add(recherche);
        east.add(btn);
        this.add(east,BorderLayout.EAST);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tmp = "";
        Object source = e.getSource();

        if (source == btn) {
            tmp = recherche.getText();
            System.out.println(tmp);
        }
    }
   
    
}
