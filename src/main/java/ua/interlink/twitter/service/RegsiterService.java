package ua.interlink.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.interlink.twitter.dao.RegisterDAO;
import ua.interlink.twitter.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 02/11/13
 * Time: 22:09
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RegsiterService {

    @Autowired
    private RegisterDAO registerDAO;

    @Transactional
    public boolean getRegisterUser(String email) {
        User user = registerDAO.getRegsiterUser(email);
        if(user == null) {
            return false;
        }
        return true;
    }
}
