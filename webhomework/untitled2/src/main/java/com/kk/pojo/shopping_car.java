package com.kk.pojo;

public class shopping_car {
    private String userid;
    private String book_name;
    private String book_nums;
    private String book_price;

    public shopping_car(String userid, String book_name, String book_nums, String book_price) {
        this.userid = userid;
        this.book_name = book_name;
        this.book_nums = book_nums;
        this.book_price = book_price;
    }

    public shopping_car() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
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
        return "shopping_car{" +
                "userid='" + userid + '\'' +
                ", book_name='" + book_name + '\'' +
                ", book_nums='" + book_nums + '\'' +
                ", book_price='" + book_price + '\'' +
                '}';
    }
}
