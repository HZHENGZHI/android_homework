package com.kk.pojo;

public class book {
    private String book_name;
    private String category;
    private String book_price;

    public book() {
    }

    public book(String book_name, String category, String book_price) {
        this.book_name = book_name;
        this.category = category;
        this.book_price = book_price;
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
        return "book{" +
                "book_name='" + book_name + '\'' +
                ", category='" + category + '\'' +
                ", book_price='" + book_price + '\'' +
                '}';
    }
}
