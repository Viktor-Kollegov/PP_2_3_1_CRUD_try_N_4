package web.service;

import web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(User user);

    void removeUserById(int id);

    void updateUserById(int id, User updatedUser);

    User show(int id);

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException;

}
