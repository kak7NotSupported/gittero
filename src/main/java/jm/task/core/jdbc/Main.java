package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userDao = new UserServiceImpl();
        userDao.createUsersTable();
        userDao.saveUser("Ab", "Cd", (byte) 30);
        userDao.saveUser("Ef", "Gh", (byte) 32);
        userDao.saveUser("Eqe", "Xax", (byte) 2);
        userDao.saveUser("Aasda", "Cdasdf", (byte) 20);

        userDao.getAllUsers().forEach(System.out::println);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
