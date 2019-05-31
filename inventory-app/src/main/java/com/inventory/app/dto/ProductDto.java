package com.inventory.app.dto;

import com.inventory.app.model.Product;

public class ProductDto {
    private long id;
    private String name;
    private BrandDto brandDto;
    private CategoryDto categoryDto;
    private int quantity;
    private double price;

    public ProductDto() {}

    public ProductDto(long id, String name, BrandDto brandDto, CategoryDto categoryDto, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.brandDto = brandDto;
        this.categoryDto = categoryDto;
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

    public BrandDto getBrandDto() {
        return brandDto;
    }

    public void setBrandDto(BrandDto brand) {
        this.brandDto = brand;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto category) {
        this.categoryDto = category;
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

    public Product toProduct(){
        return new Product(id, name, brandDto.toBrand(), categoryDto.toCategory(), quantity, price);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandDto=" + brandDto +
                ", categoryDto=" + categoryDto +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
