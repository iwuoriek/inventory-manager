package com.inventory.app.dto;

import com.inventory.app.model.SalesEntry;

public class SalesEntryDto {
    private long id;
    //private SalesDto salesDto;
    private ProductDto productDto;
    private int quantity;
    private double total;

    public SalesEntryDto(ProductDto productDto, int quantity, double total) {
        //this.salesDto = salesDto;
        this.productDto = productDto;
        this.quantity = quantity;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

/*    public SalesDto getSalesDto() {
        return salesDto;
    }

    public void setSalesDto(SalesDto salesDto) {
        this.salesDto = salesDto;
    }*/

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SalesEntryDto{" +
                "id=" + id +
                //", salesDto=" + salesDto.getId() +
                ", productDto=" + productDto +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
