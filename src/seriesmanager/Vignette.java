/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import objets.Serie;

/**
 *
 * @author Django
 */
public class Vignette extends JPanel implements MouseListener{
    
    public static final int PANEL_WIDTH = 125;
    public static final int PANEL_HEIGHT = 185;
    
    protected JLabel nomSerie;
    protected JPanel south;
    protected Serie serie;
    
    public Vignette(Serie serie){
        this.serie = serie;
        
        this.setPreferredSize( new Dimension(PANEL_WIDTH, PANEL_HEIGHT) );
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        this.setLayout(new BorderLayout());
        
        south = new JPanel();
        south.setLayout(new BorderLayout());
        south.setOpaque(false);
        
        nomSerie = new JLabel(serie.getName());
        nomSerie.setOpaque(false);
        nomSerie.setForeground(Color.white);
        nomSerie.setFont(new Font("Sans Serif", Font.BOLD, 13));
        nomSerie.setHorizontalAlignment(SwingConstants.CENTER);
        
        //à retirer quand on aura les images
        //setBackground(Color.red);
        south.add(nomSerie);
        
        this.add(south, BorderLayout.SOUTH);
        
        this.addMouseListener(this);
        
    }
    
//    //POUR LES TESTS
//   public Vignette(int numero){
//        this.setPreferredSize( new Dimension(PANEL_WIDTH, PANEL_HEIGHT) );
//        this.setBackground(Color.gray);
//        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
//        this.add(new JLabel("Vignette " + numero));
//    }
   
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

    @Override
    public void mouseClicked(MouseEvent e) {
        Vignette v =(Vignette) e.getSource();
        Fenetre fen = (Fenetre)v.getTopLevelAncestor();
        
        JPanel p = fen.getPage();
        
        p.removeAll();
        try {
            p.add(new UneDeMesSeries(this.serie));
        } catch (SQLException ex) {
            Logger.getLogger(Vignette.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.revalidate();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseClicked(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ;
    }
}
