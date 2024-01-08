package com.example.myappeight;

public class DataModel {

    String year;
    int sales;

    public DataModel(String year, int sales) {
        this.year = year;
        this.sales = sales;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

}
