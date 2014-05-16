/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objets;

import java.util.Date;

/**
 *
 * @author Arles Mathieu
 */
public class Saison {
    
    private int id;
    private Date date_sortie;
    private String synopsis;
    private String name;
    private int id_serie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getId_serie() {
        return id_serie;
    }

    public void setId_serie(int id_serie) {
        this.id_serie = id_serie;
    }
    
    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
