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
public class Episode {

    private int id;
    private String name;
    private String synopsis;
    private Date date_sortie;
    private float duree;
    private int saison_id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }

    public float getDuree() {
        return duree;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public int getSaison_id() {
        return saison_id;
    }

    public void setSaison_id(int saison_id) {
        this.saison_id = saison_id;
    }
}
