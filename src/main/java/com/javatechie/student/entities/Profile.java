package com.javatechie.student.entities;

import com.javatechie.student.entities.User;

import javax.persistence.*;
import java.util.List;

//we need to give the database a name and password so we can execute the persistence on postgresql
@Entity
@Table
public class Profile {
    @Id
    @SequenceGenerator(
            name= "profile_sequence",
            sequenceName = "profile_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "profile_sequence"
    )
    private long profileId;
    private String name;
    private Boolean access1;
    private Boolean access2;
    private Boolean access3;
    private Boolean access4;

    @OneToMany(mappedBy = "profile")
    private List<User> userList;

    public Profile() {
    }

    public Profile(String name, List<User> listUser) {
        this.name = name;
        //this.listUser = listUser;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAccess1() {
        return access1;
    }

    public void setAccess1(Boolean access1) {
        this.access1 = access1;
    }

    public Boolean getAccess2() {
        return access2;
    }

    public void setAccess2(Boolean access2) {
        this.access2 = access2;
    }

    public Boolean getAccess3() {
        return access3;
    }

    public void setAccess3(Boolean access3) {
        this.access3 = access3;
    }

    public Boolean getAccess4() {
        return access4;
    }

    public void setAccess4(Boolean access4) {
        this.access4 = access4;
    }
}

