package com.shopping.app.dto;

public class Customer {

    int id;
    String fname;
    String lname;
    String address;
    int postal_code;
    int phone_number;
    String email;

    public Customer(int id, String fname, String lname, String address, int postal_code, int phone_number, String email) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.postal_code = postal_code;
        this.phone_number = phone_number;
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

}



