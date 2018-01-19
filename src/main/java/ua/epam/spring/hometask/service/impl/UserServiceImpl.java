package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public User save(@Nonnull User object) {
        return userDao.create(object);
    }

    @Override
    public void remove(@Nonnull User object) {
        userDao.delete(object.getId());
    }

    @Override
    public User getById(@Nonnull Long id) {
        return userDao.read(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userDao.getAll();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
