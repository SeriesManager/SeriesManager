/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel avec un Jpanel en haut à gauche et un ensemble de vignette en dessous
 * @author Arles Mathieu
 */
public  class PanelVignette extends JPanel{
 
    private JPanel vignette; //Panel contenant les vignettes
    private final int numLimit; //Nombre limite total de vignette (ligne * colonne)
    private int numEffectif; //Nombre effectif de vignette
    
    
    /**
     * 
     * @param name Texte du JPanel
     * @param ligne nombre de lignes
     * @param colonne nombre de colonnes
     */
    public PanelVignette(String name, int ligne, int colonne ) {
        numLimit = ligne * colonne;
        numEffectif = 0;
        GridLayout gl = new GridLayout(ligne,colonne);
        gl.setHgap(10);
        gl.setVgap(10);
        
        setLayout(new BorderLayout());
        add(new JLabel(name),BorderLayout.NORTH);
        vignette = new JPanel();
        vignette.setLayout(gl);
        
        add(vignette,BorderLayout.CENTER);
        
        
    }
    
    public boolean addVignette(Vignette v) {
        if(numEffectif < numLimit) {
            vignette.add(v);
            numEffectif++;
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(this.numEffectif < this.numLimit)
            return false;
        return true;
    }
}
