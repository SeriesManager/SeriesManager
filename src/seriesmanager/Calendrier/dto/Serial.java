package seriesmanager.Calendrier.dto;

import java.util.Date;

/**
 * @brief dto to describe a serie my purpose is to make a mock for calendar not
 *        a real application POJO
 * */
public class Serial {
    private long id;
    private String title;
    private String status;
    private String country;
    private String synopsis;
    private String imgSrc;
    private Date date; 
    private int numEpisode; // de même List<Serie>::numero
    private int numSaison; // List<Serie>::saison avec en plus possibilité d'une
	                   // table saiso

    public Serial(String director, String title, String actors, String status, String country, String genre, String synopsis, String imgSrc,
	    Date date, int nbSeries, int nbSeasons) {
	super();
	this.title = title;
	this.status = status;
	this.country = country;
	this.synopsis = synopsis;
	this.imgSrc = imgSrc;
	this.date = date;

    }

    public Serial(String director, String title, String genre, Date date, int numEpisode, int numSaison) {
	super();
	this.title = title;
	this.date = date;
	this.numEpisode = numEpisode; 
	this.numSaison = numSaison;
    }

    // List<Serie>
    // List<>
    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public String getSynopsis() {
	return synopsis;
    }

    public Serial setSynopsis(String synopsis) {
	this.synopsis = synopsis;
	return this;
    }

    public String getImgSrc() {
	return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
	this.imgSrc = imgSrc;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public int getNumEpisode() {
	return numEpisode;
    }

    public void setNumEpisode(int numEpisode) {
	this.numEpisode = numEpisode;
    }

    public int getNumSaison() {
	return numSaison;
    }

    public void setNumSaison(int numSaison) {
	this.numSaison = numSaison;
    }

    public String toDisplay() {
	StringBuilder sb = new StringBuilder();
	sb.append("<html>");
	sb.append("<strong>Title</strong>:").append(this.title);
	sb.append("<br/>");
	sb.append("<strong>Saison</strong>:").append(numSaison).append(" <strong>Serie</strong>:").append(numEpisode);
	sb.append("<br/>");
	sb.append("<hr/>");
	sb.append("<br/>");
	if (synopsis != null) {
	    sb.append("Résumé").append("<br/>");

		sb.append(synopsis);
	    

	}
	sb.append("</html>");
	return sb.toString();
    }
}
