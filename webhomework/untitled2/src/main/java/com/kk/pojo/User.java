package com.pojo;

public class user {
    private String userid;
    private String userpw;

    public user() {
    }

    public user(String userid, String userpw) {
        this.userid = userid;
        this.userpw = userpw;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    @Override
    public String toString() {
        return "user{" +
                "userid='" + userid + '\'' +
                ", userpw='" + userpw + '\'' +
                '}';
    }
}
