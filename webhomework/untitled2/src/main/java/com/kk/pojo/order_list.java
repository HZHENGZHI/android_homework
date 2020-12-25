package com.kk.pojo;

import java.util.List;

public class order_list {
    private String userid;
    private String time;
    private List<buy_book_time> buy_book_time;
    private String shopping_address;
    private String shoppinger;
    private String total_price;
    private String sigin;

    public order_list(String userid, String time, List<com.kk.pojo.buy_book_time> buy_book_time, String shopping_address, String shoppinger, String total_price, String sigin) {
        this.userid = userid;
        this.time = time;
        this.buy_book_time = buy_book_time;
        this.shopping_address = shopping_address;
        this.shoppinger = shoppinger;
        this.total_price = total_price;
        this.sigin = sigin;
    }

    public order_list() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<com.kk.pojo.buy_book_time> getBuy_book_time() {
        return buy_book_time;
    }

    public void setBuy_book_time(List<com.kk.pojo.buy_book_time> buy_book_time) {
        this.buy_book_time = buy_book_time;
    }

    public String getShopping_address() {
        return shopping_address;
    }

    public void setShopping_address(String shopping_address) {
        this.shopping_address = shopping_address;
    }

    public String getShoppinger() {
        return shoppinger;
    }

    public void setShoppinger(String shoppinger) {
        this.shoppinger = shoppinger;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getSigin() {
        return sigin;
    }

    public void setSigin(String sigin) {
        this.sigin = sigin;
    }

    @Override
    public String toString() {
        return "order_list{" +
                "userid='" + userid + '\'' +
                ", time='" + time + '\'' +
                ", buy_book_time=" + buy_book_time +
                ", shopping_address='" + shopping_address + '\'' +
                ", shoppinger='" + shoppinger + '\'' +
                ", total_price='" + total_price + '\'' +
                ", sigin='" + sigin + '\'' +
                '}';
    }
}
