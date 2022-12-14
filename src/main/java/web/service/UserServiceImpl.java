package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoJPAImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDaoJPAImpl userDaoJPA;

    public UserServiceImpl(UserDaoJPAImpl userDaoJPA) {
        this.userDaoJPA = userDaoJPA;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDaoJPA.saveUser(user);
    }

    @Override
    @Transactional
    public void removeUser(User userToDelete) {
        userDaoJPA.removeUser(userToDelete);
    }

    @Override
    @Transactional
    public void updateUser(User updatedUser) {
        userDaoJPA.updateUser(updatedUser);
    }

    @Override
    public User findUserById(int id) {
        return userDaoJPA.findUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoJPA.getAllUsers();
    }

    @Override
    @Transactional
    public void cleanUsersTable() {
        userDaoJPA.cleanUsersTable();
    }

}
