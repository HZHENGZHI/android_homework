package model;

public class user {
    private String userid;
    private String  pw;
    private String  staut;

    public user(String userid, String pw,String staut) {
        this.userid = userid;
        this.pw = pw;
        this.staut=staut;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPw() {
        return pw;
    }

    public void setStaut(String staut) {
        this.staut = staut;
    }
    public String getStaut() {
        return staut;
    }


}
