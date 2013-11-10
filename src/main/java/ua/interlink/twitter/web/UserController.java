package ua.interlink.twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.interlink.twitter.entity.User;
import ua.interlink.twitter.service.UserService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 02/11/13
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping (value = "getuser", method =  RequestMethod.GET)
    public @ResponseBody
    String getUser() {
        List<User> user =  userService.getUser();
        return null;
    }
}
