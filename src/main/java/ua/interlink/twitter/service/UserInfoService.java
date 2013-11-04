package ua.interlink.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.interlink.twitter.dao.UserInfoDAO;
import ua.interlink.twitter.entity.User;
import ua.interlink.twitter.entity.UserInfo;

import javax.transaction.Transaction;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 03/11/13
 * Time: 20:24
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Transactional
    public UserInfo getUserInfoByName(String name) {
        return userInfoDAO.getUserInfoByName(name);
    }

    @Transactional
    public void addUserFullName(String fullname, User user) {
        userInfoDAO.addUserFullName(fullname, user);
    }
}
