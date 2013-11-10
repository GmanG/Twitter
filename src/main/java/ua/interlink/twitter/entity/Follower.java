package ua.interlink.twitter.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 03/11/13
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Follower implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "listener_id")
    private UserInfo listenerId;

    @ManyToOne
    @JoinColumn (name = "owner_id")
    private UserInfo ownerId;



    public Follower() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UserInfo ownerId) {
        this.ownerId = ownerId;
    }

    public UserInfo getListenerId() {
        return listenerId;
    }

    public void setListenerId(UserInfo listenerId) {
        this.listenerId = listenerId;
    }
}
