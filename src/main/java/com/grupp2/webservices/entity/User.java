package com.grupp2.webservices.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    @Id
    @Column(unique=true)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;


    public User(Long id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
