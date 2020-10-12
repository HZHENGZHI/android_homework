package model;

public class user {
    private Integer userid;
    private String  pw;

    public user(Integer userid, String pw) {
        this.userid = userid;
        this.pw = pw;
    }


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPw() {
        return pw;
    }
}
