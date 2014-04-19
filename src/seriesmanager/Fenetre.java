/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * @author Arles Mathieu
 */
public class Fenetre extends JFrame{
    
    //container principal
    private JPanel principal;
    
    // notre menu qui se trouve à gauche
    private Menu menu;
    
    // page de droite qui va changer
    private JPanel page;
    
    // les pages de droites qui vont apparaitre et disparaitre dans l'appli
    private JPanel accueil;
    private JPanel mesSeries;
   
    // taille de notre fenetre
    private static final int WINDOWS_WIDTH = 930;
    private static final int WINDOWS_HEIGHT = 530;
    
    public Fenetre() {
        setTitle("Gestionnaire de séries");
        setSize(WINDOWS_WIDTH,WINDOWS_HEIGHT);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); //place la fenêtre au centre de l'écran
        this.setResizable(false);
        
        principal = new JPanel();
        this.setContentPane(principal);
        principal.setLayout(new BorderLayout());
   
        // on instancie le menu
        menu = new Menu();
        
        // ainsi que nos différentes pages qui apparaîtront 
        accueil = new Accueil();
        mesSeries = new MesSeries();
        
        // et l'autre panel de droite qui va accueillir le reste des pages
        page = accueil;
        

        
        // le placement des panels
        principal.add(menu, BorderLayout.WEST);
        principal.add(page, BorderLayout.CENTER);
        
        /////////// POUR LES TESTS (DJANGO) /////////////
        // au clic sur le bouton mes series
        menu.getMesSeries().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
             
                // TEST BOITE DE DIALOGUE
//                JOptionPane jop1;
//                jop1 = new JOptionPane();
//                jop1.showMessageDialog(null, "Message informatif", "Information", JOptionPane.INFORMATION_MESSAGE);

                page = mesSeries;
                principal.add(page, BorderLayout.CENTER);
                page.revalidate();
                page.repaint();
            }
        });
        ///////////////////////////////////////////////////////
        
        
        this.setVisible(true);
    }
    
    public JPanel getPage(){
        return page;
    }
    
    public void setPage(JPanel page){
        this.page = page;
    }
    
}
