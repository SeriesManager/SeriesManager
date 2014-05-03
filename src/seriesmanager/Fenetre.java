/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seriesmanager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
    private JPanel nordOuest;
    
    // les pages de droites qui vont apparaitre et disparaitre dans l'appli
    private JPanel accueil;
    private JPanel mesSeries;
    private JPanel uneDeMesSerie;
    private JPanel profil;
    
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
        
        
        nordOuest = new JPanel();
        JPanel nord = new JPanel(); // Panel contenant 2 autre panel (ouest et recherche)
        nord.setLayout(new GridLayout(1,2));

        
        // ainsi que nos différentes pages qui apparaîtront 
        accueil = new Accueil();
        mesSeries = new PanelSerieScroll(nordOuest);
        recherche = new PanelRecherche();
        uneDeMesSerie = new UneDeMesSeries();
        profil = new Profil();
        
        // et l'autre panel de droite qui va accueillir le reste des pages
        
        nord.add(nordOuest);
        nord.add(recherche);
        page = new JPanel();
        page.add(accueil);
        centre = new JPanel();
        centre.setLayout(new BorderLayout());
        centre.add(nord,BorderLayout.NORTH);
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
                nordOuest.setLayout(new BorderLayout());
                nordOuest.setBorder(new EmptyBorder(5, 13, 0, 0));
                nordOuest.add(((PanelSerieScroll)mesSeries).getComboBoxTri(), BorderLayout.WEST);
                page.add(mesSeries);
               // centre.remove(page);
                //centre.add(page, BorderLayout.CENTER);
                //page.revalidate();
                //page.repaint();
                nordOuest.repaint(); 
                nordOuest.revalidate();
                page.repaint(); // obligé !! :)
                page.revalidate();
                 
            }
        });
        
        menu.getWajdi().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                page.removeAll();
                clearNordOuest();               
                page.add(uneDeMesSerie);
                page.repaint();
                page.revalidate();
            }
        }) ;
        
        
        menu.getAccueil().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                page.removeAll();
                clearNordOuest();
                page.add(accueil);               
                page.repaint();
                page.revalidate(); 
            }
        });
        
        menu.getProfil().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                page.removeAll();
                clearNordOuest();
                page.add(profil);               
                page.repaint();
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
    
    private void clearNordOuest(){
        nordOuest.removeAll();
        nordOuest.repaint();
        nordOuest.revalidate();
    }
    
}
