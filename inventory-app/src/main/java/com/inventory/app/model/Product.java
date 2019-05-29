package com.inventory.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    @Column
    private long id;

    @Column
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn
    private Brand brand;

    @ManyToOne
    @JoinColumn
    private Category category;

    @Column
    private int quantity;

    @Column
    private double price;

    protected Product() {}

    public Product(long id, String name, Brand brand, Category category, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
