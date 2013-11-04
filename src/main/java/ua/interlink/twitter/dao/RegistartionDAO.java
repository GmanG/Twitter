package ua.interlink.twitter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.interlink.twitter.entity.User;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 02/11/13
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class RegistartionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public User getRegsiterUser(String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where email=:email").setParameter("email", email).uniqueResult();
    }

    public void createUser(String fullname, String email, String password) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = new User();
        user.setFullName(fullname);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreated(new Date());
        session.save(user);
        tx.commit();
        session.close();
    }
}
