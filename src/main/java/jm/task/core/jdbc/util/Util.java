package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:mysql://185.58.207.153:3306/post_project";
    private static final String user = "mysql";
    private static final String password = "0000";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
