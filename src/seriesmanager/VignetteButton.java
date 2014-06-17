/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import database.SerieManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import objets.Serie;

/**
 * Vignette avec un bouton pour ajouter/retirer une série/saison
 * @author Arles Mathieu
 */
public class VignetteButton extends Vignette {

    private boolean signe; // true = +, false = -
    private String imgPath;
    private BufferedImage image;
    private JButton bouton;
    public VignetteButton(Serie serie, boolean signe) {
        super(serie);
        this.signe = signe;
        if(serie.getImg() == null)
            this.imgPath = "";
        else
            this.imgPath = serie.getImg();
        System.out.println(this.imgPath);
        try {
            image = ImageIO.read(new File(imgPath));
        } catch (IOException ex) {
            try {
                image = ImageIO.read(new File("default.png"));
            } catch (IOException ex1) {
                Logger.getLogger(VignetteButton.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        if(signe) 
            bouton = new JButton("-"); // true = - car on l'a deja
        else
            bouton = new JButton("+"); // false = + car on peut l'ajouter
        
        bouton.setMargin(new Insets(1,1,1,1));  
        bouton.setPreferredSize(new Dimension(20,20));
        bouton.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ICI : " + VignetteButton.this.signe);
                VignetteButton.this.signe = !VignetteButton.this.signe;// on inverse (si vu => pas vu, si pas vu => vu)              
                SerieManager.setSerieVue(VignetteButton.this.nomSerie.getText(), VignetteButton.this.signe);
                if(VignetteButton.this.signe) 
                    bouton.setText("-"); // true = - car on l'a deja
                else
                    bouton.setText("+"); // false = + car on peut l'ajouter
                System.out.println("LA : " + VignetteButton.this.signe);
                bouton.revalidate();
                bouton.repaint();
            }
        });
        super.south.add(bouton,BorderLayout.EAST);  
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); 
    }
    
    public boolean isSigne() {
        return signe;
    }

    public void setSigne(boolean signe) {
        this.signe = signe;
    }
    
    
}
