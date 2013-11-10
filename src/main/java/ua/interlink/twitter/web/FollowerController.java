package ua.interlink.twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.interlink.twitter.entity.UserInfo;
import ua.interlink.twitter.service.FollowerService;
import ua.interlink.twitter.service.UserInfoService;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 09/11/13
 * Time: 17:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class FollowerController {

    @Autowired
    private FollowerService followerService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping (value = "followUser", method = RequestMethod.POST)
    @ResponseBody
    public String addFollower(@RequestParam int owner, @RequestParam int listener){
        UserInfo ownerUser = new UserInfo();
        UserInfo listenerUser = new UserInfo();
        System.out.println(owner+" ///6 "+listener);
        ownerUser = userInfoService.getUserInfoById(6);
        listenerUser = userInfoService.getUserInfoById(2);
//        if(listenerUser == null) {
//            System.out.println("shit hap");
//        }
        System.out.println(ownerUser+"+++++++++-------------------"+listenerUser);
        followerService.addFollower(ownerUser, listenerUser);
        return null;
    }
}
