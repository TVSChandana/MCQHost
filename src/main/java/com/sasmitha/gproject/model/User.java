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

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
