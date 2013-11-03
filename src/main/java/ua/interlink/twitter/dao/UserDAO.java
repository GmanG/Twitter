package ua.interlink.twitter.dao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.interlink.twitter.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 02/11/13
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getUser() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User user where user.email=:email and user.password=:password").setParameter("email", email).setParameter("password", password).uniqueResult();
    }

    public User getUserByEmail(String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User user where user.email=:email").setParameter("email", email).uniqueResult();
    }
}
