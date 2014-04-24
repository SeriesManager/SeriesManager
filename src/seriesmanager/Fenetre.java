/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * @author Arles Mathieu
 */
public class Fenetre extends JFrame{
    
    //container principal
    private final JPanel principal;
    
    // notre menu qui se trouve à gauche
    private Menu menu;
    
    //Panel contenant la page et le champ de recherche
    private final JPanel centre;
    
    // page de droite qui va changer
    private JPanel page;
    
    private final JPanel recherche;
    
    // les pages de droites qui vont apparaitre et disparaitre dans l'appli
    private JPanel accueil;
    private JPanel mesSeries;
    
    //Image de fond
    public Image imgFond;

    // taille de notre fenetre
    private static final int WINDOWS_WIDTH = 930;
    private static final int WINDOWS_HEIGHT = 530;
    
    public Fenetre() {
        setTitle("Gestionnaire de séries");
        setSize(WINDOWS_WIDTH,WINDOWS_HEIGHT);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); //place la fenêtre au centre de l'écran
        this.setResizable(false);
        
        /*
        try {
         imgFond = ImageIO.read(getClass().getResourceAsStream("img/fond.png"));
         }
         catch(IOException e) { }
        
        this.repaint();*/
        
        principal = new JPanel();
        this.setContentPane(principal);
        principal.setLayout(new BorderLayout());
   
        // on instancie le menu
        menu = new Menu();
        
        // ainsi que nos différentes pages qui apparaîtront 
        accueil = new Accueil();
        mesSeries = new PanelSerieScroll();
        recherche = new PanelRecherche();
        // et l'autre panel de droite qui va accueillir le reste des pages
        page = new JPanel();
        page.add(accueil);
        centre = new JPanel();
        centre.setLayout(new BorderLayout());
        centre.add(recherche,BorderLayout.NORTH);
        centre.add(page,BorderLayout.CENTER);
        
        // le placement des panels
        principal.add(menu, BorderLayout.WEST);
        principal.add(centre, BorderLayout.CENTER);
        
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
                page.removeAll();
                page.add(mesSeries);
               // centre.remove(page);
                //centre.add(page, BorderLayout.CENTER);
                //page.revalidate();
                //page.repaint();
                page.revalidate();
                 
            }
        });
        ///////////////////////////////////////////////////////
        
        
        this.setVisible(true);
    }
 /*      public void paint(Graphics g)
   {
           g.drawImage (imgFond, 0, 0, this);
   }*/
       
    public JPanel getPage(){
        return page;
    }
    
    public void setPage(JPanel page){
        this.page = page;
    }
    
}
