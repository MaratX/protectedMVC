package com.springapp.mvc;

/**
 * Created by Marat on 22.06.2016.
 */
public class Users {
    private int Id;
    private String Name;



    private String LastName;

    public Users(int id, String name, String lastName) {
        Id = id;
        Name = name;
        LastName = lastName;
    }

    public int getId() {
        return Id;
    }

    public String getName() {

        return Name;
    }

    public String getLastName() {
        return LastName;
    }


    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setName(String name) {
        Name = name;
    }
}
