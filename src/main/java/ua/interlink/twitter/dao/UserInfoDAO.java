package ua.interlink.twitter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.interlink.twitter.entity.User;
import ua.interlink.twitter.entity.UserInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 03/11/13
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserInfoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Long tweetCount;

    public UserInfo getUserInfoByName(String name) {
        UserInfo userInfo = (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo ui where ui.userNick=:name").setParameter("name", name).uniqueResult();
//        return (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo ui where ui.userNick=:name").setParameter("name", name).uniqueResult();
//        tweetCount = sessionFactory.getCurrentSession().createQuery("select count(*) from UserInfo ").uniqueResult().longValue();
        return userInfo;
    }
    public UserInfo getUserInfoById(int id) {
        UserInfo userInfo = (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo ui where ui.id=:id").setParameter("id", id).uniqueResult();
//        return (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo ui where ui.userNick=:name").setParameter("name", name).uniqueResult();
//        tweetCount = sessionFactory.getCurrentSession().createQuery("select count(*) from UserInfo ").uniqueResult().longValue();
        return userInfo;
    }

    public void addUserFullName(String fullName, User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        userInfo.setUserNick(fullName);
        session.save(userInfo);
        tx.commit();
        session.close();
    }
}
