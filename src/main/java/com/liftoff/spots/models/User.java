package com.liftoff.spots.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity //store class in DB
public class User {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    @JoinColumn(name = "user_ID")
    private List<Spot> spots = new ArrayList<>();

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
