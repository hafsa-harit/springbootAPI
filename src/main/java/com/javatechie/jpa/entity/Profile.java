package com.javatechie.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Profile {
    @Id
    @SequenceGenerator(
            name= "sequence",
            sequenceName = "sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "sequence"
    )
    private int id;
    private String name;
    private Boolean access1;
    private Boolean access2;
    @OneToMany(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "id")
    private List<User> users;
}
