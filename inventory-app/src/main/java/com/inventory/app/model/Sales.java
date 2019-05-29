package com.inventory.app.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sales {
    @Id
    @Column
    private String id;

    @Column
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sales", fetch = FetchType.EAGER)
    private List<SalesEntry> entries = new ArrayList<>();

    @Column
    private double total;

    protected Sales() {}

    public Sales(String id, Date date, double total) {
        this.id = id;
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

    public List<SalesEntry> getEntries() {
        return entries;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
