package com.theironyard;

/**
 * Created by VeryBarry on 11/2/16.
 */
public class Person {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String country;
    public String ip;

    public Person() {
    }
    public Person(int id, String firstName, String lastName, String email, String country, String ip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ip = ip;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName + " from " + country;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    
}