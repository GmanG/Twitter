package ua.interlink.twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.interlink.twitter.entity.User;
import ua.interlink.twitter.service.RegistrationService;
import ua.interlink.twitter.service.UserInfoService;
import ua.interlink.twitter.service.UserService;


/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 02/11/13
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @RequestMapping(value =  "registration", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestParam String fullName, @RequestParam String email, @RequestParam String password) {
        boolean  check = false;
        check = registrationService.chechUserEmail(email);
        if (!check) {
            registrationService.createUser(fullName.replaceAll("\\s+",""), email, password);
            User user = userService.getUserByEmail(email);
            userInfoService.addUserFullName(fullName, user);
            return "success";
        } else {
            return "error";
        }
    }
}
