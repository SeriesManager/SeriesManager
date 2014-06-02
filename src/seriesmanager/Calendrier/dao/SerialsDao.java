package seriesmanager.Calendrier.dao;

import java.util.Date;
import java.util.List;

import seriesmanager.Calendrier.dto.Serial;

public interface SerialsDao {
    public List<Serial> getSerialListForDay(Date date);

    public List<Serial> getSerialListForMonth(Date date);

    public List<Serial> getSerialListForYear(Date date);
}
