package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
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
