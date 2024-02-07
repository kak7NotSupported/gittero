package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao service = new UserDaoJDBCImpl();

    public void createUsersTable() {
        service.createUsersTable();
    }

    public void dropUsersTable() {
        service.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        service.saveUser(name, lastName, age);
        System.out.printf("User с именем — %s добавлен в базу данных\n", name);
    }

    public void removeUserById(long id) {
        service.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    public void cleanUsersTable() {
        service.cleanUsersTable();
    }
}
