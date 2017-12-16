package com.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;


@Entity(name = "user")
public class UserDetails {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
