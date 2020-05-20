package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUser() {
        Query query = entityManager.createQuery("SELECT e FROM User e");
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public boolean isNotReg(String name) {
        return getAllUser()
                .stream()
                .anyMatch((e) -> e.getUsername().equals(name));
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByName(String name) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.name = ?1")
                .setParameter(1, name);
        List<User> list = (List<User>) query.getResultList();
        return list.get(0);
    }
}
