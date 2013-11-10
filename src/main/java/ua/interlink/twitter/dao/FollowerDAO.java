package ua.interlink.twitter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.interlink.twitter.entity.Follower;
import ua.interlink.twitter.entity.User;
import ua.interlink.twitter.entity.UserInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 09/11/13
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class FollowerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addFollower(UserInfo owner, UserInfo listener) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Follower  follower = new Follower();
        follower.setOwnerId(owner);
        follower.setListenerId(listener);
        session.save(follower);
        tx.commit();
        session.close();
    }
}
