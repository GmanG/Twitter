package ua.interlink.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.interlink.twitter.dao.RegistartionDAO;
import ua.interlink.twitter.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 02/11/13
 * Time: 22:09
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RegistrationService {

    @Autowired
    private RegistartionDAO registartionDAO;

    @Transactional
    public boolean chechUserEmail(String email) {
        User user = registartionDAO.getRegsiterUser(email);
        if(user == null) {
            return false;
        }
        return true;
    }

    @Transactional
    public void createUser(String fullname, String email, String password) {
        registartionDAO.createUser(fullname, email, password);
    }
}
