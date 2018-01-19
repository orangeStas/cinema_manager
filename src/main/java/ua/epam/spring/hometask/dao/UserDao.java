package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.User;

public interface UserDao extends GenericCrudDao<User, Long> {
    User getByEmail(String email);
}
