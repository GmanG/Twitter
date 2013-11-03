package ua.interlink.twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.interlink.twitter.service.RegsiterService;


/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 02/11/13
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserRegisterController {

    @Autowired
    private RegsiterService registerService;

    @RequestMapping(value =  "register", method = RequestMethod.POST)
    public  @ResponseBody
    String register(@RequestParam String mail, @RequestParam String pass) {
        System.out.println(mail+" =:::::="+pass);

        boolean  check = registerService.getRegisterUser(mail);
        if (!check) {
            System.out.println("user can be created");
        }
        System.out.println("user exist");
        return null;
    }
}
