package com.kk.pojo;

public class User {
    private String userid;
    private String userpw;
    private String truename;
    private String birthday;
    private String sex;

    public User(String userid, String userpw, String truename, String birthday, String sex) {
        this.userid = userid;
        this.userpw = userpw;
        this.truename = truename;
        this.birthday = birthday;
        this.sex = sex;
    }

    public User() {
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

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", userpw='" + userpw + '\'' +
                ", truename='" + truename + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
