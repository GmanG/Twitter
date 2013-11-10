package ua.interlink.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.interlink.twitter.dao.FollowerDAO;
import ua.interlink.twitter.entity.UserInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 09/11/13
 * Time: 17:15
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FollowerService {

    @Autowired
    private FollowerDAO followerDAO;

    @Transactional
    public void addFollower(UserInfo owner, UserInfo listener) {
        followerDAO.addFollower(owner, listener);
    }
}
