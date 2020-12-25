package com.kk.pojo;

public class book_collection {
    private String userid;
    private String book_name;
    private String category;
    private String book_price;

    public book_collection() {
    }

    public book_collection(String userid, String book_name, String category, String book_price) {
        this.userid = userid;
        this.book_name = book_name;
        this.category = category;
        this.book_price = book_price;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    @Override
    public String toString() {
        return "book_collection{" +
                "userid='" + userid + '\'' +
                ", book_name='" + book_name + '\'' +
                ", category='" + category + '\'' +
                ", book_price='" + book_price + '\'' +
                '}';
    }
}
