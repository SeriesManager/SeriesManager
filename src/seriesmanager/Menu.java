/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hennequin--Parey Thomas
 */
public class Menu extends JPanel{
    
    private static final int PANEL_WIDTH = 210;
    private static final int PANEL_HEIGHT = 530;

   /**
    * Titre de la fenetre du menu principal.
    */
   public final static String TITLE = "My Series manager \u00A9";
   /* Zones */
 
   /**
    * Délimite le zone qui permet d'afficher l'Accueil.
    */
   public Rectangle zoneAccueil;
   /**
    * Délimite le zone qui permet d'afficher toutes les séries.
    */
   public Rectangle zoneAllSeries;
   /**
    * Délimite le zone qui permet d'afficher les séries de l'utilisateur.
    */
   public Rectangle zoneMySeries;
   /**
    * Délimite le zone qui permet d'afficher le profil.
    */
   public Rectangle zoneProfil;
   /**
    * Délimite le zone qui permet d'afficher le calendrier.
    */
   public Rectangle zoneCalendrier;

   /* Images */
   /**
    * Image de fond du menu principal.
    */
   public Image fond;
   /**
    * Images destinées aux options du menu et aux effets du menu lorsque survolé par la souris.
    */ 
   public Image imgAccueil;
   public Image imgAllSeries;
   public Image imgMySeries;
   public Image imgCalendrier;
   public Image imgProfil;
   public Image imgAccueilEffet;
   public Image imgAllSeriesEffet;
   public Image imgMySeriesEffet;
   public Image imgCalendrierEffet;
   public Image imgProfilEffet;
   
   /**
    * Option du menu principal survolée par la souris.
    */
   public int opt;

   Fenetre f;
    
    public Menu(Fenetre frame){
        
        this.f=frame;
        
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

      this.setBackground(Color.WHITE);
      this.setLayout(null);


      /* Listeners */
      MenuListener ml = new MenuListener(this);
      this.addMouseListener(ml);
      this.addMouseMotionListener(ml);

      /* Charge Menu principal */
      showMenu();
    }
    
    /**
    * Initialise les zones cliquable pour le Menu principal.
    */
   public void initRectMenu()
   {
      zoneAccueil   = new Rectangle((int) 5, (int) 0, (int) 200, (int) 100);
      zoneAllSeries   = new Rectangle((int) 5, (int) 110, (int) 200, (int) 100);
      zoneMySeries  = new Rectangle((int) 5, (int) 210, (int) 200, (int) 100);
      zoneCalendrier = new Rectangle((int) 5, (int) 310, (int) 200, (int) 100);
      zoneProfil = new Rectangle((int) 5, (int) 410, (int) 200, (int) 100);
   }

   /**
    * Initialise à 0 toutes les zones cliquables.
    */
   public void setZeroRect()
   {
      zoneCalendrier = new Rectangle((int) 0, (int) 0, (int) 0, (int) 0);
      zoneAccueil   = new Rectangle((int) 0, (int) 0, (int) 0, (int) 0);
      zoneAllSeries    = new Rectangle((int) 0, (int) 0, (int) 0, (int) 0);
      zoneMySeries      = new Rectangle((int) 0, (int) 0, (int) 0, (int) 0);
      zoneProfil     = new Rectangle((int) 0, (int) 0, (int) 0, (int) 0);
   }

   /**
    * Affiche le menu principal. Ou le menu Regle en fonction du fond
    * chargé.
    * @param g
    *       Contexte graphique.
    */
   public void paint(Graphics g)
   {
      /* Affiche les différentes images */
      
      g.drawImage (imgAccueil, 0, 0, this);
      g.drawImage (imgAllSeries, 0, 101, this);
      g.drawImage (imgMySeries, 0, 202, this);
      g.drawImage (imgCalendrier, 0, 303, this);
      g.drawImage (imgProfil, 0, 404, this);

      
      /* Affiche une effetImage sur la zone survolé par la souris */
      if (opt == 1)
         g.drawImage(imgAccueilEffet, 0, 0, this);
      else if (opt == 2)
         g.drawImage(imgAllSeriesEffet, 0, 101, this);
      else if (opt == 3) 
         g.drawImage(imgMySeriesEffet, 0, 202, this);
      else if (opt == 4)
         g.drawImage(imgCalendrierEffet, 0, 303, this);
      else if (opt == 5)
         g.drawImage(imgProfilEffet, 0, 404, this);
   }

   /**
    * Charger l'image de fond du menu principal.
    */
   public void charger_imgMenu()
   {
      try {
         imgAccueil = ImageIO.read(getClass().getResourceAsStream("img/imgAccueil"));
         imgAllSeries = ImageIO.read(getClass().getResourceAsStream("img/imgAllSeries"));
         imgMySeries = ImageIO.read(getClass().getResourceAsStream("img/imgMySeries"));
         imgCalendrier = ImageIO.read(getClass().getResourceAsStream("img/imgCalendrier"));
         imgProfil = ImageIO.read(getClass().getResourceAsStream("img/imgProfil"));
         
         imgAccueilEffet = ImageIO.read(getClass().getResourceAsStream("img/imgAccueilEffet"));
         imgAllSeriesEffet = ImageIO.read(getClass().getResourceAsStream("img/imgAllSeriesEffet"));
         imgMySeriesEffet = ImageIO.read(getClass().getResourceAsStream("img/imgMySeriesEffet"));
         imgCalendrierEffet = ImageIO.read(getClass().getResourceAsStream("img/imgCalendrierEffet"));
         imgProfilEffet = ImageIO.read(getClass().getResourceAsStream("img/imgProfilEffet"));
      }
      catch(IOException e) { }
   }

   /**
    * Methode utilisé pour modifier la position de la effetOverZone
    * affiché au survol de la souris.
    * @param nb
    *       N° de l'option survolé.
    */
   public void afficheEffet(int nb)
   {
      opt = nb;
   }

   /**
    * Affiche le menu principal. Initialise les zones et charge l'image de fond.
    */
   public void showMenu ()
   {
      setZeroRect();
      initRectMenu();
      charger_imgMenu();
      afficheEffet(0);
      repaint();
   }
}
