/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 * Vignette avec un bouton pour ajouter/retirer une série/saison
 * @author Arles Mathieu
 */
public class VignetteButton extends Vignette {

    private boolean signe; // true = +, false = -
    private String imgPath;

    public VignetteButton(String imagePath, String nom, boolean signe) {
        super(imagePath, nom);
        this.signe = signe;
        this.imgPath = imagePath;
        JButton bouton;
        
        if(signe)
            bouton = new JButton("+");
        else
            bouton = new JButton("-");
        
        bouton.setPreferredSize(new Dimension(20,20));

        super.south.add(bouton,BorderLayout.EAST);  
    }
}
