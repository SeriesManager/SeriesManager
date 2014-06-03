/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesmanager;

import database.SerieManager;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;
import objets.Serie;

/**
 * Gestionnaire pour la souris de la fenetre du menu principal
 *
 * @author Thomas Hennequin-Parey
 **/
class MenuListener implements MouseListener, MouseMotionListener
{
   /**
    * Menu principal.
    */
   public Menu m;

   /**
    * Constructeur du gestionnaire de la souris.
    * @param m
    *       Menu principal.
    */
   public MenuListener (Menu m)
   {
      this.m = m;
   }

   /**
    * Methode appelé lors d'un click de la souris. Si le clic est sur l'un
    * des choux du menu : execute l'action associé.
    * @param ev
    *       Evenemende la souris t lié au clic.
    */
   public void mouseClicked (MouseEvent ev)
   {
      //récupération de la position de la souris
      final Point p = ev.getPoint();

      /* Affiche la page d'accueil */
      if(m.zoneAccueil.contains(p)){
           
          System.out.println("ActionAccueil");
          m.f.page.removeAll();
          m.f.clearNordOuest();
          // mise à jour si il y a eu des clics + et -
          try {
              m.f.accueil = new Accueil();
          } catch (IOException ex) {
              Logger.getLogger(MenuListener.class.getName()).log(Level.SEVERE, null, ex);
          }
          m.f.page.add(m.f.accueil);               
          m.f.page.repaint();
          m.f.page.revalidate(); 
      }
      else if (m.zoneAllSeries.contains(p)) {/* affiche l'objet page toutes les series */
           
          System.out.println("ActionToutesSeries");
                
          m.f.page.removeAll();
          m.f.nordOuest.setLayout(new BorderLayout());
          m.f.nordOuest.setBorder(new EmptyBorder(5, 13, 0, 0));
          // mise à jour si il y a eu des clics + et -
          List<Serie> les_series = SerieManager.getAllSerie();
          try {
              m.f.lesSeries = new PanelSerieScroll(m.f.nordOuest, les_series);
          } catch (IOException ex) {
              Logger.getLogger(MenuListener.class.getName()).log(Level.SEVERE, null, ex);
          }
          m.f.nordOuest.add(((PanelSerieScroll)m.f.lesSeries).getComboBoxTri(), BorderLayout.WEST);
          m.f.page.add(m.f.lesSeries);
          m.f.nordOuest.repaint(); 
          m.f.nordOuest.revalidate();
          m.f.page.repaint();
          m.f.page.revalidate();
      }
      else if (m.zoneMySeries.contains(p)) { /* Affiche l'objet page mes series */
           
          System.out.println("ActionMesSeries");
          
          m.f.page.removeAll();
          m.f.nordOuest.setLayout(new BorderLayout());
          m.f.nordOuest.setBorder(new EmptyBorder(5, 13, 0, 0));
          // mise à jour si il y a eu des clics + et -
          List<Serie> mes_series = SerieManager.getAllSerieVues();
          try {
              m.f.mesSeries = new PanelSerieScroll(m.f.nordOuest, mes_series);
          } catch (IOException ex) {
              Logger.getLogger(MenuListener.class.getName()).log(Level.SEVERE, null, ex);
          }
          m.f.nordOuest.add(((PanelSerieScroll)m.f.mesSeries).getComboBoxTri(), BorderLayout.WEST);
          m.f.page.add(m.f.mesSeries);
          m.f.nordOuest.repaint(); 
          m.f.nordOuest.revalidate();
          m.f.page.repaint();
          m.f.page.revalidate();
      }
      else if (m.zoneProfil.contains(p)) {/* fiche la page profil */
          
          System.out.println("ActionProfil");
          m.f.page.removeAll();
          m.f.clearNordOuest();
          m.f.page.add(m.f.profil);               
          m.f.page.repaint();
          m.f.page.revalidate(); 
      }
      else if (m.zoneCalendrier.contains(p)) {// Affiche la page calendrier
          
          System.out.println("ActionCalendrier");
          m.f.page.removeAll();
          m.f.page.add(m.f.calendrier);             
          m.f.page.repaint();
          m.f.page.revalidate();
      }
   }

   /**
    * Methode appelé lors d'un mouvement de la souris. Si la souris
    * est sur un des choix du menu : affiche un effet.
    * @param ev
    *       Evenement de la souris lié au mouvement.
    */
   public void mouseMoved (MouseEvent ev)
   {
      //récupération de la position de la souris
      final Point p = ev.getPoint();

      if(m.zoneAccueil.contains(p))
         m.afficheEffet(1);
      else if (m.zoneAllSeries.contains(p))
         m.afficheEffet(2);
      else if (m.zoneMySeries.contains(p))
         m.afficheEffet(3);
      else if (m.zoneCalendrier.contains(p))
         m.afficheEffet(4);
      else if (m.zoneProfil.contains(p))
          m.afficheEffet(5);
      else
         m.afficheEffet(0);
      m.repaint();
   }

   public void mouseEntered(MouseEvent ev) {}
   public void mouseDragged(MouseEvent ev) {}
   public void mousePressed(MouseEvent ev) {}
   public void mouseReleased(MouseEvent e) {}
   public void mouseExited(MouseEvent ev) {}
}
