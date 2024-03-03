package com.freightfox.pdfgenerator.entity;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class BuyerSellerDetails {

    @Length(max = 40, min = 1)
    private String seller;

    @Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$")
    private String sellerGstin;

    private String sellerAddress;

    @Length(max = 40, min = 1)
    private String buyer;

    @Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuyerSellerDetails that)) return false;

        if (!Objects.equals(seller, that.seller)) return false;
        if (!sellerGstin.equals(that.sellerGstin)) return false;
        if (!Objects.equals(sellerAddress, that.sellerAddress))
            return false;
        if (!Objects.equals(buyer, that.buyer)) return false;
        if (!buyerGstin.equals(that.buyerGstin)) return false;
        if (!Objects.equals(buyerAddress, that.buyerAddress)) return false;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        int result = seller != null ? seller.hashCode() : 0;
        result = 31 * result + sellerGstin.hashCode();
        result = 31 * result + (sellerAddress != null ? sellerAddress.hashCode() : 0);
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        result = 31 * result + buyerGstin.hashCode();
        result = 31 * result + (buyerAddress != null ? buyerAddress.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
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

