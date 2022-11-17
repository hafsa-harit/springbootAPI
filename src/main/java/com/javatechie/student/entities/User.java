package com.javatechie.student.entities;

import javax.persistence.*;
//User is a reserved name at postgresql so we need to change the table name at the database by another name
@Entity
@Table(name = "myUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private  String email;
    private  String phone;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "fk_profile_user",referencedColumnName = "profileId",nullable = false)
    private Profile profile;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
