package com.inventory.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "reference", unique = true)
    @NotNull
    private String reference;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "date_established")
    private Date dateEstablished;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    protected Business() {}

    public Business(String reference, String name, Date dateEstablished, String email){
        this.reference = reference;
        this.name = name;
        this.dateEstablished = dateEstablished;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(Date dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
