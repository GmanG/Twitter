package ua.interlink.twitter.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.interlink.twitter.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 02/11/13
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class RegisterDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public User getRegsiterUser (String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where email=:email").setParameter("email", email).uniqueResult();
    }
}
