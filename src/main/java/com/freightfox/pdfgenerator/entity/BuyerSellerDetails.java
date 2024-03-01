package com.freightfox.pdfgenerator.entity;

import java.util.List;

public class BuyerSellerDetails {

    private String seller;
    private String sellerGstin;
    private String sellerAddress;
    private String buyer;
    private String buyerGstin;
    private String buyerAddress;
    private List<Item> items;

    public String getSeller() {
        return seller;
    }

    public String getSellerGstin() {
        return sellerGstin;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public String getBuyer() {
        return buyer;
    }

    public String getBuyerGstin() {
        return buyerGstin;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public List<Item> getItems() {
        return items;
    }

    public BuyerSellerDetails() {
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public void setSellerGstin(String sellerGstin) {
        this.sellerGstin = sellerGstin;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public void setBuyerGstin(String buyerGstin) {
        this.buyerGstin = buyerGstin;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "BuyerSellerDetails{" +
                "seller='" + seller + '\'' +
                ", sellerGstin='" + sellerGstin + '\'' +
                ", sellerAddress='" + sellerAddress + '\'' +
                ", buyer='" + buyer + '\'' +
                ", buyerGstin='" + buyerGstin + '\'' +
                ", buyerAddress='" + buyerAddress + '\'' +
                ", items=" + items +
                '}';
    }
}

