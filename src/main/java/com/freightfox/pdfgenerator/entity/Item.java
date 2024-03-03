package com.freightfox.pdfgenerator.entity;

import java.util.Objects;

public class Item {

    private String name;
    private String quantity;
    private Double rate;
    private Double amount;

    public Item() {
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;

        if (!Objects.equals(name, item.name)) return false;
        if (!Objects.equals(quantity, item.quantity)) return false;
        if (!Objects.equals(rate, item.rate)) return false;
        return Objects.equals(amount, item.amount);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
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
