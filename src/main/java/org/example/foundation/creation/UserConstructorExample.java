package org.example.foundation.creation;

public class UserConstructorExample {
    private String name;
    private double id;

    public UserConstructorExample (String name) {
        this.name = name;
    }

    // constructor overload
    public UserConstructorExample(String name, double id) {
        this.name = name;
        this.id = id;
    }
}

