package com.freightfox.pdfgenerator.entity;

public class Item {

    private String name;
    private String quantity;
    private Double rate;
    private Double amount;

    public Item(String name, String quantity, Double rate, Double amount) {
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", rate=" + rate +
                ", amount=" + amount +
                '}';
    }
}
