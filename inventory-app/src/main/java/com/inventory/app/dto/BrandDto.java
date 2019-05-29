package com.inventory.app.dto;

import com.inventory.app.model.Brand;

public class BrandDto {
    private long id;
    private String name;

    public BrandDto(String name) {
        this.name = name;
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

    public Brand toBrand(){
        Brand brand = new Brand(name);
        brand.setId(id);
        return brand;
    }

    @Override
    public String toString() {
        return "BrandDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
