package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Ab", "Cd", (byte) 30);
        service.saveUser("Ef", "Gh", (byte) 32);
        service.saveUser("Eqe", "Xax", (byte) 2);
        service.saveUser("Aasda", "Cdasdf", (byte) 20);

        service.getAllUsers().forEach(System.out::println);
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
