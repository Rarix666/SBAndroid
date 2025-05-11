package com.example.sbandroid;

public class User {
    private int id;
    private String Name;
    private String Password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public User(int id, String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
        this.id = id;
    }
}
