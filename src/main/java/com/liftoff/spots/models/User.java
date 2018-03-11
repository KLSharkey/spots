package com.liftoff.spots.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "You must sign up with your email.")
    private String email;

    @NotNull
    @Size(min=3, message = "Please enter in a valid password.")
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {}

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

    public List<Spot> getSpots() {
        return spots;
    }
}
