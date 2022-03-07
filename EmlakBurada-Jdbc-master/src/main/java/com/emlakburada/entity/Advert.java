package com.emlakburada.entity;

import java.math.BigDecimal;

public class Advert {
    private int id;
    private int advertNo;
    private String title;
    private String description;
    private BigDecimal price;

    public Advert() {}

    public Advert(int id, int advertNo, String title, String description) {
        this.id = id;
        this.advertNo = advertNo;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdvertNo() {
        return advertNo;
    }

    public void setAdvertNo(int advertNo) {
        this.advertNo = advertNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Advert [id = " + id
                + ", advertNo = " + advertNo
                + ", title = " + title
                + ", description = " + description
                + ", price = " + price;
    }
}