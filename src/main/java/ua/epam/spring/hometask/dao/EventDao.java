package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;

import java.util.Date;
import java.util.List;

public interface EventDao extends GenericCrudDao<Event, Long> {
    Event getByName(String name);

    List<Event> getForDateRange(Date start, Date end);

    List<Event> getNextEvents(Date toDate);
}
