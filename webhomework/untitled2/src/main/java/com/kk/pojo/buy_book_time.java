package com.kk.pojo;

public class buy_book_time {
    private String userid;
    //用户id
    private long timeMils;
    //时间戳
    private String book_name;
    //书本名
    private String book_nums;
    //书本数量
    private String book_price;
    //单价


    public buy_book_time() {
    }

    public buy_book_time(String userid, long timeMils, String book_name, String book_nums, String book_price) {
        this.userid = userid;
        this.timeMils = timeMils;
        this.book_name = book_name;
        this.book_nums = book_nums;
        this.book_price = book_price;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public long getTimeMils() {
        return timeMils;
    }

    public void setTimeMils(long timeMils) {
        this.timeMils = timeMils;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBookname(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_nums() {
        return book_nums;
    }

    public void setBook_nums(String book_nums) {
        this.book_nums = book_nums;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    @Override
    public String toString() {
        return "buy_book_time{" +
                "userid='" + userid + '\'' +
                ", timeMils=" + timeMils +
                ", bookname='" + book_name + '\'' +
                ", book_nums='" + book_nums + '\'' +
                ", book_price='" + book_price + '\'' +
                '}';
    }
}
