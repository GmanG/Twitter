package ua.interlink.twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.interlink.twitter.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 02/11/13
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping (value = "/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping (value = "/usercheck", method = RequestMethod.GET)
//    @ResponseBody
    public String getUserByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        boolean isExist = false;
        isExist = userService.getUserByEmailAndPassword(email, password);
        if(isExist) {
            System.out.println("if "+isExist);
            return "redirect:error.jsp";
        }
        System.out.println(isExist);
        return "redirect:home";
    }
    @RequestMapping (value = "/error", method = RequestMethod.GET)
    public String getError() {
        return "error";
    }
}
