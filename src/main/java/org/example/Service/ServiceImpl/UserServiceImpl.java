package org.example.Service.ServiceImpl;

import org.example.Service.UserService;
import org.example.dao.UserDao;
import org.example.dao.daoImpl.UserDaoImpl;
import org.example.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
  UserDao userDao = new UserDaoImpl();
    @Override
    public void createUsersTable() {
   userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
   userDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
      userDao.saveUser(name,lastName,age);
    }

    @Override
    public void removeUserById(long id) {
   userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
    userDao.cleanUsersTable();
    }
}
