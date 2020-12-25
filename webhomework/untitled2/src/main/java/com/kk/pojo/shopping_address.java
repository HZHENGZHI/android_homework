package com.kk.pojo;

public class shopping_address {
    private String userid;
    private String shoppinger;
    private String shopping_address;
    private String phone;
    private String sigin;

    public shopping_address() {
    }

    public shopping_address(String userid, String shoppinger, String shopping_address, String phone, String sigin) {
        this.userid = userid;
        this.shoppinger = shoppinger;
        this.shopping_address = shopping_address;
        this.phone = phone;
        this.sigin = sigin;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getShoppinger() {
        return shoppinger;
    }

    public void setShoppinger(String shoppinger) {
        this.shoppinger = shoppinger;
    }

    public String getShopping_address() {
        return shopping_address;
    }

    public void setShopping_address(String shopping_address) {
        this.shopping_address = shopping_address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSigin() {
        return sigin;
    }

    public void setSigin(String sigin) {
        this.sigin = sigin;
    }

    @Override
    public String toString() {
        return "shopping_address{" +
                "userid='" + userid + '\'' +
                ", shoppinger='" + shoppinger + '\'' +
                ", shopping_address='" + shopping_address + '\'' +
                ", phone='" + phone + '\'' +
                ", sigin='" + sigin + '\'' +
                '}';
    }
}
