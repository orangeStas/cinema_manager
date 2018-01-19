package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.TicketDao;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.service.TicketService;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public class TicketServiceImpl implements TicketService {

    private TicketDao ticketDao;

    @Override
    public Ticket save(@Nonnull Ticket object) {
        return ticketDao.create(object);
    }

    @Override
    public void remove(@Nonnull Ticket object) {
        ticketDao.delete(object.getId());
    }

    @Override
    public Ticket getById(@Nonnull Long id) {
        return ticketDao.read(id);
    }

    @Nonnull
    @Override
    public Collection<Ticket> getAll() {
        return ticketDao.getAll();
    }

    @Override
    public Set<Ticket> findTicketsByEventAndDate(Event event, LocalDateTime date) {
        return ticketDao.findTicketsByEventAndDate(event.getId(), date);
    }
}
