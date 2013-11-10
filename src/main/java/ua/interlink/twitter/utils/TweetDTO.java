package ua.interlink.twitter.utils;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 10/11/13
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 * As i understand getters and setter -
 */
public class TweetDTO {

    private int ids;
    private String message;
    private Date dat;
    private int userid;

    public TweetDTO() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return ids;
    }

    public void setId(int id) {
        this.ids = id;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

//    public int getUserid() {
//        return userid;
//    }
//
//    public void setUserid(int userid) {
//        this.userid = userid;
//    }
}
