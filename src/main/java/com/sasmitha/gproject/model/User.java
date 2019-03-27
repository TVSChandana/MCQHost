package com.sasmitha.gproject.model;

import javax.persistence.*;

@Entity
@Table(name ="User_Table")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    @Column(name = "first_name")
    private  String firstName;

    @Column(name = "last_name")
    private  String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    public String getConPassword() {
        return conPassword;
    }

    public void setConPassword(String conPassword) {
        this.conPassword = conPassword;
    }

    @Column(name = "password")
    private String password;

    @Column(name = "confirm_password")
    private String conPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
