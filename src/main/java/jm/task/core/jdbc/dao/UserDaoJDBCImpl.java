package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {




    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection conn = Util.getConnection()) {
            String query = "CREATE TABLE IF NOT EXISTS User (\n" +
                    "    id bigint AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    name varchar(255) NULL,\n" +
                    "    lastName varchar(255) NULL,\n" +
                    "    age tinyint NULL\n" +
                    ");";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Connection conn = Util.getConnection()) {
            try (PreparedStatement statement = conn.prepareStatement("DROP TABLE IF EXISTS User")) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection conn = Util.getConnection()) {
            try (PreparedStatement statement = conn.prepareStatement("INSERT INTO User (name, lastName, age) VALUES (?, ?, ?)")) {
                statement.setString(1, name);
                statement.setString(2, lastName);
                statement.setByte(3, age);
                statement.executeUpdate();
                System.out.printf("User с именем — %s добавлен в базу данных\n", name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void removeUserById(long id) {
        try (Connection conn = Util.getConnection()) {
            try (PreparedStatement statement = conn.prepareStatement("DELETE FROM User WHERE id = ?")) {
                statement.setLong(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        try (Connection conn = Util.getConnection()) {
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM User");
                List<User> userList = new ArrayList<>();

                while (rs.next()) {
                    userList.add(new User(rs.getString("name"), rs.getString("lastName"), rs.getByte("age")));
                }
                return userList;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        try (Connection conn = Util.getConnection()) {
            try (PreparedStatement statement = conn.prepareStatement("DELETE FROM User where id")) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
