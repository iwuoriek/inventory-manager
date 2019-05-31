package com.inventory.app.dto;

import com.inventory.app.model.Sales;
import com.inventory.app.model.SalesEntry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesDto {
    private String id;
    private Date date;
    private List<SalesEntryDto> entryDtos = new ArrayList<>();
    private double total;

    public SalesDto() {}

    public SalesDto(Date date, double total) {
        this.date = date;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<SalesEntryDto> getEntryDtos() {
        return entryDtos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Sales toSales(){
        Sales sales = new Sales(id, date, total);
        entryDtos.forEach(salesEntryDto -> {
            SalesEntry entry = new SalesEntry(salesEntryDto.getProductDto().toProduct(),
                    salesEntryDto.getQuantity(), salesEntryDto.getTotal());
            sales.getEntries().add(entry);
        });
        return sales;
    }

    @Override
    public String toString() {
        return "SalesDto{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", entryDtos=" + entryDtos +
                ", total=" + total +
                '}';
    }
}
