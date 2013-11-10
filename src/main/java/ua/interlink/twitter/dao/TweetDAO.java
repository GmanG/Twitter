package ua.interlink.twitter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.interlink.twitter.entity.Tweet;
import ua.interlink.twitter.entity.UserInfo;
import ua.interlink.twitter.utils.TweetDTO;

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

    public List getTweetsByUser(UserInfo userInfo) {
        return sessionFactory.getCurrentSession().
               createSQLQuery("select t.id as ids, t.tweet as message, t.created as dat, t.user_info_id as userid " +
                               "from user_info ui  " +
                               "join follower f on f.owner_id = ui.id " +
                               "join tweet t on t.user_info_id = f.listener_id or t.user_info_id = ui.id and ui.id != ui.id " +
                               "where ui.id = 2 " +
                               "order by t.created desc limit 5").
               setResultTransformer(Transformers.aliasToBean(TweetDTO.class)).list();
    }
// Maybe later remake  to HQL
//        return sessionFactory.getCurrentSession().createQuery("from UserInfo ui  " +
//                "join Follower f with (f.ownerId = ui.id) " +
//                "join Tweet t with (t.userInfo = f.listener_id or t.userInfo = ui.id) " +
//                "where ui.id = :userInfo " +
//                "order by t.created desc ").setParameter("userInfo", userInfo).setFirstResult(0).setMaxResults(19).list();
}
