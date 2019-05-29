package com.inventory.app.dto;

import com.inventory.app.model.Category;

public class CategoryDto {
    private long id;
    private String name;

    public CategoryDto(String name) {
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

    public Category toCategory(){
        Category category = new Category(name);
        category.setId(id);
        return category;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
