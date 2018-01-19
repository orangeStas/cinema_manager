package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.EventDao;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class EventServiceImpl implements EventService {

    private EventDao eventDao;

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return eventDao.getByName(name);
    }

    @Override
    public Event save(@Nonnull Event object) {
        return eventDao.create(object);
    }

    @Override
    public void remove(@Nonnull Event object) {
        eventDao.delete(object.getId());
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return eventDao.read(id);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return eventDao.getAll();
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
}
