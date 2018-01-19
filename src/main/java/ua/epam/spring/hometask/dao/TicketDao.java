package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Ticket;

import java.time.LocalDateTime;
import java.util.Set;

public interface TicketDao extends GenericCrudDao<Ticket, Long> {
    Set<Ticket> findTicketsByEventAndDate(long eventId, LocalDateTime dateTime);
}
