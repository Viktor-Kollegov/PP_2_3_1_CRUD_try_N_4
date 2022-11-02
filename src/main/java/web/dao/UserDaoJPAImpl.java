package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoJPAImpl implements UserDao {
    @PersistenceContext // без данной аннотации энтити менеджер подтянется один раз, но после исчезнет
    private final EntityManager entityManager;

    public UserDaoJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(User userToDelete) {
        entityManager.remove(entityManager.contains(userToDelete)
                ? userToDelete : entityManager.merge(userToDelete));
    }

    @Override
    public void updateUser(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public User findUserById(int id) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT user FROM User user", User.class); //JPQL
        // Обязателен ли TypedQuery<User>??
        return query.getResultList();
    }

    @Override
    public void cleanUsersTable() {
        entityManager.createNativeQuery("DELETE FROM users").executeUpdate();
    }
}
