package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;

import java.time.LocalDateTime;
import java.util.Set;

public interface TicketService extends AbstractDomainObjectService<Ticket> {
    Set<Ticket> findTicketsByEventAndDate(Event event, LocalDateTime date);
}
