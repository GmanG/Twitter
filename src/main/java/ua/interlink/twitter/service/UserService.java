package ua.interlink.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.interlink.twitter.dao.UserDAO;
import ua.interlink.twitter.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 02/11/13
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public List<User> getUser() {
        return userDAO.getUser();
    }

    @Transactional
    public boolean getUserByEmailAndPassword(String email, String password) {
        User user = userDAO.getUserByEmailAndPassword(email, password);
        if(user == null) {
            return false;
        }
        return true;
    }

    @Transactional
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
}
