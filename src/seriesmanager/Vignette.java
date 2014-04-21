/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Django
 */
public class Vignette extends JPanel{
    
    private static final int PANEL_WIDTH = 125;
    private static final int PANEL_HEIGHT = 185;
    
    private String imagePath;
    private JLabel nomSerie;
    protected JPanel south;
    
    public Vignette(String imagePath, String nom){
        this.imagePath = imagePath;
        
        this.setPreferredSize( new Dimension(PANEL_WIDTH, PANEL_HEIGHT) );
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        this.setLayout(new BorderLayout());
        
        south = new JPanel();
        south.setLayout(new BorderLayout());
        south.setOpaque(false);
        
        nomSerie = new JLabel(nom);
        nomSerie.setOpaque(false);
        nomSerie.setHorizontalAlignment(SwingConstants.CENTER);
        
        //à retirer quand on aura les images
        setBackground(Color.red);
        south.add(nomSerie);
        
        this.add(south, BorderLayout.SOUTH);
        
    }
    
    //POUR LES TESTS
   public Vignette(int numero){
        this.setPreferredSize( new Dimension(PANEL_WIDTH, PANEL_HEIGHT) );
        this.setBackground(Color.gray);
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        this.add(new JLabel("Vignette " + numero));
    }
   
  /* à rajouter quand on aura des images
   @Override
   public void paintComponent(Graphics g) {
        try {
            Image img = ImageIO.read(new File(imagePath));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
   }
   */
}
