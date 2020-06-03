/*

Name: Francisco Ozuna Diaz
Assignment: CS 7455 Lab 2

 */
package com.example.lab2;

public class Pizza {
    double crust_price = 0;
    double topping_count = 0;
    double toGo_price = 0;
    double size = 0;

    public Pizza() {
    }

    public double getCrust_price() {
        return crust_price;
    }

    public void setCrust_price(double crust_price) {
        this.crust_price = crust_price;
    }

    public double getTopping_count() {
        return topping_count;
    }

    public void setTopping_count(double topping_count) {
        this.topping_count = topping_count;
    }

    public double getToGo_price() {
        return toGo_price;
    }

    public void setToGo_price(double toGo_price) {
        this.toGo_price = toGo_price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
