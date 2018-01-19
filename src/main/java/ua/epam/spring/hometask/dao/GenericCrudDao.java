package ua.epam.spring.hometask.dao;

import java.util.List;

public interface GenericCrudDao<O, K> {
    O create(O o);

    O read(K k);

    O update(O o);

    void delete(K k);

    List<O> getAll();
}
