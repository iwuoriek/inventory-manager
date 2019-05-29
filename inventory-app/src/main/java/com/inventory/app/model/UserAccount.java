package com.inventory.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    @NotNull
    private String username;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @JoinColumn(name = "business_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Business business;

    @Column(name = "role")
    @NotNull
    private String role;

    @Column(name = "password")
    @NotNull
    private String password;

    protected UserAccount() {}

    public UserAccount(String username, String firstName, String lastName, Business business, String role, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.business = business;
        this.role = role;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Business getBusiness(){
        return business;
    }

    public void setBusiness(Business business){
        this.business = business;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
