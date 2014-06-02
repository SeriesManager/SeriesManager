package seriesmanager.Calendrier.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import seriesmanager.Calendrier.dao.SerialsDao;
import seriesmanager.Calendrier.dao.impl.SerialsDaoMock;
import seriesmanager.Calendrier.dto.Serial;

public class CalendrierService {

    private SerialsDao dao;

    public CalendrierService() {
	try {
	    dao = new SerialsDaoMock();
	} catch (ParseException e) {
	    System.out.println("parse problems :'(");
	    System.exit(1);// Never do this..
	}
    }

    /**
     * @brief il n'est pas necessaire de passer par un service sans traitements
     *        une habitude
     * */
    public List<Serial> getSerialListForDay(Date date) {
	return dao.getSerialListForDay(date);
    }

    public List<Serial> getSerialListForMonth(Date date) {
	return dao.getSerialListForMonth(date);
    }

    public List<Serial> getSerialListForYear(Date date) {
	return dao.getSerialListForYear(date);
    }
}
