package com.kk.pojo;

public class order_list_table {
    private String time;
    private String allbookname;
    private String shoppinger_address;
    private String shoppinger;
    private String total_price;

    public order_list_table() {
    }

    public order_list_table(String time, String allbookname, String shoppinger_address, String shoppinger, String total_price) {
        this.time = time;
        this.allbookname = allbookname;
        this.shoppinger_address = shoppinger_address;
        this.shoppinger = shoppinger;
        this.total_price = total_price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAllbookname() {
        return allbookname;
    }

    public void setAllbookname(String allbookname) {
        this.allbookname = allbookname;
    }

    public String getShoppinger_address() {
        return shoppinger_address;
    }

    public void setShoppinger_address(String shoppinger_address) {
        this.shoppinger_address = shoppinger_address;
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

    @Override
    public String toString() {
        return "order_list_table{" +
                "time='" + time + '\'' +
                ", allbookname='" + allbookname + '\'' +
                ", shoppinger_address='" + shoppinger_address + '\'' +
                ", shoppinger='" + shoppinger + '\'' +
                ", total_price='" + total_price + '\'' +
                '}';
    }
}
