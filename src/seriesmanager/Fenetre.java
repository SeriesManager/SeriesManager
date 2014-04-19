/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import javax.swing.*;

/**
 * 
 * @author Arles Mathieu
 */
public class Fenetre extends JFrame{
    
    private JPanel principal; //container principal
    private JPanel menu; // panel à placer sur la gauche
    private JPanel page; // panel pour les différentes pages
    
    public Fenetre() {
        setTitle("Gestionnaire de séries");
        setSize(930,530);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); //place la fenêtre au centre de l'écran
        
        principal = new JPanel();
        this.setContentPane(principal);
        
        
        menu = new JPanel();
        
        
        
        page = new Accueil();
    }
    
}
