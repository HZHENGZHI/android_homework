package com.kk.pojo;

public class admin_user {
    private String adminid;
    private String adminpw;

    public admin_user() {
    }

    public admin_user(String adminid, String adminpw) {
        this.adminid = adminid;
        this.adminpw = adminpw;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getAdminpw() {
        return adminpw;
    }

    public void setAdminpw(String adminpw) {
        this.adminpw = adminpw;
    }

    @Override
    public String toString() {
        return "admin_user{" +
                "adminid='" + adminid + '\'' +
                ", adminpw='" + adminpw + '\'' +
                '}';
    }
}
