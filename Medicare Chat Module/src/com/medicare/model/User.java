/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicare.model;


public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
    
    public User(int id, String name, String username, String email, String address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public User(String name, String username, String password, String email, String address) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String Name, String Username, String Password, String Email, String Address) {
       this.name = Name;
        this.username = Username;
        this.email = Email;
        this.address = Address;
        this.password = Password;
        this.id = id;
    }


   

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

  

   

    
}
    
