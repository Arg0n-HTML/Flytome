package com.cubes.Services;

public class User {
    public final String Name;
    public final String Email;
    public final String Password;
    
    public User() {
		this.Name = "";
		this.Email = "";
		this.Password = "";
    }
    
    public User(String name,
            String email,
            String password)
            {
                Name = name;
                Email = email;
                Password = password;
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
}