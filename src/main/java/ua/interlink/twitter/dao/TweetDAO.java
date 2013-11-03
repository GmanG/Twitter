package ua.interlink.twitter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.interlink.twitter.entity.Tweet;
import ua.interlink.twitter.entity.User;
import ua.interlink.twitter.entity.UserInfo;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 03/11/13
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class TweetDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addTweet(String tweet, UserInfo userInfo) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Tweet tweetEntity = new Tweet();
        tweetEntity.setTweet(tweet);
        tweetEntity.setUserInfo(userInfo);
        tweetEntity.setCreated(new Date());
        session.save(tweetEntity);
        tx.commit();
        session.close();
    }

    public List<Tweet> getTweetsByUser(UserInfo userInfo) {
        return sessionFactory.getCurrentSession().createQuery("from Tweet tw where tw.userInfo=:userInfo").setParameter("userInfo", userInfo).list();
    }
}
