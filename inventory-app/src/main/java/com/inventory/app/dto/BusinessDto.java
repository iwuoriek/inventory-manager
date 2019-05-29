package com.inventory.app.dto;

import com.inventory.app.model.Business;

import java.util.Date;

public class BusinessDto {
    private long id;
    private String reference;
    private String name;
    private Date dateEstablished;
    private String email;

    public BusinessDto() {}

    public BusinessDto(String name, Date dateEstablished, String email) {
        this.name = name;
        this.dateEstablished = dateEstablished;
        this.email = email;
    }

    public BusinessDto(String reference, String name, Date dateEstablished, String email) {
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

    public Business toBusiness(){
        Business business = new Business(reference, name, dateEstablished, email);
        business.setId(id);
        return business;
    }

    @Override
    public String toString() {
        return "BusinessDto{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", name='" + name + '\'' +
                ", dateEstablished=" + dateEstablished +
                ", email='" + email + '\'' +
                '}';
    }
}
