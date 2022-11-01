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
    public void createUsersTable() {
        entityManager.createNativeQuery("create table if not exists users " +
                "(id integer not null auto_increment primary key, name varchar(15), " +
                "lastName varchar(25), age integer)");
    }

    @Override
    public void dropUsersTable() {
        entityManager.createNativeQuery("drop table if exists users");
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUserById(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    public User show(int id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u where u.id = :id", User.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<User> getAllUsers() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public void cleanUsersTable() {
        entityManager.createNativeQuery("delete from users");
    }
}
