package org.example.dao.daoImpl;

import org.example.Config.Config;
import org.example.dao.UserDao;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void createUsersTable() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = Config.getSession().openSession();
            transaction = session.beginTransaction();
            transaction.commit();
            System.out.println("Successfully created the users table");
            }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void dropUsersTable() {
   Session session = Config.getSession().openSession();
    session.beginTransaction();
    session.createNativeQuery("drop table users").executeUpdate();
    session.getTransaction().commit();
    session.close();
        System.out.println("Table is successfully dropped! ");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = Config.getSession().openSession();
            transaction = session.beginTransaction();
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            transaction.commit();
            System.out.println(name + " user is saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
     Session session = Config.getSession().openSession();
      session.beginTransaction();
      User user = session.get(User.class,id);
      session.remove(user);
      session.getTransaction().commit();
      session.close();
        System.out.println(" is successfully deleted!");
    }

    @Override
    public List<User> getAllUsers() {
   Session session = Config.getSession().openSession();
   session.beginTransaction();
    List<User> users = session.createQuery("select s from User s").getResultList();
    session.getTransaction().commit();
    session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
     Session session = Config.getSession().openSession();
     session.beginTransaction();
     session.createQuery("delete from User ").executeUpdate();
     session.getTransaction().commit();
     session.close();
        System.out.println("Table is successfully cleaned! ");
    }
}
