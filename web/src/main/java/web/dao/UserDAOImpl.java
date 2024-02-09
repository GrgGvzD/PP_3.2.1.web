package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;


import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers () {
       return entityManager.createQuery("select user from User user").getResultList();
    }
    @Override
    public User getUserById(long id) {
         return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(long id) {
        entityManager.remove(entityManager.find(User.class,id));
    }

    @Override
    public void updateUser(User user) {
        User editUser = getUserById(user.getId());
        if (editUser != null) {
            entityManager.merge(user);
        }

    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

}
