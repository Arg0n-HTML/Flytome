package com.cubes.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private final String Name;
    private final String Email;
    private final String Password;
    private final Integer Id_user;

    public User(@JsonProperty("Name")String name,
                @JsonProperty("Email")String email,
                @JsonProperty("Password")String password,
                @JsonProperty("Id_user")Integer id_user)
    {
        Name = name;
        Email = email;
        Password = password;
        Id_user = id_user;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public Integer getId_user() {
        return Id_user;
    }
}
