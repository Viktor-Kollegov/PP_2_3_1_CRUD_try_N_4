package web.dao;

import web.model.User;

import java.sql.SQLException;
import java.util.List;

//Можно так
//public interface UserDao extends JpaRepository<User, Long>{
// Пустое тело, все методы уже есть в родителе, даже переопределять ненадо
//}

public interface UserDao {
    void createUsersTable() throws SQLException;

    void dropUsersTable() throws SQLException;

    void saveUser(User user) throws SQLException;

    void removeUserById(int id) throws SQLException;

    void updateUserById(int id, User updatedUser);

    User show(int id);

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException;


}
