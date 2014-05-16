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
public class Serie {
    
    private int id;
    private String name;
    private String realisateur;
    private String acteurs;
    private String pays;
    private String genre;
    private String Statut;
    private boolean vue;
    private String commentaire;
    private float note;
    private Date annee;
    private String img;

    @Override
    public String toString(){
        return "id : " + this.id + "\n"
                + "name : " + this.name + "\n"
                + "realisateur : " + this.realisateur + "\n"
                + "acteurs : " + this.acteurs + "\n"
                + "pays : " + this.pays + "\n"
                + "genre : " + this.genre + "\n"
                + "Statut : " + this.Statut + "\n"
                + "vue : " + this.vue + "\n"
                + "commentaire : " + this.commentaire + "\n"
                + "note : " + this.note + "\n"
                + "annee : " + this.annee + "\n"
                + "img : " + this.img + "\n";        
    }
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

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getActeurs() {
        return acteurs;
    }

    public void setActeurs(String acteurs) {
        this.acteurs = acteurs;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String Statut) {
        this.Statut = Statut;
    }

    public boolean isVue() {
        return vue;
    }

    public void setVue(boolean vue) {
        this.vue = vue;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
