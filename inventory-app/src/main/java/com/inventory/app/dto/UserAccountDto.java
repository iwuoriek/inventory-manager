package com.inventory.app.dto;

import com.inventory.app.model.UserAccount;

public class UserAccountDto {
    private String username;
    private String firstName;
    private String lastName;
    private BusinessDto businessDto;
    private String role;
    private String password;

    public UserAccountDto() {}

    public UserAccountDto(String firstName, String lastName,
                          BusinessDto businessDto, String role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.businessDto = businessDto;
        this.role = role;
        this.password = password;
    }

    public UserAccountDto(String username, String firstName, String lastName,
                          BusinessDto businessDto, String role, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.businessDto = businessDto;
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

    public BusinessDto getBusinessDto() {
        return businessDto;
    }

    public void setBusinessDto(BusinessDto businessDto) {
        this.businessDto = businessDto;
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

    public UserAccount toUserAccount(){
        return new UserAccount(username, firstName, lastName, businessDto.toBusiness(), role, password);
    }

    @Override
    public String toString() {
        return "UserAccountDto{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", business=" + businessDto +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
