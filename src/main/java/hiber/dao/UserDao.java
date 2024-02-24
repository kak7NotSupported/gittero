package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   List<User> getUsersWithCars();

   User getUserByCarData(String model, int serial);
}
