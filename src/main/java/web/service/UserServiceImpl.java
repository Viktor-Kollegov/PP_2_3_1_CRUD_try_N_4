package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoJPAImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserDaoJPAImpl userDaoJPA;

    public UserServiceImpl(UserDaoJPAImpl userDaoJPA) {
        this.userDaoJPA = userDaoJPA;
    }

    @Transactional
    public void createUsersTable() {
        userDaoJPA.createUsersTable();
    }
    @Transactional
    public void dropUsersTable() {
        userDaoJPA.dropUsersTable();
    }
    @Transactional
    public void saveUser(User user) {
        userDaoJPA.saveUser(user);
    }
    @Transactional
    public void removeUserById(int id) {
        userDaoJPA.removeUserById(id);
    }

    @Override
    @Transactional
    public void updateUserById(int id, User updatedUser) {
        userDaoJPA.updateUserById(id, updatedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        return userDaoJPA.show(id);
    }
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDaoJPA.getAllUsers();
    }
    @Transactional
    public void cleanUsersTable() {
        userDaoJPA.cleanUsersTable();
    }

}
