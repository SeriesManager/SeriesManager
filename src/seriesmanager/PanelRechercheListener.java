/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import database.SerieManager;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
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
 *
 * @author HENNEQUIN--PAREY Thomas
 */
public class PanelRechercheListener {
    
    private final PanelRecherche panelrecherche;
    
    public PanelRechercheListener(PanelRecherche sup)
    {
        panelrecherche = sup;
    }
    
    public void actionPerformed(ActionEvent e){

        String tmp = "";
	Object source = e.getSource();

	if (source == panelrecherche.btn)
            
                tmp = panelrecherche.recherche.getText();
		System.out.println(tmp);
    }

   public void mouseEntered(MouseEvent ev) {}
   public void mouseDragged(MouseEvent ev) {}
   public void mousePressed(MouseEvent ev) {}
   public void mouseReleased(MouseEvent e) {}
   public void mouseExited(MouseEvent ev) {}
}
