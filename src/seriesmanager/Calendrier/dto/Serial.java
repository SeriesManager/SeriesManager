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
    private Date date;  //have to adapte to the date base, should be TimeStamp !
    private String numEpisode;  //have to adapte to the date base, should be INT !
    private String numSaison;  //have to adapte to the date base, should be INT !


    public Serial(String director, String title, String genre, Date date, String numEpisode, String numSaison) {
	super();
	this.title = title;
	this.date = date;
	this.numEpisode = numEpisode; 
	this.numSaison = numSaison;
    }

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

    public String getNumEpisode() {
	return numEpisode;
    }

    public void setNumEpisode(String numEpisode) {
	this.numEpisode = numEpisode;
    }

    public String getNumSaison() {
	return numSaison;
    }

    public void setNumSaison(String numSaison) {
	this.numSaison = numSaison;
    }
    /**
     * @brief method for html able elements, should not be used as toString : console doesn't understand HTML tags
     * */
    public String toDisplay() {
	StringBuilder sb = new StringBuilder();
	sb.append("<html>");
	sb.append("<strong>Title</strong>:").append(this.title);
	sb.append("<br/>");
	sb.append(numSaison).append("  ").append(numEpisode);
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
