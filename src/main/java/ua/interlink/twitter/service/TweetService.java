package ua.interlink.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.interlink.twitter.dao.TweetDAO;
import ua.interlink.twitter.entity.Tweet;
import ua.interlink.twitter.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 03/11/13
 * Time: 20:14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TweetService {

    @Autowired
    private TweetDAO tweetDAO;

    @Transactional
    public void addTweet(String tweet, UserInfo userInfo) {
       try{
        tweetDAO.addTweet(tweet, userInfo);
       } catch (Exception e) {
           System.out.println(e);
       }
    }

    @Transactional
    public List getTweets(UserInfo userInfo) {
        return tweetDAO.getTweetsByUser(userInfo);
    }
}
