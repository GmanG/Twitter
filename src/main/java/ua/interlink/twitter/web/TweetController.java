package ua.interlink.twitter.web;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.interlink.twitter.entity.Tweet;
import ua.interlink.twitter.entity.UserInfo;
import ua.interlink.twitter.service.TweetService;
import ua.interlink.twitter.service.UserInfoService;
import ua.interlink.twitter.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 03/11/13
 * Time: 19:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping (value = "/")
public class TweetController {

    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping (value = "addTweet")
    @ResponseBody
    public String addTweet(@RequestParam String tweet/*, @RequestParam String userName*/) {
        UserInfo userInfo = userInfoService.getUserInfoByName("TestDev");
//        if(userInfo == null) {
//            System.out.println("no such user");
//        }
        tweetService.addTweet(tweet, userInfo);
        return null;
    }

    @RequestMapping (value = "getTweets", method = RequestMethod.POST)
    @ResponseBody
    public String getTweets(/*@RequestParam String userName*/) {
        UserInfo userInfo = userInfoService.getUserInfoByName("TestDev");
        List tweets = tweetService.getTweets(userInfo);
        String result = "";
        ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            result = mapper.writeValueAsString(tweets);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return result;
    }

    @RequestMapping (value = "/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public String shoTweets(@PathVariable String userName) {
        UserInfo userInfo = userInfoService.getUserInfoByName("TestDev");
        if(userInfo == null) {
            return "redirect:/";
        }
        return null;
    }

}
