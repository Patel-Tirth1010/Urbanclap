package com.example.vollydemo;

import android.util.Log;

public class Retrieve {

    private String id;
    private String fname;
    private String lname;
    private String ph_no;
    private String email;
    private String address;
    private String city;
    private String state;
    private String pincode;
    private String password;
//  String lname, String ph_no, String email, String address, String city, String state, String pincode, String password

    public Retrieve(String id, String fname,String lname, String ph_no, String email, String address, String city, String state, String pincode, String password) {
        this.id=id;
        this.fname = fname;
        this.lname = lname;
        this.ph_no = ph_no;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Retrieve() {

    }

    public String getFname() {
        return fname;
//        Log.d("Retrive", "getFname: ");
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

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

